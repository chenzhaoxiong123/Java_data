package com.lanou3g.bookstore.order.service;

import com.lanou.commons.CommonUtils;
import com.lanou3g.bookstore.cart.bean.CartItem;
import com.lanou3g.bookstore.user.bean.User;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderService",urlPatterns = "/order")
public class OrderService extends BaseServlet {
    public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        User user = (User) request.getSession().getAttribute(bid);
        if (user == null){
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }
        CartItem cartItem = CommonUtils.toBean(request.getParameterMap(), CartItem.class);
        cartItem.setBid(bid);
    }
}
