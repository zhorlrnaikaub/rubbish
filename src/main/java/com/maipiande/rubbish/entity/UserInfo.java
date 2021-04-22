package com.maipiande.rubbish.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yizmao
 * @date 18-7-31 上午11:43
 */
@Data
@TableName("user_info")
public class UserInfo extends Model {

    private String userEmail;

    private String password;

    private String nickName;

    private String profilePhoto;

    private int status;

    @Override
    protected Serializable pkVal() {
        return this.userEmail;
    }
}
