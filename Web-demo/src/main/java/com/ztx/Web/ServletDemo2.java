package com.ztx.Web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


//演示servlet方法
@WebServlet("/demo2")
public class ServletDemo2 implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=config;
    }
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello ztx~");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {

    }

}
