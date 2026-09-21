package com.sparrow.passport.controller;

import com.sparrow.passport.controller.protocol.vo.BasicUserVO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.protocol.BusinessException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import jakarta.inject.Inject;
import java.io.IOException;

@RestController
@RequestMapping("/profile")
@Tag(name = "SpringUserProfile")
public class SpringUserProfileController {
    @Inject
    private UserProfileController userProfileController;

    @GetMapping("load-user-profile.json")
    BasicUserVO loadUserBasic() throws BusinessException {
        return this.userProfileController.loadUserBasic();
    }

    @PostMapping("modify-user-avatar.json")
    public String modifyAvatar(@RequestBody AvatarModifyParam avatarModifyParam) throws BusinessException, IOException {
       return this.userProfileController.modifyAvatar(avatarModifyParam);
    }
}
