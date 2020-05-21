package cn.bdqn.dao.impl;

import cn.bdqn.dao.stuDao;
import cn.bdqn.entity.Record;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lijie
 * @Date: 2020/5/12 9:57
 * @Description:
 */
@Repository
public class stuDaoImpl extends HibernateDaoSupport implements stuDao {
    //登录
    @Override
    public List<User> login(User user) {
        String hql="from User u where u.name=? and u.password=?";
        return this.getHibernateTemplate().find(hql,new String[]{user.getName(),user.getPassword()});
       // return this.getHibernateTemplate().findByExample(user);
    }

    //查询全部学生
    @Override
    public List<Student> studentList() {
        String hql="from Student";
        return this.getHibernateTemplate().find(hql);
    }

    //学生查看奖惩资料（通过code进行关联学号）view
    @Override
    public List<Record> recordCode(Record record) {
        String hql="select new Record(r.rid,r.student,r.name,r.createDate,r.createBy,r.des,r.stuCode) from Record r where r.rid=?";
        return this.getHibernateTemplate().find(hql,record.getRid());
    }
    //通过奖惩姓名和学生姓名进行模糊查询 以及
    @Override
    public List<Record> recordList(Record record) {
        String hql="select new Record(r.rid,r.student,r.name,r.createDate,r.createBy,r.des,r.stuCode) from Record r where r.name=? or r.student.name=?";
        return this.getHibernateTemplate().find(hql,new String[]{record.getName(),record.getStudent().getName()});
    }
    //奖惩全部查询
    @Override
    public List<Record> recordListList() {
       // String hql="select r.rid,r.name,r.student.name,r.createBy,r.createDate from Record r";
        String hql="select new Record(r.rid,r.student,r.name,r.createDate,r.createBy,r.des,r.stuCode) from Record r";
        return this.getHibernateTemplate().find(hql);
    }

    //进行新增 修改
    @Override
    public void saveOrUpdate(Record record) {
            this.getHibernateTemplate().saveOrUpdate(record);
    }
    //进行删除
    @Override
    public void deleteRecord(Record record) {
        this.getHibernateTemplate().delete(record);
    }
}
