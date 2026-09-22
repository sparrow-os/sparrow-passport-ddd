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

    @PostMapping("/old-send-find-password-email.json")
    public Boolean oldSendEmailToken(@RequestParam("email") String email) throws BusinessException {
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
