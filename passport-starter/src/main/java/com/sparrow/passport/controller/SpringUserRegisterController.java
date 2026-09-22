/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/register")
public class SpringUserRegisterController {

    @Autowired
    private UserRegisterController userRegisterController;

    @PostMapping("/email/shortcut.json")
    public LoginDTO shortcut(@RequestBody EmailRegisterParam user,
                             ClientInformation client) throws BusinessException {
        return userRegisterController.emailRegister(user, client);
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
