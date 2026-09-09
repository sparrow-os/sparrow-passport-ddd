package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.inject.Inject;

@RestController
@RequestMapping("/password")
public class SpringUserSecurityController {
    @Inject
    private UserSecurityController userSecurityController;

    @PostMapping("/send-find-password-email.json")
    public Boolean sendEmailTokenForFindPassword(@RequestBody String email) throws BusinessException {
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
