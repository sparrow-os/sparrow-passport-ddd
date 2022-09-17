package com.sparrow.passport.domain.object.value;

public class ModifyPassword {
    private String oldEncryptionPassword;
    private String newEncryptionPassword;
    private Password password;


    public ModifyPassword(String oldEncryptionPassword,String newPassword, String newEncryptionPassword) {
        this.oldEncryptionPassword = oldEncryptionPassword;
        this.password=new Password(newPassword);
        this.newEncryptionPassword = newEncryptionPassword;
    }

    public Password getNewOriginPassword() {
        return password;
    }

    public String getOldEncryptionPassword() {
        return oldEncryptionPassword;
    }

    public String getNewEncryptionPassword() {
        return newEncryptionPassword;
    }
}
