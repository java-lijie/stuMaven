package cn.bdqn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lijie
 * @Date: 2020/5/12 9:30
 * @Description:学生类
 */
@Entity
@Table(name = "T_STUDENT")
public class Student implements Serializable {
    @Id
    @Column(name = "ID" )
    private Integer id;

    @Column(name = "CODE" )
    private String code;

    @Column(name = "NAME" )
    private String name;

    @Column(name = "MAJOR" )
    private Long major;

    @Column(name = "GRADE" )
    private String grade;

    @Column(name = "SEX" )
    private Long sex;

    @Column(name = "BIRTHDAY" )
    private Date birthday;

    @Column(name = "TEL" )
    private Long tel;

    @Column(name = "JOB" )
    private Long job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Long getJob() {
        return job;
    }

    public void setJob(Long job) {
        this.job = job;
    }


}
