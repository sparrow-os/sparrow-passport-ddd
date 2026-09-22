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

package com.sparrow.passport.infrastructure.services;

import com.sparrow.cryptogram.MessageSignature;
import com.sparrow.cryptogram.ThreeDES;
import com.sparrow.passport.domain.service.EncryptionService;

import jakarta.inject.Named;
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
