package com.yjiewei.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yjiewei
 * @date 2021/8/10
 */
@Getter
@Setter
public class Person {
    private String name;
    private String sex;
    private int age;
    private String education;
    private String information;
    public Person(String name, String sex, int age, String education, String information) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.information = information;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
