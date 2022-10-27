package com.sparrow.passport.mybatis.mapper;

import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

public class User {
    /*-------基本信息-------------*/
    @TableId("user_id")
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String avatar;
    private Integer gender;
    private Date birthday;
    private String email;
    private String mobile;
    private Long cent;
    private Boolean activate;
    private Long activateTime;
    private Long createTime;
    private Long updateTime;
    private Long lastLoginTime;
    private String website;
    private Long ip;
    //设备
    private String device;
    private String deviceId;
    private String deviceModel;
    //referer
    private String channel;
    private Boolean isOnline;
    private String personalSignature;
    //是否可用enable disable
    private Integer status;
    /**
     * 用户自定义域名 全部子站共用一个域名
     */
    private String zone;

    private String groupLevel;

    private String secretMobile;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String headImg) {
        this.avatar = headImg;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Long getCent() {
        return cent;
    }

    public void setCent(Long cent) {
        this.cent = cent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Boolean getActivate() {
        return this.activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public Long getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Long activeTime) {
        this.activateTime = activeTime;
    }

    public String getZone() {
        return zone;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String origin) {
        this.channel = origin;
    }

    public String getWebsite() {
        return website;
    }

    public String getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(String groupLevel) {
        this.groupLevel = groupLevel;
    }

    public String getSecretMobile() {
        return secretMobile;
    }

    public void setSecretMobile(String secretMobile) {
        this.secretMobile = secretMobile;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
        this.ip = ip;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}
