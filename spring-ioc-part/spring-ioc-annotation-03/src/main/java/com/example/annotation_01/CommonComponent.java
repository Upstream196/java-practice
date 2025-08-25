package com.example.annotation_01;

import org.springframework.stereotype.Component;

//1.标记注释标签
@Component //->通用标签其他所有标签都与其他功能相同,但用于具体区分不同层路而采用的不同名字
//->作用相当于bean标签声明 <bean id="commonComponent" class="CommonComponent"/>
// 视频里说id名默认为类名的首字母小写,那么是否意味着可定义取名,而class名则为实现类的名字这与pom配置文件中具体操作有何不同？

//2.配置指定包
public class CommonComponent {
}
