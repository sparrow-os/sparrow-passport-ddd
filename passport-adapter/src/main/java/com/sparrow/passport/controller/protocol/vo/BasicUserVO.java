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
