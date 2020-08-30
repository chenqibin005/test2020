package com.liko;

import com.liko.entity.Student;
import com.liko.util.Mybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/8/24 15:16
 */
public class MaApp {
    public static void main(String[] args) {

        SqlSession sqlSession = Mybatis.getSqlSession();
        String sqlId="com.liko.dao.StudentDao"+"."+"selectStu";
        //            com.liko.dao.StudentDao
        List<Student> studentList =sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
}
