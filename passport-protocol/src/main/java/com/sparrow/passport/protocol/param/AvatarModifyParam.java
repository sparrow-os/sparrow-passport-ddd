package com.sparrow.passport.protocol.param;

import com.sparrow.protocol.POJO;

public class AvatarModifyParam implements POJO {
    public AvatarModifyParam() {
    }

    private Long userId;
    /**
     * 头象
     */
    private String avatar;
    /**
     * x the specified X coordinate
     */
    private Integer x;
    /**
     * y the specified Y coordinate
     */
    private Integer y;
    /**
     * width    the width of the <code>Rectangle</code>
     */
    private Integer width;
    /**
     * height   the height of the <code>Rectangle</code>
     */
    private Integer height;

    public AvatarModifyParam(Long userId, String avatar, Integer x, Integer y, Integer width, Integer height) {
        this.userId = userId;
        this.avatar = avatar;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "AvatarModifyDTO{" +
                "userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
