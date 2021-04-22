package com.maipiande.rubbish.param.article;

import com.maipiande.rubbish.param.PageParam;
import lombok.Data;

@Data
public class ArticleListParam extends PageParam {

    private String title;

    private String classify;
}
