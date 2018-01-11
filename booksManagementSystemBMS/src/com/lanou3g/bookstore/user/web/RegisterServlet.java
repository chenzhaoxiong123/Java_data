package com.lanou3g.bookstore.user.web;

import com.lanou3g.bookstore.user.bean.User;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.util.EmailUtil;
import com.lanou3g.bookstore.util.UUID;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/regist")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String uid = request.getParameter("uid");

        User user = new User();
        UserDao userDao = new UserDao();
        EmailUtil emailUtil = new EmailUtil();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        String s = null;
        System.out.println("12345612");
        try {
            s = emailUtil.t1(email);
            System.out.println("2456456");
//            if (s == uid){
//                System.out.println(s+",,,");
//                System.out.println(uid+",,,,,,");
//                user.setState(1);
//            }else {
//                user.setState(0);
//            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        user.setUid(s);
        user.setCode(s+s);



//        String uuid = UUID.uuid();
//        user.setUid(uuid);
//        String ss=uuid+UUID.uuid();
//        user.setCode(ss);
//        user.setState(1);
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int inserts = 0;
        try {
            inserts = userDao.inserts(user);
            System.out.println(inserts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (inserts == 1){
            request.getRequestDispatcher(request.getContextPath()+"/jsps/user/login.jsp").forward(request,response);
        }else {
            response.sendRedirect("/jsps/user/regist.jsp");
        }
//        userService.register(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
