package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class SpringUserSecurityController {
    @Inject
    private UserSecurityController userSecurityController;

    @PostMapping("/send-find-password-email")
    public Result<Boolean> sendEmailTokenForFindPassword(String email) throws BusinessException {
        return this.userSecurityController.sendEmailTokenForFindPassword(email);
    }


    @PostMapping("/reset-password-by-token")
    public void resetPassword(PasswordResetParam param) throws BusinessException {
         this.userSecurityController.resetPassword(param);
    }
}
