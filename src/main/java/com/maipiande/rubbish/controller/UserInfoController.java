package com.maipiande.rubbish.controller;

import com.maipiande.rubbish.RubbishResult;
import com.maipiande.rubbish.entity.UserInfo;
import com.maipiande.rubbish.param.userinfo.RegisterParam;
import com.maipiande.rubbish.param.userinfo.UserLoginParam;
import com.maipiande.rubbish.service.UserInfoService;
import com.maipiande.rubbish.utils.BCrypt;
import com.maipiande.rubbish.utils.Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author yizmao
 * @date 18-7-31 下午1:55
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public RubbishResult register(@RequestBody RegisterParam registerParam){
        this.userInfoService.register(registerParam);
        return RubbishResult.ok();
    }

    @PostMapping("/login")
    public RubbishResult login(@RequestBody UserLoginParam loginParam){
        UserInfo userInfo = this.userInfoService.selectUserByEmail(loginParam.getUserEmail());
        if (!Objects.isNull(userInfo)){
            boolean checkpw = BCrypt.checkpw(loginParam.getPassword(),userInfo.getPassword());
            if (checkpw){
                return RubbishResult.ok(Token.saveInfo(userInfo));
            }
        }
        return RubbishResult.fail("用户名或密码错误");
    }

    /**
     * 邮箱校验
     * @param userEmail
     * @return
     */
    @GetMapping("/validEmailIsExsit")
    public RubbishResult validEmailIsExsit(@Param("userEmail")String userEmail){
        UserInfo userInfo = this.userInfoService.selectUserByEmail(userEmail);
        if (userInfo!=null){
            return RubbishResult.ok();
        }
        return RubbishResult.fail("邮箱已经存在");
    }


    @PostMapping("/update")
    public RubbishResult update(@RequestBody UserInfo userInfo){
        userInfo.updateById();
        return RubbishResult.ok();
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout/{token}")
    public RubbishResult logout(@PathVariable("token") String token){
        Token.logout(token);
        return RubbishResult.ok();
    }
}
