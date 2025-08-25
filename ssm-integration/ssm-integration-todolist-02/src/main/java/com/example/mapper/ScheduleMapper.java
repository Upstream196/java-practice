package com.example.mapper;

import com.example.pojo.Schedule;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


public interface ScheduleMapper {

    List<com.example.pojo.Schedule> queryList();

    int deleteById(Integer id);

    int insert(com.example.pojo.Schedule schedule);

    int update(com.example.pojo.Schedule schedule);

    //单条查询
    Schedule findById(Integer id);//->返回值是多种类型值作为属性返回对象类型
    //多条查询
    List<Schedule> findIncompleteSchedules();//->返回值是对象类且为多个相同对象使用集合类型
    //分页查询
    List<Schedule> findByTitleLike(@Param("keyword") String keyword);
    //批量删除
    int deleteBatch(@Param("ids") Integer[] ids);
    //批量插入
    int insertBatch(@Param("list") List<Schedule> list);//->为什么使用List而删除使用Integer？
    //批量修改
    int updateBatch(@Param("list") List<Schedule> list);
    //动态查询
    List<Schedule> findByConditions(@Param("cond") Schedule cond);
}
