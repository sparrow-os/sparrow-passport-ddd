package com.sparrow.passport.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;

/**
 * Created by harry on 2016/12/16.
 */
public interface UserProfileController {
    String excelImport();

    BasicUserVO loadUserBasic() throws BusinessException;

    Boolean validateEmail(String email);

    Boolean validateUserName(String userLoginName) throws Exception;

    String showActive(Long userId) throws BusinessException;

    String active(String token) throws BusinessException;

    void modifyHeadImage(String parameter) throws BusinessException;

    void getUserSort() throws BusinessException;

    void popupUser(Long userId) throws BusinessException;
}
