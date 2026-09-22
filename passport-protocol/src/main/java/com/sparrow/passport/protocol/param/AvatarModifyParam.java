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

package com.sparrow.passport.protocol.param;

import com.sparrow.protocol.Param;

public class AvatarModifyParam implements Param {
    public AvatarModifyParam() {
    }
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

    public AvatarModifyParam(String avatar, Integer x, Integer y, Integer width, Integer height) {
        this.avatar = avatar;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
                ", avatar='" + avatar + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
