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
        //ѕриведем servletRequest и servletResponse к дочернему типу HttpServletRequest чтобы получить методы дл€
        //работы с сесси€ми getSession()
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        //–зрешить, пропустить запросы браузера на файлы ресурсов сайта типа css, js и тд.
        String url = req.getRequestURI();
        if(url.endsWith(".css")||url.endsWith("js")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //ѕроверим есть ли у req атрибут isLogin в сессии “ом ат ранее созданной
        Object isLogin = req.getSession().getAttribute("isLogin");

        //≈сли окажетс€ isLogin = true, то есть пользователь сессии залогинен и он идет на LogIn
        if(isLogin != null && url.endsWith("/login")){
            //ѕеренаправл€ем на index
            resp.sendRedirect("/");
            return;
        }

        //≈сли окажетс€ isLogin = true, то есть пользователь сессии залогинен и он иде на любой другой
        if(isLogin != null && !url.endsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //≈сли окажетс€ isLogin = null, то есть пользователь сессии не залогинен и он идет на LogIn
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
