package com.sparrow.passport.protocol.dto;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import java.sql.Date;

@Data
public class UserProfileDTO implements POJO {
    /**
     * 用户ID
     */
    private Long userId;
    private Long tenantId;
    private Integer category;
    private String englishName;
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

    private String nationality;
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

}
