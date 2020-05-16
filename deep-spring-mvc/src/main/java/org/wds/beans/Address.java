package org.wds.beans;

/**
 * @author : TenYun
 * @date : 2020-05-16 17:04
 * @description :
 **/
public class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;
    private String conuntry;

    public Address(String line1, String line2, String city, String state, String zipCode, String conuntry) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.conuntry = conuntry;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", conuntry='" + conuntry + '\'' +
                '}';
    }
}
