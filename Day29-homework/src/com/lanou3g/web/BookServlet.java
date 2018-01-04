package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.bean.Book;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        BookDao bookDao = new BookDao();
        List<Book> book = bookDao.findBook();
        JSONArray jo = JSONArray.fromObject(book);
        System.out.println(jo.toString());
        response.getWriter().write(jo.toString());
    }
}
