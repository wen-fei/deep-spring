package org.wds.beans;

/**
 * @author : TenYun
 * @date : 2020-05-16 17:03
 * @description :
 **/
public class Employee {

    private String firstName;
    private String lastName;
    private String homeAddress;

    public Employee(String firstName, String lastName, String homeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
