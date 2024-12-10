package alphaben.jwtauth;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class BootFillter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("doFilter");
           filterChain.doFilter(servletRequest, servletResponse);
    }
}
