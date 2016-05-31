package com.hansong.controller;

import com.hansong.model.User;
import com.hansong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xhans on 2016/5/30 0030.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public String showUser(@RequestParam("id") Integer id, ModelMap modelMap) {
        //1.调用BLL层的服务接口
        User user = userService.getUser(id);
        //2.设置模型数据
        modelMap.put("user", user);
        //3.返回逻辑视图名称
        return "showUser";
    }

}
