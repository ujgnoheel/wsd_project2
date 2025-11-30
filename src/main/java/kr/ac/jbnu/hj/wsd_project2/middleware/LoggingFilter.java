package kr.ac.jbnu.hj.wsd_project2.middleware;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 요청 로그
        System.out.println("===== [Middleware] Request =====");
        System.out.println("Method : " + request.getMethod());
        System.out.println("URI    : " + request.getRequestURI());

        // 컨트롤러로 넘기기
        filterChain.doFilter(request, response);

        // 응답 로그
        System.out.println("===== [Middleware] Response =====");
        System.out.println("Status : " + response.getStatus());
    }
}
