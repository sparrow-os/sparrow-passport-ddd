package com.sparrow.passport.services;

import com.sparrow.passport.api.UserRegisterService;
import com.sparrow.passport.assemble.RegisteringUserApplicationAssemble;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.MobileRegisterParam;
import com.sparrow.passport.protocol.param.register.UserNameRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisteringUserApplicationService implements UserRegisterService {

    @Inject
    private RegisteringUserApplicationAssemble registeringUserApplicationAssemble;

    @Inject
    private DomainRegistry domainRegistry;

    @Override public LoginDTO register(UserNameRegisterParam registerParam) throws BusinessException {
        return null;
    }

    @Override public LoginDTO register(MobileRegisterParam registerParam) throws BusinessException {
        return null;
    }

    @Override public LoginDTO register(EmailRegisterParam registerParam) throws BusinessException {
        RegisteringUserEntity registeringUser = this.registeringUserApplicationAssemble.emailDto2Entity(registerParam);
        return this.domainRegistry.getRegisteringUserService().registerByEmail(registeringUser, registerParam.getClient(), domainRegistry);
    }

    @Override public void sendTokenToEmail(EmailActivateParam emailActivateParam) throws BusinessException {
        RegisteringUserEntity registeringUserEntity = this.domainRegistry.getRegisteringUserRepository()
            .findByEmail(emailActivateParam.getEmail());
        this.domainRegistry.getRegisteringUserService().sendActivateEmail(registeringUserEntity, this.domainRegistry);
    }

    @Override public void activeEmail(String token, ClientInformation client) throws BusinessException {
        this.domainRegistry.getRegisteringUserService().activeEmail(token, client, this.domainRegistry);
    }
}
