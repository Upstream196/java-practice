package com.example;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentsMapper {
    //定义增删改查的方法

    //增加学生信息
    int insertStudent(Students students);

    //删除学生信息
    int deleteById(Integer id);

    //更改学生信息
    int updateStudent(Students students);

    //查找学生信息
    Students selectById(Integer id);

    List<Students> selectUsersByMap(Map<String, Object> params);


    List<Students> selectUsersByNameList(@Param("tableName") String tableName,
                                         @Param("list") List<String> nameList
    );
    int updateStudent1(Students students);

    int updateStudent2(@Param("students") List<Students> students);

    List<Students> selectAllStudents( @Param("name") String name,@Param("age") Integer age);

    int batchUpdateStudent(@Param("students") List<Students> students);
}
