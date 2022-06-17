package com.shinmj.userservice.filter;


import com.shinmj.userservice.util.JwtTokenProvider;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

            if (StringUtils.isNotEmpty(token) && jwtTokenProvider.validateJwtToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }else {
                if (StringUtils.isEmpty(token)) {
                    request.setAttribute("unauthorization", "401 인증키 없음.");
                }

                if (jwtTokenProvider.validateJwtToken(token)) {
                    request.setAttribute("unauthorization", "401-001 인증키 만료.");
                }
            }
        }catch (Exception e) {
            logger.error("Could not set user authentication in security context", e);
        }

        filterChain.doFilter(request, response);
    }
}
