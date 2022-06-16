package com.shinmj.userservice.filter;


import com.shinmj.userservice.util.JwtTokenProvider;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.AllArgsConstructor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@AllArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        if (StringUtils.isNotEmpty(token) && jwtTokenProvider.validateJwtToken(token)) {

        }

    }
}
