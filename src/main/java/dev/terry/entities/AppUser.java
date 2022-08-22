package dev.terry.entities;

import dev.terry.entities.enums.Role;

public class AppUser {

    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private Role role;

    public AppUser() {
    }

    public AppUser(int id, String username, String password, String fname, String lname, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
