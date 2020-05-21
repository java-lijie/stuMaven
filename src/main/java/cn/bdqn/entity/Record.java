package cn.bdqn.entity;




import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
/**
 * @author lijie
 * @Date: 2020/5/12 8:36
 * @Description:奖惩实体类
 */
@Entity
@Table(name = "T_RECORD")
public class Record implements Serializable {


    @Id
    @Column(name = "ID" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_rec")
    @SequenceGenerator(name = "seq_rec",sequenceName = "seq_stu_id",allocationSize = 1,initialValue = 4)
    private Integer rid;

    @Column(name = "NAME" )
    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATEDATE" )
    private Date createDate;

    @Column(name = "CREATEBY" )
    private String createBy;

    @Column(name = "DES" )
    private String des;

    @Column(name="STUCODE")
    private Integer stuCode;

    //配置多对一
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STUCODE",insertable = false, updatable = false)
    private Student student;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getStuCode() {
        return stuCode;
    }

    public void setStuCode(Integer stuCode) {
        this.stuCode = stuCode;
    }

    public Record() {
    }
    public Record(Integer rid,Student student,String name,Date createDate,String createBy,String des,Integer stuCode) {
        this.rid=rid;
        this.student=student;
        this.name=name;
        this.createBy=createBy;
        this.createDate=createDate;
        this.des=des;
        this.stuCode=stuCode;
    }

}
