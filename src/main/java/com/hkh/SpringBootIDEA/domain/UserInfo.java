package com.hkh.SpringBootIDEA.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserInfo { //先不实现序列化接口
    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private String salt;
    private byte state; //0创建未认证等待验证1正常2被锁定
    @ManyToMany(fetch = FetchType.EAGER) //立即从数据库中进行加载数据
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}
