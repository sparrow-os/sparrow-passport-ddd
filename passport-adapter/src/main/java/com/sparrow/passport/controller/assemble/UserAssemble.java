package com.sparrow.passport.controller.assemble;

import com.sparrow.constant.Config;
import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.constant.DateTime;
import com.sparrow.constant.File;
import com.sparrow.constant.User;
import com.sparrow.enums.Gender;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.IpSupport;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;
import com.sparrow.passport.protocol.dto.BasicUserDTO;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.DateTimeUtility;
import com.sparrow.utility.StringUtility;

public class UserAssemble {
    public BasicUserVO assemble(BasicUserDTO basicUser, String size) {

        BasicUserVO basicUserVo = new BasicUserVO();
        String defaultHeadImage = ConfigUtility
            .getValue(Config.DEFAULT_AVATAR);

        if (StringUtility.isNullOrEmpty(basicUser.getUserId())
            || basicUser.getUserId().equals(User.VISITOR_ID)) {
            basicUserVo.setNickName(ConfigUtility.getLanguageValue(
                ConfigKeyLanguage.USER_VISITOR_NICKNAME));
            basicUserVo.setAvatar(defaultHeadImage);
            basicUserVo.setGender(Gender.NULL.name());
            basicUserVo.setStatus(StatusRecord.DISABLE.name());
            basicUserVo.setCreateTime(Symbol.EMPTY);
            return basicUserVo;

        }

        basicUserVo.setActivate(basicUser.getActivate());
        if (basicUser.getActivateTime() > 0) {
            basicUserVo.setActivateTime(DateTimeUtility.getFormatTime(basicUser.getActivateTime(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        }

        if (basicUser.getBirthday() != null) {
            basicUserVo.setBirthday(DateTimeUtility.getFormatTime(basicUser.getBirthday(), DateTime.FORMAT_YYYY_MM_DD));
        }
        basicUserVo.setUserId(basicUser.getUserId());
        basicUserVo.setEmail(basicUser.getEmail());
        basicUserVo.setMobile(basicUser.getMobile());
        basicUserVo.setUserName(basicUser.getUserName());
        basicUserVo.setCreateTime(DateTimeUtility.getFormatTime(basicUser.getCreateTime(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setUpdateTime(DateTimeUtility.getFormatTime(basicUser.getUpdateTime(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setDeviceModel(basicUser.getDeviceModel());
        basicUserVo.setDeviceId(basicUser.getDeviceId());
        basicUserVo.setDevice(basicUser.getDevice());
        basicUserVo.setIp(basicUser.getIp());
        basicUserVo.setLastLoginTime(DateTimeUtility.getFormatTime(basicUser.getLastLoginTime(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setPersonalSignature(basicUser.getPersonalSignature());

        //set avatar
        if (!StringUtility.isNullOrEmpty(basicUser.getAvatar())) {
            String avatar = basicUser.getAvatar();
            if (!StringUtility.isNullOrEmpty(size)) {
                avatar = avatar.replace(File.SIZE.BIG, size);
            }
            basicUserVo.setAvatar(avatar);
        } else {
            basicUserVo.setAvatar(defaultHeadImage);
        }

        //set zone url
        String userCenterUrlFormat = ConfigUtility.getValue(
            Config.USER_CENTER_URL_FORMAT);
        if (!StringUtility.isNullOrEmpty(userCenterUrlFormat)) {
            if (StringUtility.isNullOrEmpty(basicUser.getZone())) {
                basicUserVo.setZone(userCenterUrlFormat.replace("$userId",
                    basicUser.getUserId().toString()));
            } else {
                basicUserVo.setZone(userCenterUrlFormat.replace("$userId",
                    basicUser.getZone()));
            }
        }

        //set nick name
        if (StringUtility.isNullOrEmpty(basicUser.getNickName())) {
            String email = basicUser.getEmail();

            if (!StringUtility.isNullOrEmpty(basicUser.getUserName())) {
                basicUserVo.setNickName(basicUser.getUserName());
            } else if (!StringUtility.isNullOrEmpty(email)) {
                basicUserVo.setNickName(email.substring(0, email.indexOf("@")));
            } else if (StringUtility.isNullOrEmpty(basicUser.getMobile())) {
                basicUserVo.setNickName(basicUser.getMobile());
            }
        }

        //SET status
        if (basicUser.getStatus().equals(StatusRecord.DISABLE.name())) {
            basicUserVo.setStatus(StatusRecord.DISABLE.name());
        } else {
            if (basicUser.getOnline()) {
                basicUserVo.setStatus(BasicUserVO.ONLINE);
            } else {
                basicUserVo.setStatus(BasicUserVO.OFFLINE);
            }
        }
        return basicUserVo;
    }
}
