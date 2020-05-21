package cn.bdqn.service;

import cn.bdqn.entity.Record;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @Date: 2020/5/12 11:19
 * @Description:业务逻辑层
 */
public interface stuService {
    //登录
    public User login (User user) throws Exception;
    //全部学生查询
    public List<Student> studentList() throws Exception;
    //学生查看奖惩资料（通过code进行关联学号）
    public List<Record> recordCode(Record record) throws Exception;
    //通过奖惩姓名和学生姓名进行模糊查询 以及全部查询
    public List<Record> recordList(Record record) throws Exception;
    //奖惩全部查询
    public List<Record> recordListList();
    //进行 修改和新增 奖惩管理
    public Boolean saveOrUpdate(Record record) throws Exception;
    //进行删除奖惩信息
    public Boolean deleteRecord(Record record) throws Exception;
}
