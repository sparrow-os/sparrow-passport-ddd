package com.sparrow.passport.po;

import com.sparrow.protocol.FieldOrder;
import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "t_user")
@Data
public class User implements Cloneable, POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    /**
     * 用户ID
     */
    private Long userId;

    @FieldOrder(order = 1.1F)
    @Column(name = "tenant_id", columnDefinition = " int(11) DEFAULT 0 COMMENT '租户ID'", nullable = false, updatable = false)
    private Long tenantId;


    @FieldOrder(order = 2)
    @Column(name = "user_name", columnDefinition = " varchar(64) DEFAULT '' COMMENT '用户名'", nullable = false, updatable = false, unique = true)
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    @FieldOrder(order = 3)
    @Column(name = "nick_name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '昵称'", nullable = false, updatable = true)
    private String nickName;

    /**
     * 邮箱
     */
    @FieldOrder(order = 4)
    @Column(name = "email", columnDefinition = "varchar(256) DEFAULT '' comment 'E-MAIL'", unique = true, updatable = false, nullable = false)
    private String email;

    @FieldOrder(order = 5)
    @Column(name = "password", columnDefinition = "varchar(32) DEFAULT '' COMMENT '密码'", updatable = false, nullable = false)
    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    @FieldOrder(order = 6)
    @Column(name = "gender", columnDefinition = "tinyint(2) DEFAULT 0 COMMENT '性别'", nullable = false)
    private Integer gender;

    /**
     * 头像
     */
    @FieldOrder(order = 7)
    @Column(name = "avatar", columnDefinition = "varchar(256) DEFAULT '' COMMENT '头象'", updatable = false, nullable = false)
    private String avatar;

    @FieldOrder(order = 7.1F)
    @Column(name = "nationality", columnDefinition = "varchar(32) DEFAULT '' COMMENT '国籍'", updatable = false, nullable = false)
    private String nationality;

    /**
     * 个性签名
     */
    @FieldOrder(order = 8)
    @Column(name = "personal_signature", columnDefinition = "varchar(256) DEFAULT '' COMMENT '签名'", nullable = false)
    private String personalSignature;


    @FieldOrder(order = 9)
    @Column(name = "birthday", columnDefinition = "date COMMENT '生日'")
    /**
     * 生日
     */
    private Date birthday;


    /**
     * 手机号
     */
    @FieldOrder(order = 10)
    @Column(name = "mobile", columnDefinition = "varchar(11) DEFAULT '0' COMMENT '手机号码'", updatable = false, nullable = false)

    private String mobile;

    @FieldOrder(order = 11)
    @Column(name = "last_login_time", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '最近登录时间'", updatable = false, nullable = false)
    /**
     * 最后登录时间
     */
    private Long lastLoginTime;

    @FieldOrder(order = 15)
    @Column(name = "activate", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否激活'", nullable = false)
    /**
     * 是否激活
     */
    private Boolean activate;

    @FieldOrder(order = 16)
    @Column(name = "activate_time", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '激活时间'", nullable = false, updatable = false)
    /**
     * 激活时间
     */
    private Long activateTime;
    @FieldOrder(order = 18)
    @Column(name = "channel", columnDefinition = "varchar(128) DEFAULT '' COMMENT '渠道来源'", updatable = false, nullable = false)
    /**
     * 注册的来源渠道
     */
    private String channel;


    @FieldOrder(order = 22)
    @Column(name = "device", columnDefinition = "varchar(16) DEFAULT '' COMMENT '设备'", updatable = false, nullable = false)
    /**
     * 注册的设备
     */
    private String device;

    @FieldOrder(order = 23)
    @Column(name = "device_id", columnDefinition = "varchar(64) DEFAULT '' COMMENT '设备id'", updatable = false, nullable = false)

    /**
     * 设备ID
     */
    private String deviceId;

    @FieldOrder(order = 24)
    @Column(name = "device_model", columnDefinition = "varchar(32) DEFAULT '' COMMENT '设备模型'", updatable = false, nullable = false)
    /**
     * 设备的型号
     */
    private String deviceModel;

    @FieldOrder(order = 26)
    @Column(name = "ip", columnDefinition = "bigint(10) DEFAULT 0 COMMENT 'ip'", updatable = false, nullable = false)
    /**
     * 注册的IP
     */
    private Long ip;

    @Column(name = "category",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT '类别'",
            nullable = false)
    private Integer category;

    @Column(name = "english_name",
            columnDefinition = "varchar(64)  DEFAULT '' COMMENT '英文名'",
            nullable = false)
    private String englishName;

    @FieldOrder(
            order = 100.0F
    )
    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    /**
     * 用户状态 的剔除的问题
     */
    private StatusRecord status;
    @FieldOrder(
            order = 102.0F
    )
    @Column(name = "gmt_create",
            columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '创建时间'",
            nullable = false,
            updatable = false)
    /**
     * 创建时间
     */
    private Long gmtCreate;
    @FieldOrder(order = 104.0F)
    @Column(
            name = "gmt_modified",
            columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '更新时间'",
            nullable = false)
    /**
     * 修改时间
     */
    private Long gmtModified;
}
