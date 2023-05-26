package com.sparrow.passport.protocol.dto;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;

import java.sql.Date;

public class UserProfileDTO implements POJO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 性别
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;


    /**
     * 个性签名
     */
    private String personalSignature;


    /**
     * 生日
     */
    private Date birthday;


    /**
     * 手机号
     */

    private String mobile;

    /**
     * 最后登录时间
     */
    private Long lastLoginTime;

    /**
     * 是否激活
     */
    private Boolean activate;

    /**
     * 激活时间
     */
    private Long activateTime;
    /**
     * 注册的来源渠道
     */
    private String channel;


    /**
     * 注册的设备
     */
    private String device;


    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备的型号
     */
    private String deviceModel;

    /**
     * 注册的IP
     */
    private Long ip;

    /**
     * 用户状态 的剔除的问题
     */
    private StatusRecord status;
    /**
     * 创建时间
     */
    private Long gmtCreate;
    /**
     * 修改时间
     */
    private Long gmtModified;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }
}
