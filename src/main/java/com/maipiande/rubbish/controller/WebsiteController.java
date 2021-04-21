package com.maipiande.rubbish.controller;


import com.maipiande.rubbish.RubbishResult;
import com.maipiande.rubbish.entity.WebSite;
import com.maipiande.rubbish.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网站基本配置
 */
@RestController
@RequestMapping("/website")
public class WebsiteController {
    @Autowired
    private WebsiteService websiteService;

    /**
     * 管理员登录
     * @param webSite
     */
    @PostMapping("/adminLogin")
    public RubbishResult adminLogin(@RequestBody WebSite webSite){
        return this.websiteService.login(webSite.getUsername(),webSite.getPassword());
    }
}
