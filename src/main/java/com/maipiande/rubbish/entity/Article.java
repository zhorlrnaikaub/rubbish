package com.maipiande.rubbish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("article")
public class Article extends Model {

    @TableId(type = IdType.AUTO)
    private int id;

    private String title;

    private String classify;

    private LocalDateTime createDate;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
