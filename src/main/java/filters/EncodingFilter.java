package filters;

import javax.servlet.*;
import java.io.FileFilter;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Что сделать при запуске TomCat один раз
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Для каждого контроллера
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        //Можно запускать другие фильтры

        //Выйти из фильтра и продолжить выполнение основного потока
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //Что сделать при выключении TomCat один раз

    }
}
