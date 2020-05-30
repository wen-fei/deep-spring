package org.wds.pojo;

/**
 * @author : TenYun
 * @date : 2020-05-29 13:24
 * @description :
 **/
public class Person {

    private String name;

    private String sex;

    private String city;

    public Person(String name, String sex, String city) {
        this.name = name;
        this.sex = sex;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
