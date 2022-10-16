package com.sparrow.passport.config;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.servlet.ServletContainer;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Inject
    private ServletContainer servletContainer;

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Object handle(HttpServletRequest request, BusinessException e, RedirectAttributes attr) {
        String contentType = request.getContentType();
        if (Constant.CONTENT_TYPE_FORM.equals(contentType)) {
            ModelAndView mv = new ModelAndView("redirect:/error");
            Result error = Result.fail(e);
            attr.addFlashAttribute("result", error);
            attr.addFlashAttribute("ref", servletContainer.referer());
            return mv;
        }
        if (Constant.CONTENT_TYPE_JSON.equals(contentType)) {
            return Result.fail(e);
        }
        return Result.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return Result.fail();
    }
}