package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //�������� servletRequest � servletResponse � ��������� ���� HttpServletRequest ����� �������� ������ ���
        //������ � �������� getSession()
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        //��������, ���������� ������� �������� �� ����� �������� ����� ���� css, js � ��.
        String url = req.getRequestURI();
        if(url.endsWith(".css")||url.endsWith("js")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //�������� ���� �� � req ������� isLogin � ������ ������ ����� ���������
        Object isLogin = req.getSession().getAttribute("isLogin");

        //���� �������� isLogin = true, �� ���� ������������ ������ ��������� � �� ���� �� LogIn
        if(isLogin != null && url.endsWith("/login")){
            //�������������� �� index
            resp.sendRedirect("/");
            return;
        }

        //���� �������� isLogin = true, �� ���� ������������ ������ ��������� � �� ��� �� ����� ������
        if(isLogin != null && !url.endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //���� �������� isLogin = null, �� ���� ������������ ������ �� ��������� � �� ���� �� LogIn
        if (url.endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            resp.sendRedirect("/login");
        }


    }

    @Override
    public void destroy() {

    }
}
