package com.maipiande.rubbish.param.userinfo;

import lombok.Data;

/**
 * @author yizmao
 * @date 18-7-31 下午2:06
 */
@Data
public class RegisterParam {
    private String userEmail;

    private String password;

    private String nickName;
}
