package com.lanou3g.bookstore.book.web;

import com.lanou3g.bookstore.book.bean.Book;
import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.cart.bean.Cart;
import com.lanou3g.bookstore.cart.bean.CartItem;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    Book book = new Book();
    Cart cart = new Cart();
    private BookDao bookDao = new BookDao();
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Book> book = bookDao.findBook();
        request.setAttribute("book",book);
        return "f:/jsps/book/list.jsp";
    }

    public String findSE(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Cart cart = bookDao.findBookCname("JavaSE");
        int cid = cart.getCid();
        List<Book> books = bookDao.b(cid);
        request.setAttribute("se",books);
        return "f:/jsps/book/list.jsp";
    }

    public String findEE(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Cart cart = bookDao.findBookCname("JavaEE");
        int cid = cart.getCid();
        List<Book> books = bookDao.b(cid);
        request.setAttribute("ee",books);
        return "f:/jsps/book/list.jsp";
    }

    public String findJS(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Cart cart = bookDao.findBookCname("Javascript");
        int cid = cart.getCid();
        List<Book> books = bookDao.b(cid);
        request.setAttribute("js",books);
        return "f:/jsps/book/list.jsp";
    }

    public String particular(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        CartItem bookBid = bookDao.findBookBid(bid);
        request.getSession().setAttribute("pl",bookBid);
        return "f:/jsps/book/desc.jsp";
    }
}