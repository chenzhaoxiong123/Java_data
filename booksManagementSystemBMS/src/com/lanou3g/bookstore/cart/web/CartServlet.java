package com.lanou3g.bookstore.cart.web;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.cart.bean.CartItem;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();
    public String addCart(HttpServletRequest request, HttpServletResponse response){
        String count = request.getParameter("count");
        String bid = request.getParameter("bid");
        CartItem book = bookDao.findBookBid(bid);
        //物品数量
        book.setCount(count);
        Map<String,CartItem> g = (Map<String,CartItem>)request.getSession().getAttribute("gwc");
        if(g==null){
            g = new HashMap<String, CartItem>();
        }
        g.put(book.getBid(),book);
        request.getSession().setAttribute("gwc",g);
        return "f:/jsps/cart/list.jsp";
    }

    public String removeAll(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("gwc");
        return "f:/jsps/cart/list.jsp";
    }
    public String remove(HttpServletRequest request,HttpServletResponse response) {
        String bid = request.getParameter("bid");
        System.out.println(bid+"aaaaa");
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(bid);
        CartItem cartItem = new CartItem();
        if (cartItem.getBid()== bid){
            System.out.println("+++____");
            session.removeAttribute(bid);
        }
        request.getSession().removeAttribute(bid);
        request.removeAttribute(bid);
//        addCart( request,  response);
        return "f:/jsps/cart/list.jsp";
    }

}