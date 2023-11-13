package com.practice.hibernate.secondarytable;

import javax.persistence.*;

@Entity
@Table(name = "personwithsecondarytable")
@SecondaryTables({
        @SecondaryTable(name = "addresssecondarytable", pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id" , referencedColumnName = "id")),
        @SecondaryTable(name = "phonesecondarytable", pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id" , referencedColumnName = "id")),

})
public class PersonWithSecondaryTable {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(name="city", table = "addresssecondarytable", columnDefinition = "varchar(50) not null")
    private String city;

    @Column(name="street", table ="addresssecondarytable", columnDefinition = "varchar(50) not null")
    private String street;

    @Column(name="zipcode", table = "addresssecondarytable", columnDefinition = "varchar(50) not null")
    private String zipcode;

    @Column(name="countrycode", table = "phonesecondarytable", columnDefinition = "varchar(50) not null")
    private String countryCode;

    @Column(name="phonenumber", table = "phonesecondarytable", columnDefinition = "varchar(50) not null")
    private String phoneNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
