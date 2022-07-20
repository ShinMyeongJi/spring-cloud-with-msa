/**
package com.shinmj.userservice.config;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT를 사용할 것이니 세션 필요 x
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/**").permitAll()
                //.anyRequest().permitAll()
                .anyRequest().hasRole("USER")
                .and()
        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
                //.and()
                //.addFilterBefore(new

        */
/*http.authorizeRequests().antMatchers("/**")
                .hasIpAddress(env.getProperty("gateway.ip")) // <- IP 변경
                .and()
                .addFilter(getAuthenticationFilter());
*//*

        http.headers().frameOptions().disable();
    }
}

*/
