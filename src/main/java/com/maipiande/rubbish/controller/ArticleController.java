package com.maipiande.rubbish.controller;

import com.github.pagehelper.PageInfo;
import com.maipiande.rubbish.RubbishResult;
import com.maipiande.rubbish.entity.Article;
import com.maipiande.rubbish.param.article.ArticleListParam;
import com.maipiande.rubbish.param.article.ArticleSaveParam;
import com.maipiande.rubbish.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 文章保存
     */
    @PostMapping("/save")
    public RubbishResult save(@RequestBody ArticleSaveParam param){
        Integer articleId = this.articleService.save(param);
        return RubbishResult.ok(articleId);
    }

    /**
     * 文章详情
     */
    @GetMapping("/detail/{id}")
    public RubbishResult detail(@PathVariable("id") int id){
        return RubbishResult.ok(this.articleService.detail(id));
    }
}
