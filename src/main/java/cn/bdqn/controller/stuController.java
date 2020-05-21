package cn.bdqn.controller;



import cn.bdqn.entity.Record;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.service.stuService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author lijie
 * @Date: 2020/5/12 12:12
 * @Description:业务控制层
 */
@Controller
public class stuController {
        //自动扫描
        @Autowired
        stuService stuService;

        //登录验证
        @RequestMapping("login.html")
        public String login(HttpServletRequest request, HttpSession session, User user)
        {
            User user1=null;
            try{
                user1=stuService.login(user);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            if (user1!=null){
                //登录成功
                session.setAttribute("user",user1);
                return "module";
            }
            request.setAttribute("error","用户名或者密码错误");
            return "login";

        }
         //进入sy
         @RequestMapping("sy")
         public String sy()
         {
             return "sy";
         }
        //注销功能
        @RequestMapping("zx")
        public String zx(HttpSession session)
        {
            try {
                /*remove和invilidate的区别：
        session.invalidate()，这个会使整个客户端对应的Session失效，里面的所有东西都会被清空，同时也释放了资源。
        通过session.removeAttribute方法删除的是我们传递的对象，不会让整个Session失效。*/

                //删除session
                session.removeAttribute("user");
                //使session失效
                session.invalidate();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "login";
        }
        //学生信息查询
        @RequestMapping("studentList")
        public  String studentList(Model model)
        {
            List<Student> StudentList=null;
            try {
                StudentList=stuService.studentList();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("学生信息查询报错");
            }
            model.addAttribute("StudentList", StudentList);
            return "studentList";
        }
        //查看
        @RequestMapping("view.html")
        public String view(@RequestParam("stuCode") String stuCode, Model model)
        {
            Record record=new Record();
            record.setRid(Integer.parseInt(stuCode));
            List<Record> ViewList=null;
            try {
                ViewList=stuService.recordCode(record);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            model.addAttribute("ViewList", ViewList);
            return "view";
        }
        //奖惩表的全部查询操作
        @RequestMapping("list.html")
        public String recordList(Model model)
        {
            List<Record> RList=null;
            try {
                RList=stuService.recordListList();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            for (Record s:RList) {
                System.out.println(s.getName());
            }
            if (RList!=null && RList.size()>0 &&!RList.equals("")) {
                model.addAttribute("Recordll", RList);
            }
            return "list";
        }
        //奖惩表的全部查询操作条件
        @RequestMapping(value="listTj.html")
        public String recordListTj(Record record,Model model)
        {
            List<Record> RecordList=null;
            try {
                RecordList=stuService.recordList(record);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            model.addAttribute("Recordll", RecordList);
            return "list";
        }
        //删除信息
        @RequestMapping("delete/{id}")
        public String delete(@PathVariable("id") String id)
        {
            Record record=new Record();
            record.setRid(Integer.parseInt(id));
            boolean b;
            try {
                b=stuService.deleteRecord(record);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("删除报错"+e.getMessage());
            }
            if (b=true) {
                System.out.println("删除成功");
            }
            return "redirect:/list.html";
        }
        //新增
        @RequestMapping("add.html")
        public String add(Model model)
        {

            List<Student> lists=null;

            try {
                lists=stuService.studentList();
            } catch (Exception e) {
                // TODO: handle exception
            }
            model.addAttribute("name", lists);
            return "add";
        }
        //修改
        @RequestMapping("Update.html")
        public String Update(@RequestParam String id,Model model)
        {

            List<Student> lists=null;
            List<Record> recordsList=null;
                try {
                    Record record=new Record();
                    record.setRid(Integer.parseInt(id));
                    recordsList=stuService.recordCode(record);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            try {
                lists=stuService.studentList();
            } catch (Exception e) {
                // TODO: handle exception
            }
            model.addAttribute("list", recordsList);
            model.addAttribute("name", lists);
            return "change";
        }
        //保存信息
        @RequestMapping("addSave.html")
        @ResponseBody
        public Object change(Record record,HttpSession session)
        {

            HashMap<String, String> hashMap=new HashMap<String, String>();
            Date date = new Date();

            boolean bb;
            if (record.getRid()!=null) {
                try {
                    bb=stuService.saveOrUpdate(record);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("修改"+e.getMessage());
                }
            }else {
                try {
                    record.setCreateBy(((User)session.getAttribute("user")).getName());
                    record.setCreateDate(date);
                    bb=stuService.saveOrUpdate(record);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("新增"+e.getMessage());
                }
            }
            //判断是否保存成功
            if (bb=true) {
                System.out.println("信息保存成功！");
                hashMap.put("shu", "true");
            }else {
                System.out.println("信息保存失败！");
                hashMap.put("shu", "false");
            }
            return JSONArray.toJSON(hashMap);
        }



}
