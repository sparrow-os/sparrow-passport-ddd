package com.sparrow.passport.controller.assemble;

import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.constant.DateTime;
import com.sparrow.container.ConfigReader;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.enums.Gender;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.IpSupport;
import com.sparrow.utility.DateTimeUtility;
import com.sparrow.utility.StringUtility;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * user assemble
 */
@Named
public class UserAssemble {
    @Inject
    private IpSupport ipSupport;
    @Inject
    private DomainRegistry domainRegistry;

    public BasicUserVO assemble(UserProfileDTO basicUser) {

        BasicUserVO basicUserVo = new BasicUserVO();
        String defaultAvatar =this.domainRegistry.getWebConfigReader().getDefaultAvatar();

        if (StringUtility.isNullOrEmpty(basicUser.getUserId())
                || basicUser.getUserId().equals(LoginUser.VISITOR_ID)) {
            ConfigReader configReader= ApplicationContext.getContainer().getBean(ConfigReader.class);
            basicUserVo.setNickName(configReader.getI18nValue(ConfigKeyLanguage.USER_VISITOR_NICKNAME));
            basicUserVo.setAvatar(defaultAvatar);
            basicUserVo.setGender(Gender.NULL.name());
            basicUserVo.setStatus(StatusRecord.DISABLE.name());
            basicUserVo.setGmtCreate(Symbol.EMPTY);
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
        basicUserVo.setGmtCreate(DateTimeUtility.getFormatTime(basicUser.getGmtCreate(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setModified(DateTimeUtility.getFormatTime(basicUser.getGmtModified(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setDeviceModel(basicUser.getDeviceModel());
        basicUserVo.setDevice(basicUser.getDevice());
        basicUserVo.setIp(this.ipSupport.parse(basicUser.getIp()));
        basicUserVo.setLastLoginTime(DateTimeUtility.getFormatTime(basicUser.getLastLoginTime(), DateTime.FORMAT_YYYY_MM_DD_HH_MM_SS));
        basicUserVo.setPersonalSignature(basicUser.getPersonalSignature());

        //set avatar
        if (!StringUtility.isNullOrEmpty(basicUser.getAvatar())) {
            String avatar = basicUser.getAvatar();
            basicUserVo.setAvatar(avatar);
        } else {
            basicUserVo.setAvatar(defaultAvatar);
        }


        //set nick name
        if (StringUtility.isNullOrEmpty(basicUser.getNickName())) {
            String email = basicUser.getEmail();
            if (!StringUtility.isNullOrEmpty(email)) {
                basicUserVo.setNickName(email.substring(0, email.indexOf("@")));
            } else if (!StringUtility.isNullOrEmpty(basicUser.getUserName())) {
                basicUserVo.setNickName(basicUser.getUserName());
            } else if (StringUtility.isNullOrEmpty(basicUser.getMobile())) {
                String phone = basicUser.getMobile();
                String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7);
                basicUserVo.setNickName(phoneNumber);
            }
        }
        basicUserVo.setStatus(basicUser.getStatus().name());
        return basicUserVo;
    }
}
