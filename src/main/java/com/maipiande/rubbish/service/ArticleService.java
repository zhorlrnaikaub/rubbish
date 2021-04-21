package com.maipiande.rubbish.service;

import com.github.pagehelper.PageInfo;
import com.maipiande.rubbish.dao.ArticleDao;
import com.maipiande.rubbish.entity.Article;
import com.maipiande.rubbish.param.ArticleListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;


    public PageInfo<Article> list(ArticleListParam param) {
        List<Article> list = articleDao.list(param);
        return new PageInfo(list);
    }
}
