package com.liko.dao;

import com.liko.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/8/24 14:34
 */
public interface StudentDao {
     List<Student> selectStu();
     List<Student> selectMutilObject(Student student);
     List<Student> selectIf(Student student);
     List<Student> selectWhere(Student student);
     List<Student> selectFor(List<Integer> list);
     List<Student> selectForlist(List<Student> stulist);
     Student selectStuById(Integer userId);
     int insertUser(Student student);
     List<Student> selectMutilParma(@Param("myname") String userName,@Param("mysex") String sex);
}
