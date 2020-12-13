/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/9
 */
public class User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return age == user.age;
    }

    @Override
    public int hashCode() {
        return age;
    }
}