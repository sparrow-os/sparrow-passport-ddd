package com.sparrow.passport.domain.object.value;

import com.sparrow.constant.Config;
import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.constant.SparrowError;
import com.sparrow.enums.DateTimeUnit;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.service.EncryptionService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.ValueObject;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.DateTimeUtility;
import java.sql.Timestamp;
import java.util.Objects;

public class EmailActivateToken implements ValueObject<EmailActivateToken> {
    private DomainRegistry domainRegistry;
    private EmailActivateToken(){}
    private static final String TOKEN_TYPE="email-activate";
    public static EmailActivateToken createToken(Long userId,
        String userName,
        String email,
        String password,
        String currentDate,
        DomainRegistry domainRegistry) {
        EmailActivateToken emailActivateToken = new EmailActivateToken();
        emailActivateToken.userId = userId;
        emailActivateToken.userName = userName;
        emailActivateToken.sendDate = currentDate;
        emailActivateToken.email = email;
        emailActivateToken.domainRegistry = domainRegistry;
        emailActivateToken.password = password;
        return emailActivateToken;
    }

    public static EmailActivateToken parse(EmailTokenPair emailTokenPair,
        String password,
        DomainRegistry domainRegistry) {
        if (emailTokenPair == null) {
            return null;
        }
        EncryptionService encryptionService = domainRegistry.getEncryptionService();
        EmailActivateToken emailActivateToken = new EmailActivateToken();
        emailActivateToken.email = emailTokenPair.getEmail();

        String originToken = encryptionService.decryptToken(emailTokenPair.getToken(), password);
        String[] array = originToken.split("\\|");
        emailActivateToken.tokenType=array[0];
        emailActivateToken.userId = Long.parseLong(array[1]);
        emailActivateToken.userName = array[2];
        emailActivateToken.sendDate = array[3];
        emailActivateToken.password = password;
        return emailActivateToken;
    }

    private Long userId;
    private String userName;
    private String sendDate;
    private String email;
    private String password;
    private String tokenType;

    private String generateOriginToken() {
        // 令牌原码
        return TOKEN_TYPE+"|" + this.userId + "|" + this.userName + "|" + this.sendDate;
    }

    private String generateToken() {
        EncryptionService encryptionService = domainRegistry.getEncryptionService();
        String encryptedToken = encryptionService.generateToken(this.generateOriginToken(), this.password);
        return encryptionService.base64Encode(EmailTokenPair.create(this.email, encryptedToken).toString());
    }

    public String generateContent() {
        String language = ConfigUtility.getValue(Config.LANGUAGE);
        return ConfigUtility
            .getLanguageValue(ConfigKeyLanguage.EMAIL_ACTIVATE_CONTENT,
                language)
            .replace("$rootPath", ConfigUtility.getValue(Config.ROOT_PATH))
            .replace("$validateToken", this.generateToken())
            .replace("$date", this.sendDate);
    }

    public boolean isValid(String originUserName) throws BusinessException {
        Asserts.isTrue(!this.userName.equals(originUserName), SparrowError.USER_PASSWORD_VALIDATE_TOKEN_ERROR);
        Asserts.isTrue(!TOKEN_TYPE.equals(this.tokenType), SparrowError.USER_TOKEN_TYPE_ERROR);

        int validateTokenAvailableDay = Integer.parseInt(ConfigUtility
            .getValue(Config.VALIDATE_TOKEN_AVAILABLE_DAY));
        int passDay = DateTimeUtility.getInterval(
            Timestamp.valueOf(sendDate).getTime(),
            System.currentTimeMillis(),
            DateTimeUnit.DAY);
        if (passDay > validateTokenAvailableDay) {
            throw new BusinessException(SparrowError.USER_VALIDATE_TOKEN_TIME_OUT);
        }
        return true;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EmailActivateToken))
            return false;
        EmailActivateToken token = (EmailActivateToken) o;
        return
            userId.equals(token.userId) &&
                userName.equals(token.userName) &&
                sendDate.equals(token.sendDate) &&
                email.equals(token.email) &&
                password.equals(token.password);
    }

    @Override public int hashCode() {
        return Objects.hash(userId, userName, sendDate, email, password);
    }

    @Override public boolean sameValueAs(EmailActivateToken token) {
        if (this.hashCode() != token.hashCode()) {
            return false;
        }
        return this.equals(token);
    }
}
