package com.maipiande.rubbish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yizmao
 * @date 18-7-31 下午3:14
 */
@TableName("article_content")
@Data
public class ArticleContent extends Model {

    @TableId(type = IdType.INPUT)
    private Integer articleId;

    private String content;

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }
}
