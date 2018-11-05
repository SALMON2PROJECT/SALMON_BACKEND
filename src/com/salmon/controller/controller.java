package com.salmon.controller;


import com.salmon.TO.Roles;
import com.salmon.TO.Users;
import com.salmon.repository.UserService;
import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.beans.factory.annotation.Autowired;// selvlet stage
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/user")
public class controller {

    @Autowired // put userservise (obj) to to spring container
    private UserService userService;

    @RequestMapping(value = "/userRegister") //conect two request together // POST is form from JSON BASE from axios
    public void userReg(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{ //REquest body : get the data from front as string

        /*System.out.println("i am here");
        System.out.println(string);
        Gson gson=new Gson();*/
        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        Users users=new Users();
        users.setUsername(username);
        users.setUserpass(userpass);
        Roles roles=new Roles();// TO folder
        roles.setRoleName("user");
        roles.setUsername(users.getUsername());
        userService.register(users);// write to PSQL
        userService.roleReg(roles); //
        response.sendRedirect("//localhost:3000/Login");
        // MVC  = model (TO + repo + JPA ) + view (React) + Controller(Servlet)   tomcat ba servlet ertebat darad info migire
        // JPA is a standard to communicate with hibernate
    }


    @RequestMapping(value = "/userLogin")// Determine the address of the servlet (Action form) // we send in request form not Gison
    public void userLogin( HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {// create two object from HttpSelv...

        String username = request.getParameter("username");//get request parameter from front
        String password = request.getParameter("userpass");
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        /*request.login(username, password); // realm ask from database
        System.out.println("getRemoteUser?.." + request.getRemoteUser());
        System.out.println("getUserPrincipal?.." + request.getUserPrincipal());
        System.out.println("getAuthType?.." + request.getAuthType());*/

            try { // true
                request.login(username,password); // realm ask from database
                GenericPrincipal genericPrincipal= (GenericPrincipal) request.getUserPrincipal();//get user role from generic principal
                String role=genericPrincipal.getRoles()[0];
                System.out.println("role"+role);
                response.sendRedirect("//localhost:3000/"+role);
            }
            catch (Exception e){
                response.setStatus(403);//set forbidden(403) status in response
            }
    }
    @RequestMapping(value = "/logout") // Action Form
    public String logout(HttpServletRequest request) throws ServletException{

        request.logout();
        return "Login";

    }

}



