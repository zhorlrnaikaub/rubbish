package com.maipiande.rubbish;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RubbishResult {
    private int status;

    private Object result;

    private String message;

    public RubbishResult(int status, Object result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public static RubbishResult ok(Object result){
        return new RubbishResult(0, result, "操作成功");
    }

    public static RubbishResult ok(){
        return new RubbishResult(0, "", "操作成功");
    }

    public static RubbishResult ok(Object result, String message){
        return new RubbishResult(0, result, message);
    }

    public static RubbishResult fail(String message){
        return new RubbishResult(1, null, message);
    }
}
