package com.yjiewei.controller;

import com.yjiewei.entity.Blogger;
import com.yjiewei.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yjiewei
 * @date 2021/8/10
 */
@Controller // 注意不能使用R
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/404")
    public String test404(){
        return "index"; // 这个返回值根本不会用到，不重要，显示500错误，因为是这个index页面找不到。
    }

    @RequestMapping("/500")
    public String test500(){
        int i = 1/0;
        return "index"; // 这个返回值根本不会用到，不重要
    }

    /**
     * thymeleaf中处理对象，如果是页面访问这个接口呢？参数怎么封装传入
     * @param model
     * @return
     */
    @GetMapping("/getBlogger")
    public String getBlogger(Model model) { // model对象，页面控制器？模型转换器
        Blogger blogger = new Blogger(1L, "杨杰炜", "123456");
        model.addAttribute("blogger", blogger); // 把信息携带过去，页面再展示出来。
        return "blogger";
    }

    @GetMapping("/getList")
    public String getList(Model model) {
        Blogger blogger1 = new Blogger(1L, "杨杰炜", "123456");
        Blogger blogger2 = new Blogger(2L, "前端怎么传参呢", "123456");
        List<Blogger> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("input")
    public String input(){
        //转入input.html页面
        return "input";
    }

    @RequestMapping("out")
    //此处与前面input.html中th:action="@{/out}"对应
    public String outputmessage(@RequestParam("name") String name,
                                @RequestParam("sex") String sex,
                                @RequestParam("age") int age,
                                @RequestParam("education") String education,
                                @RequestParam("information") String information,
                                //此注解用于接收表单传递的内容
                                Model model){
        Person person = new Person(name,sex,age,education,information);
        model.addAttribute("myperson",person);
        //将自定义的person实体添加到model模型中，方便后面获取，转入output.html页面
        return "output";

    }
}
