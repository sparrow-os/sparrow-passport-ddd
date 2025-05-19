package com.sparrow.passport.domain.service;

import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.exception.Asserts;
import com.sparrow.file.api.AttachService;
import com.sparrow.file.param.ImageCropperParam;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.web.WebConfigReader;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
public class UserProfileService {

    @Inject
    private DomainRegistry domainRegistry;

    @Inject
    private AttachService attachService;

    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        UserProfileRepository userProfileRepository = domainRegistry.getUserProfileRepository();
        UserProfileDTO userProfile = null;
        if (userIdentify.contains(Symbol.AT)) {
            userProfile = userProfileRepository.findByUserEmail(userIdentify);
        } else {
            userProfile = userProfileRepository.findByUserName(userIdentify);
//            if (securityPrincipal == null) {
//                Pair<String, String> mobilePair = shortMessageService.secretMobile(loginName);
//                securityPrincipal = securityPrincipalRepository.findByMobile(mobilePair.getFirst(), mobilePair.getSecond());
//            }
        }
        Asserts.isTrue(userProfile == null, PassportError.USER_NAME_NOT_EXIST);
        Asserts.isTrue(StatusRecord.DISABLE == userProfile.getStatus(), PassportError.USER_DISABLED);
        return userProfile;
    }

    public String modifyAvatar(AvatarModifyParam avatarModifyParam) throws BusinessException, IOException {
        WebConfigReader webConfigReader = ApplicationContext.getContainer().getBean(WebConfigReader.class);
        String resource = webConfigReader.getResource();
        Asserts.isTrue(avatarModifyParam.getAvatar().startsWith(resource), PassportError.USER_AVATAR_CAN_NOT_DEFAULT);
        ImageCropperParam imageCropperParam = new ImageCropperParam(avatarModifyParam.getAvatar(), avatarModifyParam.getX(), avatarModifyParam.getY(), avatarModifyParam.getWidth(), avatarModifyParam.getHeight());
        String avatar = this.attachService.imageCropper(imageCropperParam);
        domainRegistry.getUserProfileRepository().modifyAvatar(avatar);
        return avatar;
    }
}
