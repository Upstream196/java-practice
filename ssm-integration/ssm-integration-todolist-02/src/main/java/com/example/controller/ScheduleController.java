package com.example.controller;

import com.example.R;
import com.example.pojo.Schedule;
import com.example.service.ScheduleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize, @PathVariable int currentPage) {

       R r =scheduleService.page(pageSize, currentPage);

       log.info("查询的数据为：{}",r);

       return r;
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id) {
        R r = scheduleService.remove(id);
        return r;
    }
    @PostMapping("/save")
    public R save(@Validated @RequestBody Schedule schedule, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return R.fail("参数为null，不能保存！");
        }
        R r=scheduleService.save(schedule);
        return r;
    }
    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return R.fail("参数为null，不能修改！");
        }
        R r=scheduleService.update(schedule);
        return r;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> findById(@PathVariable Integer id) {
        Schedule schedule = scheduleService.findById(id);
        if(schedule == null){
            //资源不存在返回404
            return ResponseEntity.notFound().build();
        }
        //存在返回200+JSON
        return  ResponseEntity.ok(schedule);
    }

    @GetMapping("/incomplete")
    public List<Schedule> findIncomplete() {
        return  scheduleService.findIncompleteSchedules();
    }

    @GetMapping("/search")
    public PageInfo<Schedule> search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return scheduleService.searchByTitle(keyword, pageNum, pageSize);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] ids) {
        int rows=scheduleService.deleteBatch(ids);

        return ResponseEntity.ok(rows);
    }

    @PostMapping("/batch")
    public ResponseEntity<Integer> insertBatch(@RequestBody List<Schedule> list) {
        int rows = scheduleService.insertBatch(list);
        return ResponseEntity.ok(rows);
    }

    @PutMapping("/batch")
    public ResponseEntity<Integer> updateBatch(@RequestBody List<Schedule> list) {
        int rows = scheduleService.updateBatch(list);
        return ResponseEntity.ok(rows);
    }

    @GetMapping("/search/byPage")
    public List<Schedule> searchPaged(Schedule cond){
        return scheduleService.findByConditions(cond);
    }
}
