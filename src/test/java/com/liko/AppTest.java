package com.liko;

import static org.junit.Assert.assertTrue;

import com.github.pagehelper.PageHelper;
import com.liko.dao.StudentDao;
import com.liko.entity.Student;
import com.liko.util.Mybatis;
import com.liko.util.test01;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class AppTest {

    @Test
    public void TestSelectIf() {
        SqlSession sqlSession =Mybatis.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setUserName("张飞");
        student.setSex("男");
        List<Student> studentList =dao.selectIf(student);
        studentList.forEach(student1 -> System.out.println(student1));
    }
    @Test
    public void TestSelectWhere() {
        SqlSession sqlSession =Mybatis.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setUserName("张飞");
       // student.setSex("男");
        List<Student> studentList =dao.selectWhere(student);
        studentList.forEach(student1 -> System.out.println(student1));
    }
    @Test
    public void TestSelectfor() {
        SqlSession sqlSession =Mybatis.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Student> studentList =dao.selectFor(list);
        studentList.forEach(student1 -> System.out.println(student1));
    }
    @Test
    public void TestSelectlistfor() {
        SqlSession sqlSession =Mybatis.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        Student student1 = new Student();
        student1.setUserId(1);
        Student student2 = new Student();
        student2.setUserId(2);

        List<Student> list =new ArrayList<>();
        list.add(student1);
        list.add(student2);

        List<Student> studentList =dao.selectForlist(list);
        studentList.forEach(student5 -> System.out.println(student5));
    }
    @Test
    public void testSelectAll(){
        //分页方法 pageNum：第几页 pageSize:一共有多少数据
        PageHelper.startPage(3,3);
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        List<Student> list =dao.selectStu();
        list.forEach(student -> System.out.println(student));
    }
}
