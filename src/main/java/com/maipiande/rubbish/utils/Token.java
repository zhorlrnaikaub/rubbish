package com.maipiande.rubbish.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class Token {

    private static LinkedHashMap<String, Map<String, Object>> userTokenMap = new LinkedHashMap<>();


    /**
     * 保存token
     *
     * @param token
     * @param content
     * @param expire
     */
    public static void add(String token, Object content, long expire) {
        Long expireTime = LocalDateTime
                .now()
                .plusSeconds(expire)
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();

        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("token", token);
        map.put("expire", expireTime);
        userTokenMap.put(token, map);
        log.debug(token + " save sucess!");
    }

    /**
     * 根据token获取用户信息
     *
     * @param token
     */
    public static Object get(String token) {

        if (userTokenMap.containsKey(token)) {
            Map<String, Object> result = userTokenMap.get(token);
            //判断是否过期
            long expire = (long) result.get("expire");
            long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            if (now > expire) {
                log.debug(token + "  is expires.....");
                userTokenMap.remove(token);
            }
            return result;
        }
        return null;
    }
}