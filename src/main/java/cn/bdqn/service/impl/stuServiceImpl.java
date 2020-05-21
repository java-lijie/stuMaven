package cn.bdqn.service.impl;

import cn.bdqn.dao.stuDao;
import cn.bdqn.entity.Record;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.service.stuService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * @author lijie
 * @Date: 2020/5/12 11:27
 * @Description:
 */
@Transactional
@Service
public class stuServiceImpl implements stuService {

    @Autowired
    stuDao stuDao;

    @Override
    public User login(User user) throws Exception {
        User stu=null;
        List<User> list=null;
        try{
           list=stuDao.login(user);
           Iterator<User> it=list.iterator();
           while(it.hasNext())
           {
               stu=it.next();
           }
        }catch (HibernateException e)
        {
            e.printStackTrace();
        }
        return  stu;
    }

    @Override
    public List<Student> studentList() throws Exception {
        return stuDao.studentList();
    }

    @Override
    public List<Record> recordCode(Record id) throws Exception {
        return stuDao.recordCode(id);
    }

    @Override
    public List<Record> recordList(Record record) throws Exception {
        return stuDao.recordList(record);
    }

    @Override
    public List<Record> recordListList() {
        return stuDao.recordListList();
    }

    @Override
    public Boolean saveOrUpdate(Record record) throws Exception {
        try {
            stuDao.saveOrUpdate(record);
            return true;
        }catch (RuntimeException e)
        {
            System.out.println("新增修改报错"+e.getMessage());
            return false;
        }

    }

    @Override
    public Boolean deleteRecord(Record record) throws Exception {
        try{
            stuDao.deleteRecord(record);
            return true;
        }catch (RuntimeException e)
        {
            System.out.println("删除报错"+e.getMessage());
            return false;
        }
    }
}
