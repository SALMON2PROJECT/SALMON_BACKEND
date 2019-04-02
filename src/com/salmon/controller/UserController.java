package com.salmon.controller;


import com.salmon.Services.UserService;
import com.salmon.TO.Roles;
import com.salmon.TO.Users;
import org.apache.catalina.realm.GenericPrincipal;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired // put userservise (obj) to to spring container
    private UserService userService;

    @RequestMapping(value = "/userRegister") //conect two request together // POST is form from JSON BASE from axios
    public void userReg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { //REquest body : get the data from front as string
        try {


            Users users = new Users();
            users.setUsername(request.getParameter("username"));
            users.setUserpass(request.getParameter("userpass"));
            Roles roles = new Roles();// TO folder
            roles.setRoleName("user");
            roles.setUsername(users.getUsername());
            userService.register(users);// write to PSQL
            userService.roleReg(roles);
        response.sendRedirect("//localhost:3000/Login");}
        catch (DataIntegrityViolationException e){
            System.out.println("duplicate in registeration");
            response.sendRedirect("//localhost:3000/register");
        }
        // MVC  = model (TO + repo + JPA ) + view (React) + Controller(Servlet)   tomcat ba servlet ertebat darad info migire
        // JPA is a standard to communicate with hibernate
    }

    /**
     * @param json
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * =================================LOGIN===============================
     */

    @RequestMapping(value = "/userLogin")
// Determine the address of the servlet (Action form) // we send in request form not Gison
    @ResponseBody
    public String userLogin(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// create two object from HttpSelv...
        try {
            JSONObject jsonObject = new JSONObject(json.toString());

            String username = jsonObject.getString("username");//get request parameter from front

            String password = jsonObject.getString("userpass");
            System.out.println("username:" + username);
            System.out.println("password:" + password);

            try { // true
                request.login(username, password); // realm ask from database
                GenericPrincipal genericPrincipal = (GenericPrincipal) request.getUserPrincipal();//get user role from generic principal
                String role = genericPrincipal.getRoles()[0];

                System.out.println("role" + role);
                JSONObject jsonObject1 = new JSONObject();
                System.out.println("===================");
                System.out.println("LOGIN successful");
                System.out.println("===================");
                jsonObject1.put("userName", username);
                jsonObject1.put("state", true);
                String str = jsonObject1.toString();
                return str;
            } catch (Exception e) {
                response.setStatus(403);//set forbidden(403) status in response
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("state", false);
                String str = jsonObject1.toString();
                return str;
            }
        } catch (JSONException je) {
            System.out.println("json has an exception");
            return null;
        }
    }

    @RequestMapping(value = "/logout") // Action Form
    public String logout(HttpServletRequest request) throws ServletException {

        request.logout();
        return "Login";

    }

}



