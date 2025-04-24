package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/password")
public class SpringUserSecurityController {
    @Inject
    private UserSecurityController userSecurityController;

    @PostMapping("/send-find-password-email.json")
    public Boolean sendEmailTokenForFindPassword(String email) throws BusinessException {
        return this.userSecurityController.sendEmailTokenForFindPassword(email);
    }

    @GetMapping("/token-verify")
    public ModelAndView tokenVerify(String token) throws BusinessException {
        this.userSecurityController.tokenVerify(token);
        return new ModelAndView("/password/token-verify");
    }
    @PostMapping("/reset-password-by-token")
    public ModelAndView resetPassword(PasswordResetParam param) throws BusinessException {
        this.userSecurityController.resetPassword(param);
        return new ModelAndView("redirect:/password/reset-success");
    }
}
