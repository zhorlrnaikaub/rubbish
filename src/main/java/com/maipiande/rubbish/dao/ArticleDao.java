package com.maipiande.rubbish.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maipiande.rubbish.entity.Article;
import com.maipiande.rubbish.param.ArticleListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao extends BaseMapper<Article> {

    List<Article> list(@Param("param") ArticleListParam param);
}
