package com.maipiande.rubbish.param.article;

import lombok.Data;

/**
 * @author yizmao
 * @date 18-7-31 下午3:18
 */
@Data
public class ArticleSaveParam {
    private String title;

    private String classify;

    private String content;
}
