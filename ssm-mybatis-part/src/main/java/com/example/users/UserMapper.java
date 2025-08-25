package com.example.users;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //插入用户
    int insertUser(User user);

    //根据ID查询用户
    User getUserById(Integer id);


    //查询所有用户
    List<User> getAllUsers();

    //更新用户
    int updateUser(User user);

    int updateUser1( @Param("oldUsername") String oldUsername,
                     @Param("oldPassword") String oldPassword,
                     @Param("newUsername") String newUsername,
                     @Param("newPassword") String newPassword,
                     @Param("oldemail") String oldemail,
                     @Param("newemail") String newemail
    );

    //删除用户
//    int deleterUser(String username,String email);

//    int deleterUser( @Param("username") String username,
//                     @Param("email") String email
//                     );

    int deleterUser( User user);

    User getUserByUsername(
            @Param("username") String username,
            @Param("password") String password,
            @Param("email") String email
    );

    User getUserByUsername1(User user);

}
