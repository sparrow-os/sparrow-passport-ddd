package com.sparrow.passport.domain.service;

import com.sparrow.protocol.BusinessException;

public interface EmailService {
    void send(String toAddress, String subject, String content, String language) throws BusinessException;
}
