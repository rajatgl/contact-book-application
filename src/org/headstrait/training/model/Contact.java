package org.headstrait.training.model;

import org.headstrait.training.model.builder.ContactBuilder;

public class Contact {
    //first name of the contact
    private String firstname;
    //second name of the contact
    private String lastname;
    //address of the contact
    private String address;
    //city of the contact
    private String city;
    //state of residence of the contact
    private String state;
    //postal code of the contact
    private Integer zip;
    //phone number of the contact;
    private Long phoneNumber;
    //email of the contact
    private String email;

    private Contact(ContactBuilder contactBuilder) {
        firstname = contactBuilder.getFirstName();
        lastname = contactBuilder.getLastName();
        address = contactBuilder.getAddress();
        city = contactBuilder.getCity();
        state = contactBuilder.getState();
        zip = contactBuilder.getZip();
        phoneNumber = contactBuilder.getPhoneNumber();
        email = contactBuilder.getEmail();
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName(){
        return firstname+" "+lastname;
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

    public static Contact getInstance(ContactBuilder contactBuilder){
        return new Contact(contactBuilder);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
