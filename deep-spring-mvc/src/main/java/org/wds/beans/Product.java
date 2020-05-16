package org.wds.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : TenYun
 * @date : 2020-05-16 16:26
 * @description :
 **/
public class Product  implements Serializable {
    private static final long serialVersionUID = 748392348L;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
