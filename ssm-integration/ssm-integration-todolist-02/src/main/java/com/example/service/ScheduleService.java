package com.example.service;

import com.example.R;
import com.example.pojo.Schedule;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScheduleService {
    R page(int pageSize,int currentPage);

    R remove(Integer id);


    R save(Schedule schedule);

    R update(Schedule schedule);

    Schedule findById(Integer id);

    List<Schedule> findIncompleteSchedules();

   PageInfo<Schedule> searchByTitle(String keyword, int pageNum, int pageSize);

   int deleteBatch(Integer[] ids);

   int insertBatch(List<Schedule> list);

   int updateBatch(List<Schedule> list);

   List<Schedule> findByConditions(Schedule cond);

}
