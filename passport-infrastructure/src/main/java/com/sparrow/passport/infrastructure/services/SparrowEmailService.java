package com.sparrow.passport.infrastructure.services;

import com.sparrow.passport.domain.service.EmailService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.utility.EMailUtility;
import javax.inject.Named;

@Named
public class SparrowEmailService implements EmailService {
    @Override
    public void send(String toAddress, String subject, String content, String language) throws BusinessException {
        EMailUtility eMailUtility = new EMailUtility();
        eMailUtility.sendMail(toAddress, subject, content, language);
    }
}
