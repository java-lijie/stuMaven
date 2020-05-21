package cn.bdqn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lijie
 * @Date: 2020/5/12 9:25
 * @Description:用户类
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
