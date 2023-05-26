package com.sparrow.passport.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;

/**
 * Created by harry on 2016/12/16.
 */
public interface UserProfileController {
    BasicUserVO loadUserBasic() throws BusinessException;

    void modifyHeadImage(String parameter) throws BusinessException;
}
