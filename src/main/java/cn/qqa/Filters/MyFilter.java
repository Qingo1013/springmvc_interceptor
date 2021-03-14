package cn.qqa.Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("==========过滤器前==========");
        filterChain.doFilter(servletRequest,servletResponse );
        System.out.println("==========过滤器后==========");
    }

    @Override
    public void destroy() {

    }
}
