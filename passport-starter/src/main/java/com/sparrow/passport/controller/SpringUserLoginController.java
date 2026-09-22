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

import com.alibaba.fastjson.JSON;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
@Tag(name = "UserLogin")
public class SpringUserLoginController {
    public SpringUserLoginController() {
        log.info("SpringUserLoginController");
    }

    @Autowired
    private UserLoginController userLoginController;
    private static Logger logger = LoggerFactory.getLogger(SpringUserLoginController.class);

    @GetMapping("/session-id.json")
    public String sessionId(HttpServletRequest request) throws BusinessException {
        return request.getSession().getId();
    }

    //sparrow mvc 模式下 为了与login 区分开
    @PostMapping("/login.do")
    /**
     * @RequestBody DispatcherServlet Completed 415 UNSUPPORTED_MEDIA_TYPE
     */
    public ModelAndView login(LoginQuery login,
                              ClientInformation client) throws BusinessException {
        logger.info("client info {}", JSON.toJSONString(client));
        try {
            LoginDTO loginDto = this.userLoginController.login(login, client);
            ModelAndView mv = new ModelAndView(login.getRedirectUrl());
            mv.addObject(loginDto);
            return mv;
        } catch (BusinessException e) {
            if (e.getErrorSupport().getCode().equals(PassportError.USER_NOT_ACTIVATE.getCode())) {
                ModelAndView mv = new ModelAndView("redirect:/email-activate");
                mv.addObject("email", login.getUserName());
                return mv;
            }
            throw e;
        }
    }

    @PostMapping("/shortcut-login.json")
    public LoginDTO shortcut(@RequestBody LoginQuery login, ClientInformation client) throws BusinessException {
        return this.userLoginController.shortcut(login, client);
    }


    @GetMapping("/get-visitor-token.json")
    public LoginDTO getVisitorToken(ClientInformation client) throws BusinessException {
        return this.userLoginController.getVisitorToken(client);
    }

    public void logout() {
        this.userLoginController.logout();
    }
}
