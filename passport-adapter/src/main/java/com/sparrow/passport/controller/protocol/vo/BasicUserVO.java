package com.sparrow.passport.controller.protocol.vo;

/**
 * Created by harry on 2017/1/6.
 */
public class BasicUserVO {
    public static final String ONLINE = "ONLINE";
    public static final String OFFLINE = "OFFLINE";
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录名
     */
    private String userName;
    /**
     * 用户名
     */
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
    private String birthday;
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
    private String activateTime;
    /**
     * 注册时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
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

    private Long publishedCount;
    private Long attentionCount;
    private Long fansCount;

    public Long getPublishedCount() {
        return publishedCount;
    }

    public void setPublishedCount(Long publishedCount) {
        this.publishedCount = publishedCount;
    }

    public Long getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Long attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Long getFansCount() {
        return fansCount;
    }

    public void setFansCount(Long fansCount) {
        this.fansCount = fansCount;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(String activateTime) {
        this.activateTime = activateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
}
