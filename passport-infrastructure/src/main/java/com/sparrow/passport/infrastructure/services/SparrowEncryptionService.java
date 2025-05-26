package com.sparrow.passport.infrastructure.services;

import com.sparrow.cryptogram.MessageSignature;
import com.sparrow.cryptogram.ThreeDES;
import com.sparrow.passport.domain.service.EncryptionService;

import javax.inject.Named;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Named("encryptionService")
public class SparrowEncryptionService implements EncryptionService {
    @Override
    public String encryptPassword(String password) {
        return MessageSignature.getInstance().md5(password);
    }

    @Override
    public String base64Encode(String originCode) {
        return Base64.getEncoder().encodeToString(originCode.getBytes(StandardCharsets.US_ASCII));
    }

    @Override
    public String base64Decode(String base64) {
        return new String(Base64.getDecoder().decode(base64), StandardCharsets.US_ASCII);

    }

    @Override
    public String generateToken(String originCode, String originPassword) {
        return ThreeDES.getInstance().encrypt(originPassword, originCode);
    }

    @Override
    public String decryptToken(String token, String originPassword) {
        return ThreeDES.getInstance().decrypt(originPassword, token);
    }
}
