package com.lanou3g.bookstore.user.web;

import com.lanou3g.bookstore.user.bean.User;
import com.lanou3g.bookstore.util.EmailUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UidServlet",urlPatterns = "/uid")
public class UidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        EmailUtil emailUtil = new EmailUtil();
        User user = new User();
        String s = null;
        try {
            s = emailUtil.t1(user.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (s == uid){
            user.setState(1);
        }else {
            user.setState(0);
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
