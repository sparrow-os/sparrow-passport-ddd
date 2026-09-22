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

package com.sparrow.passport.controller.protocol.vo;

import lombok.Data;

@Data
public class BasicUserVO {
    /**
     * 用户ID
     */
    private Long userId;

    private Integer category;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 英文名
     */
    private String englishName;
    /**
     * 用户名
     */
    private String nickName;
    /**
     * 头象
     */
    private String avatar;
    /**
     * 性别
     */
    private String gender;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 是否激活
     */
    private Boolean activate;
    /**
     * 激活日期
     */
    private String activateTime;
    /**
     * 注册时间
     */
    private String gmtCreate;
    /**
     * 更新时间
     */
    private String modified;
    /**
     * 最后一次登录时间
     */
    private String lastLoginTime;
    /**
     * 设备类型 PC MOBILE MAC
     */
    private String device;

    /**
     * 设备型号 5S/
     */
    private String deviceModel;
    /**
     * 网络IP 192.168.9.1
     */
    private String ip;
    /**
     * 签名
     */
    private String personalSignature;
    /**
     * 用户状态
     */
    private String status;
}
