package com.maipiande.rubbish.service;

import com.github.pagehelper.PageInfo;
import com.maipiande.rubbish.dao.ArticleDao;
import com.maipiande.rubbish.entity.Article;
import com.maipiande.rubbish.entity.ArticleContent;
import com.maipiande.rubbish.param.article.ArticleListParam;
import com.maipiande.rubbish.param.article.ArticleSaveParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;


    public PageInfo<Article> list(ArticleListParam param) {
        List<Article> list = articleDao.list(param);
        return new PageInfo(list);
    }

    @Transactional
    public Integer save(ArticleSaveParam param) {

        Article article = new Article();
        article.setClassify(param.getClassify());
        article.setCreateDate(LocalDateTime.now());
        article.setTitle(param.getTitle());
        article.insertOrUpdate();

        ArticleContent content = new ArticleContent();
        content.setArticleId(article.getId());
        content.insertOrUpdate();
        return article.getId();
    }


    public HashMap<String, Object> detail(int id) {
        Article article = this.articleDao.selectById(id);
        ArticleContent content = new ArticleContent();
        content.selectById(id);
        HashMap<String, Object> result = new LinkedHashMap<>();
        result.put("article",article);
        result.put("content",content);
        return result;
    }
}
