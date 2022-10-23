package com.sparrow.passport.config;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.servlet.ServletContainer;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Inject
    private ServletContainer servletContainer;

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Object handle(HttpServletRequest request, BusinessException e, RedirectAttributes attr) {
        String contentType = request.getContentType();
        if (Constant.CONTENT_TYPE_FORM.equals(contentType)) {
            ModelAndView mv = new ModelAndView("redirect:/error");
            attr.addFlashAttribute("result", Result.fail(e));
            attr.addFlashAttribute("ref", servletContainer.referer());
            return mv;
        }
        return Result.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, Exception exception,RedirectAttributes attr) throws Exception {
        logger.error("global exception ",exception);
        String contentType = request.getContentType();
        if (Constant.CONTENT_TYPE_FORM.equals(contentType)) {
            ModelAndView mv = new ModelAndView("redirect:/error");
            attr.addFlashAttribute("result", Result.fail());
            attr.addFlashAttribute("ref", servletContainer.referer());
            return mv;
        }
        return Result.fail();
    }
}