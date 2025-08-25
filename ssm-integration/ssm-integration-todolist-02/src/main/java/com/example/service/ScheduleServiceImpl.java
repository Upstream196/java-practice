package com.example.service;

import com.example.PageBean;
import com.example.R;
import com.example.mapper.ScheduleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.pojo.Schedule;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R page(int pageSize, int currentPage) {
        //分页
        PageHelper.startPage(currentPage, pageSize);
        //查询
        List<com.example.pojo.Schedule> scheduleList=scheduleMapper.queryList();
        //分页数据装配
        PageInfo<Schedule> info=new PageInfo<>(scheduleList);
        //装配PageBean
        PageBean<com.example.pojo.Schedule> pageBean = new PageBean<>(currentPage,pageSize,info.getTotal(),info.getList());


        R ok = R.ok(pageBean);
        return ok;
    }

    @Override
    public R remove(Integer id) {
        int rows = scheduleMapper.deleteById(id);

        if(rows>0){
            return R.ok(null);
        }

        return R.fail(null);
    }

    public R save(com.example.pojo.Schedule schedule) {
        int rows = scheduleMapper.insert(schedule);
        if(rows>0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        if(schedule.getId()==null){
            return R.fail("核心参数为null，无法修改！");
        }
       int rows= scheduleMapper.update(schedule);

        if(rows>0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public Schedule findById(Integer id) {
        return scheduleMapper.findById(id);
    }

   @Override
    public List<Schedule> findIncompleteSchedules() {
        return  scheduleMapper.findIncompleteSchedules();
    }

    @Override
    public PageInfo<Schedule> searchByTitle(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<com.example.pojo.Schedule> list=scheduleMapper.findByTitleLike(keyword);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public int deleteBatch(Integer[] ids) {
        if(ids==null||ids.length==0){
            return 0;
        }
        return scheduleMapper.deleteBatch(ids);
    }

    @Override
    @Transactional
    public int insertBatch(List<Schedule> list) {
        if(list==null||list.isEmpty()){
            return 0;
        }
        return scheduleMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<Schedule> list) {
        if(list==null||list.isEmpty()){
            return 0;
        }
        return scheduleMapper.updateBatch(list);
    }

    @Override
    public List<Schedule> findByConditions(Schedule cond) {
        return scheduleMapper.findByConditions(cond);
    }


}
