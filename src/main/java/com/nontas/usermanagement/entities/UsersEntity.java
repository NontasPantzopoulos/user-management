package com.nontas.usermanagement.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "my_db_users")
public class UsersEntity {
    private int usersId;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private UsersRolesEntity usersRolesByUsersId;

    @Id
    @Column(name = "users_id")
    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return usersId == that.usersId && Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, email, firstName, lastName, address, telephone);
    }

    @OneToOne(mappedBy = "usersByUsersRolesId")
    public UsersRolesEntity getUsersRolesByUsersId() {
        return usersRolesByUsersId;
    }

    public void setUsersRolesByUsersId(UsersRolesEntity usersRolesByUsersId) {
        this.usersRolesByUsersId = usersRolesByUsersId;
    }
}
