package com.example.config.service;

import com.example.config.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional//在 @Transactional注释后添加(readOnly = true)设置为只读模式，即不修改。
    //超时时间在以上基础上添加timeout =xx,中间使用逗号隔开
    public void changeInfo(){
        studentDao.updateAgeById(88,1);
        int i=1/0;
        System.out.println("-------------------");
        studentDao.updateNameById("test2",1);
    }
}
