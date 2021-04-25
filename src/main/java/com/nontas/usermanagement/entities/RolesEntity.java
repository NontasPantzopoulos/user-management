package com.nontas.usermanagement.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "public", catalog = "my_db_users")
public class RolesEntity {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private UsersRolesEntity usersRolesByRoleId;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_desc")
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return roleId == that.roleId && Objects.equals(roleName, that.roleName) && Objects.equals(roleDesc, that.roleDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleDesc);
    }

    @OneToOne(mappedBy = "rolesByUsersRolesId")
    public UsersRolesEntity getUsersRolesByRoleId() {
        return usersRolesByRoleId;
    }

    public void setUsersRolesByRoleId(UsersRolesEntity usersRolesByRoleId) {
        this.usersRolesByRoleId = usersRolesByRoleId;
    }
}
