package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/register")
public class SpringUserRegisterController {

    @Autowired
    private UserRegisterController userRegisterController;

    @PostMapping("/email/shortcut")
    public void shortcut(@RequestBody EmailRegisterParam user,
        ClientInformation client) throws BusinessException {
        userRegisterController.emailRegister(user, client);
    }

    @PostMapping("/email")
    public ModelAndView emailRegister(EmailRegisterParam user,
        ClientInformation client, RedirectAttributes attributes) throws BusinessException {
        this.userRegisterController.emailRegister(user, client);
        ModelAndView mv = new ModelAndView("redirect:/email-activate-send-success");
        mv.addObject("email", user.getEmail());
        attributes.addFlashAttribute("email2", user.getEmail());
        return mv;
    }

    @PostMapping("/email/activate/send.json")
    public void sendActivateEmail(EmailActivateParam user,
        ClientInformation client) throws BusinessException {
        this.userRegisterController.sendTokenToEmail(user, client);
    }

    @GetMapping("/email/activate")
    public ModelAndView activeEmail(String token, ClientInformation client) throws BusinessException {
        this.userRegisterController.activateEmail(token, client);
        return new ModelAndView("redirect:/email-activate-success");
    }
}
