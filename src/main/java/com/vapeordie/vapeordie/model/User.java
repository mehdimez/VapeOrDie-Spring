package com.vapeordie.vapeordie.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = true)
    private String phoneNumber;
    @Column(nullable = true)
    private String adress;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private String dateOfBirth;
    @Column(nullable = true)
    private String gender;
    @OneToMany(mappedBy = "user")
    private List<OrderProduct> orders;

    public User() {

    }
    public User(String firstName,String lastName,String email, String password,String dateOfBirth,String gender) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public User( String email, String firstName, String lastName, String phoneNumber, String adress,
                 String password, String dateOfBirth, String gender) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<OrderProduct> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderProduct> orders) {
        this.orders = orders;
    }
}