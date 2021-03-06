//package camt.FitUp.Project.config;
//
//import camt.FitUp.Project.config.security.AuthenticationTokenProcessingFilter;
//import camt.FitUp.Project.config.security.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Created by Dto on 4/18/2015.
// */
//
//@Configuration
//@EnableWebSecurity
//@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService);
//    }
//
//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    private AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/**").permitAll()//hasAuthority("admin")//.access("hasRole('admin')")
//                .antMatchers(HttpMethod.PUT, "/**").permitAll()//.hasAuthority("admin")
//                .antMatchers(HttpMethod.DELETE, "/**").permitAll()//.hasAuthority("admin")
//                .antMatchers("/**").permitAll()//hasAuthority("user")
//                .and()
//                .addFilterBefore(authenticationTokenProcessingFilter, UsernamePasswordAuthenticationFilter.class)
//        ;
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/css/**", "/img/**", "/js/**", "/mp4/**", "/video/**");
//    }
//
//    @Bean(name = "myAuthenticationManager")
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
