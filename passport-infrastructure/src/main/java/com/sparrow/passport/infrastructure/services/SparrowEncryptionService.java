package com.sparrow.passport.infrastructure.services;

import com.sparrow.cryptogram.Base64;
import com.sparrow.cryptogram.MessageSignature;
import com.sparrow.cryptogram.ThreeDES;
import com.sparrow.passport.domain.service.EncryptionService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.inject.Named;

import static com.sparrow.cryptogram.Base64.PREFERRED_ENCODING;

@Named("encryptionService")
public class SparrowEncryptionService implements EncryptionService {
    @Override public String encryptPassword(String password) {
        return MessageSignature.getInstance().md5(password);
    }

    @Override public String base64Encode(String originCode) {
        try {
            return Base64.encodeBytes(originCode.getBytes(PREFERRED_ENCODING));
        } catch (UnsupportedEncodingException ignore) {
            return null;
        }
    }

    @Override public String base64Decode(String base64) {
        try {
            return new String(Base64.decode(base64), PREFERRED_ENCODING);
        } catch (IOException e) {
            return null;
        }
    }

    @Override public String generateToken(String originCode, String originPassword) {
        return ThreeDES.getInstance().encrypt(originPassword, originCode);
    }

    @Override public String decryptToken(String token, String originPassword) {
        return ThreeDES.getInstance().decrypt(originPassword, token);
    }
}
