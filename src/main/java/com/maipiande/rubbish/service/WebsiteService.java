package com.maipiande.rubbish.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maipiande.rubbish.RubbishResult;
import com.maipiande.rubbish.dao.WebsiteDao;
import com.maipiande.rubbish.entity.WebSite;
import com.maipiande.rubbish.utils.BCrypt;
import com.maipiande.rubbish.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WebsiteService {
    @Autowired
    private WebsiteDao websiteDao;

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public RubbishResult login(String username, String password) {
        WebSite webSite = this.websiteDao.selectOne(
                new QueryWrapper<WebSite>()
                        .lambda()
                        .eq(WebSite::getUsername, username));

        if (webSite!=null){
            boolean checkpw = BCrypt.checkpw(password,webSite.getPassword());
            if (checkpw){
                String token  = UUID.randomUUID().toString();
                Map<String,Object> result = new HashMap<>();
                result.put("token",token);
                result.put("info",webSite);
                Token.add(token,result,60*60*24);
                return RubbishResult.ok(result,"登录成功");
            }
        }
        return RubbishResult.fail("用户名或密码错误");
    }
}
