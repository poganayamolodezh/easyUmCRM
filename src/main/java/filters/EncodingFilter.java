package filters;

import javax.servlet.*;
import java.io.FileFilter;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //��� ������� ��� ������� TomCat ���� ���
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //��� ������� �����������
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        //����� ��������� ������ �������

        //����� �� ������� � ���������� ���������� ��������� ������
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //��� ������� ��� ���������� TomCat ���� ���

    }
}
