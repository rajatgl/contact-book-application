package org.headstrait.training.model.builder;

import org.headstrait.training.model.Contact;

public class ContactBuilder{
    private final String firstName;
    private final String lastName;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    private final Long phoneNumber;
    private String email;

    public ContactBuilder(String firstName, String lastName, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZip() {
        return zip;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ContactBuilder address(String address){
        this.address = address;
        return this;
    }
    public ContactBuilder city(String city){
        this.city = city;
        return this;
    }
    public ContactBuilder state(String state){
        this.state = state;
        return this;
    }
    public ContactBuilder zip(Integer zip){
        this.zip = zip;
        return this;
    }

    public ContactBuilder email(String email){
        this.email = email;
        return this;
    }

    public Contact build(){
        Contact contact = Contact.getInstance(this);
        return contact;
    }

}
