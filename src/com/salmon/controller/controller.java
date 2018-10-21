package com.salmon.controller;

import com.google.gson.Gson;
import com.salmon.TO.Roles;
import com.salmon.TO.Users;
import com.salmon.repository.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public String userReg(@RequestBody String string) throws IOException {

        System.out.println("i am here");
        System.out.println(string);
        Gson gson=new Gson();
        Users users=gson.fromJson(string,Users.class);

        Roles roles=new Roles();
        roles.setRoleName("user");
        roles.setUsername(users.getUsername());
        userService.register(users);
        userService.roleReg(roles);
        System.out.println("done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "redirect:/user/userReg.do";

    }
    @RequestMapping(value = "/userReg",method = RequestMethod.GET)
    public String regRedirect() {
        System.out.println("i am here in response!!!!!!!!!!!!!!!!!!!");
        return "redirect://localhost:3000/user";

    }

    @RequestMapping(value = "/adminRegister")
    public String adminLogin()
    {
        Users users=new Users();
        users.setUsername("farbod");
        users.setUserpass("123");
        userService.register(users);
        Roles roles=new Roles();
        roles.setRoleName("admin");
        roles.setUsername("farbod");
        userService.roleReg(roles);
        System.out.println("admin registered!!!!!!!!!!");
        return "adminLogin";
    }

    @RequestMapping(value = "/adminLogin")
    public String adminLogin(@RequestBody String str,HttpServletRequest request) throws ServletException{


        Gson gson=new Gson();
        Users users=gson.fromJson(str,Users.class);
        String adminUsername=users.getUsername();
        String adminPass=users.getUserpass();
        try {
            request.login(adminUsername,adminPass);
            return "redirect://localhost:3000/admin";
        }catch (Exception e){
            return "redirect://localhost:3000/error";
        }
    }


    @RequestMapping(value = "/userLogin")
    public String userLogin(@RequestBody String str, HttpServletRequest request)throws ServletException,IOException{
        Gson gson=new Gson();
        Users users=gson.fromJson(str,Users.class);
        String username=users.getUsername();
        String password=users.getUserpass();

        try {
            request.login(username,password);
            return "redirect://localhost:3000/user";
        }catch (Exception e){
            return "redirect://localhost:3000/error";
        }


    }


    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws ServletException{

        request.logout();
        return "login";

    }

}