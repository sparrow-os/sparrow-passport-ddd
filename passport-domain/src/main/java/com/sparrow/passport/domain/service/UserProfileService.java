package com.sparrow.passport.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.passport.support.suffix.UserFieldSuffix;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserProfileService {

    @Inject
    private DomainRegistry domainRegistry;

    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        UserProfileRepository userProfileRepository = domainRegistry.getUserProfileRepository();
        UserProfileDTO userProfile = null;
        if (userIdentify.contains(Symbol.AT)) {
            userProfile = userProfileRepository.findByUserName(userIdentify);
        } else {
            userProfile = userProfileRepository.findByUserName(userIdentify);
//            if (securityPrincipal == null) {
//                Pair<String, String> mobilePair = shortMessageService.secretMobile(loginName);
//                securityPrincipal = securityPrincipalRepository.findByMobile(mobilePair.getFirst(), mobilePair.getSecond());
//            }
        }
        Asserts.isTrue(userProfile == null, PassportError.USER_NAME_NOT_EXIST, UserFieldSuffix.LOGIN_USER_NAME);
        Asserts.isTrue(StatusRecord.DISABLE == userProfile.getStatus(),
                PassportError.USER_DISABLED);
        return userProfile;
    }
}
