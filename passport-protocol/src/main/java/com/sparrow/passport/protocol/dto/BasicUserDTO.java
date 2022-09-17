package com.sparrow.passport.protocol.dto;

import com.sparrow.protocol.POJO;
import java.sql.Date;

public class BasicUserDTO implements POJO {

    private Long userId;


    private String userName;

    private String nickName;
    /**
     * 头象
     */
    private String avatar;
    /**
     * 专区id
     */
    private String zone;
    /**
     * 性别
     */
    private String gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电子邮箱
     */
    private String mobile;
    /**
     * 当前积分
     */
    private Long cent;
    /**
     * 是否激活
     */
    private Boolean activate;
    /**
     * 激活日期
     */
    private Long activateTime;
    /**
     * 注册时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 最后一次登录时间
     */
    private Long lastLoginTime;
    /**
     * 设备类型 PC MOBILE MAC
     */
    private String device;

    /**
     * 设备型号 5S/
     */
    private String deviceModel;
    /**
     * 设备Id e456789056789
     */
    private String deviceId;
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

    private Boolean isOnline;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Long getCent() {
        return cent;
    }

    public void setCent(Long cent) {
        this.cent = cent;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public Long getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Long activateTime) {
        this.activateTime = activateTime;
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

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    @Override public String toString() {
        return "BasicUserDTO{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", avatar='" + avatar + '\'' +
            ", zone='" + zone + '\'' +
            ", gender='" + gender + '\'' +
            ", birthday=" + birthday +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            ", cent=" + cent +
            ", activate=" + activate +
            ", activateTime=" + activateTime +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", lastLoginTime=" + lastLoginTime +
            ", device='" + device + '\'' +
            ", deviceModel='" + deviceModel + '\'' +
            ", deviceId='" + deviceId + '\'' +
            ", ip=" + ip +
            ", personalSignature='" + personalSignature + '\'' +
            ", status='" + status + '\'' +
            ", isOnline=" + isOnline +
            '}';
    }
}
