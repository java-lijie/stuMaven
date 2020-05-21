package cn.bdqn.dao;

import cn.bdqn.entity.Record;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;

import java.util.List;

/**
 * @author lijie
 * @Date: 2020/5/12 9:35
 * @Description:项目实体类
 */
public interface stuDao {
    //登录
    public List<User> login (User user);
    //全部学生查询
    public List<Student> studentList();
    //学生查看奖惩资料（通过code进行关联学号）
    public  List<Record> recordCode(Record record);
    //通过奖惩姓名和学生姓名进行模糊查询
    public List<Record> recordList(Record record);
    //奖惩全部查询
    public List<Record> recordListList();
    //进行 修改和新增 奖惩管理
    public void saveOrUpdate(Record record);
    //进行删除奖惩信息
    public void deleteRecord(Record record);


}
