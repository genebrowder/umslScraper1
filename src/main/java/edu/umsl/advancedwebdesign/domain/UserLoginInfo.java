package edu.umsl.advancedwebdesign.domain;

import javax.persistence.*;

/**
 * Created by genebrowder on 5/12/16.
 */
@Entity
@Table(name = "USER_LOGIN_INFO")
public class UserLoginInfo {

    private static final long serialVersionUID = 336542947443965225L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_LOGIN_INFO_ID")
    @Id
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

