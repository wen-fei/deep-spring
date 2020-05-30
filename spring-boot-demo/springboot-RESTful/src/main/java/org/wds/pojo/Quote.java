package org.wds.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author : TenYun
 * @date : 2020-05-30 16:46
 * @description :
 * 此注释表明，任何和此pojo无关的属性都忽略
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
