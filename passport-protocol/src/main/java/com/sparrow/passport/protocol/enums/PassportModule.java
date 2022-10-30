package com.sparrow.passport.protocol.enums;

import com.sparrow.protocol.ModuleSupport;

public class PassportModule {
    public static final ModuleSupport USER = new ModuleSupport() {
        @Override
        public String code() {
            return "11";
        }

        @Override
        public String name() {
            return "USER";
        }
    };
}
