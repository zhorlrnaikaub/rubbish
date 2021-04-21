package com.maipiande.rubbish.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("website")
public class WebSite {
    @TableId
    private String username;
    private String password;
}
