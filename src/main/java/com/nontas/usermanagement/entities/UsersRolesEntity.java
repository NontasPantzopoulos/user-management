package com.nontas.usermanagement.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_roles", schema = "public", catalog = "my_db_users")
public class UsersRolesEntity {
    private int usersRolesId;
    private int usersId;
    private int rolesId;
    private RolesEntity rolesByUsersRolesId;
    private UsersEntity usersByUsersRolesId;

    @Id
    @Column(name = "users_roles_id")
    public int getUsersRolesId() {
        return usersRolesId;
    }

    public void setUsersRolesId(int usersRolesId) {
        this.usersRolesId = usersRolesId;
    }

    @Basic
    @Column(name = "users_id")
    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Basic
    @Column(name = "roles_id")
    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRolesEntity that = (UsersRolesEntity) o;
        return usersRolesId == that.usersRolesId && usersId == that.usersId && rolesId == that.rolesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersRolesId, usersId, rolesId);
    }

    @OneToOne
    @JoinColumn(name = "users_roles_id", referencedColumnName = "role_id", nullable = false)
    public RolesEntity getRolesByUsersRolesId() {
        return rolesByUsersRolesId;
    }

    public void setRolesByUsersRolesId(RolesEntity rolesByUsersRolesId) {
        this.rolesByUsersRolesId = rolesByUsersRolesId;
    }

    @OneToOne
    @JoinColumn(name = "users_roles_id", referencedColumnName = "users_id", nullable = false)
    public UsersEntity getUsersByUsersRolesId() {
        return usersByUsersRolesId;
    }

    public void setUsersByUsersRolesId(UsersEntity usersByUsersRolesId) {
        this.usersByUsersRolesId = usersByUsersRolesId;
    }
}
