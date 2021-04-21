package com.maipiande.rubbish.param;

import lombok.Data;

@Data
public class ArticleListParam extends PageParam {

    private String title;

    private String classify;
}
