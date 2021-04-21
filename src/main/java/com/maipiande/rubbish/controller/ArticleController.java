package com.maipiande.rubbish.controller;

import com.github.pagehelper.PageInfo;
import com.maipiande.rubbish.RubbishResult;
import com.maipiande.rubbish.entity.Article;
import com.maipiande.rubbish.param.ArticleListParam;
import com.maipiande.rubbish.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    /**
     * 文章列表
     * @return
     */
    @PostMapping("/list")
    public RubbishResult list(@RequestBody ArticleListParam param){
        PageInfo<Article> list = this.articleService.list(param);
        return RubbishResult.ok(list);
    }
}
