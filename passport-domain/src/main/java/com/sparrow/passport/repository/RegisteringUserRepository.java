package com.sparrow.passport.repository;

import com.sparrow.protocol.ClientInformation;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;

public interface RegisteringUserRepository {
    RegisteringUserEntity findByEmail(String email);

    void saveRegisteringUser(RegisteringUserEntity user, ClientInformation client);
}
