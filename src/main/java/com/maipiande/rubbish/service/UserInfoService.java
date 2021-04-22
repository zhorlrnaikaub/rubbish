package com.maipiande.rubbish.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maipiande.rubbish.dao.UserInfoDao;
import com.maipiande.rubbish.entity.UserInfo;
import com.maipiande.rubbish.entity.WebSite;
import com.maipiande.rubbish.param.userinfo.RegisterParam;
import com.maipiande.rubbish.utils.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yizmao
 * @date 18-7-31 下午1:57
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;


    public void register(RegisterParam registerParam){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(registerParam,userInfo);
        this.userInfoDao.insert(userInfo);
    }


    /**
     * 根据邮箱查找用户
     * @param userEmail
     * @return
     */
    public UserInfo selectUserByEmail(String userEmail) {

        UserInfo userInfo = this.userInfoDao.selectOne(
                new QueryWrapper<UserInfo>()
                        .lambda()
                        .eq(UserInfo::getUserEmail, userEmail));
        return userInfo;
    }
}
