package com.maipiande.rubbish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@TableName("article")
@Setter
@Getter
public class Article {

    @TableId(type = IdType.AUTO)
    private int id;

    private String title;

    private String classify;

    private LocalDate createDate;
}
