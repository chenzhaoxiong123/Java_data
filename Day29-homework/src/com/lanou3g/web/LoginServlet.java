package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.dao.UserDao;
import com.lanou3g.daomain.Book;
import com.lanou3g.daomain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
//        BookDao bookDao = new BookDao();
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userDao.findByName(username);
//            System.out.println(user);
            if(user!=null&&user.getPassword().equals(password)){
                getServletContext().setAttribute("user",user);

                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password",password);



                request.getRequestDispatcher("/index.jsp").forward(request,response);
//                response.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                response.sendRedirect("http://localhost:8080/login.html");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
//                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        Book book = new Book();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        try {
//            BeanUtils.populate(book,parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        List<Book> book1 = bookDao.findBook();
//        System.out.println(book1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
