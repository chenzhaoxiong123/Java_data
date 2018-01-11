package com.lanou3g.bookstore.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();
        Method method = null;
        System.out.println(methodName);
        try {
            method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(methodName);
        }
        try {
            String invoke = (String) method.invoke(this, req, resp);
            String[] split = invoke.split(":");
            String type = split[0];
            String path = split[1];
            if(type.equals("f")){
                System.out.println("f");
                System.out.println(path);
                req.getRequestDispatcher(path).forward(req,resp);
            }
            if (type.equals("r")){
                resp.sendRedirect(req.getContextPath()+path);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
