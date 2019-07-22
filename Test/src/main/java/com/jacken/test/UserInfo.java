package com.jacken.test;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author jacken
 * @date 2017/12/24
 */
public class UserInfo {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static UserInfo[] getUserInfos() {
        UserInfo[] userInfos = new UserInfo[10];
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("jacken");
            userInfos[i] = userInfo;
        }

        return userInfos;
    }
}
