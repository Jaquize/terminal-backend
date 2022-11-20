package mou.terminal.config;

import lombok.RequiredArgsConstructor;
import mou.terminal.service.OauthUserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final OauthUserInfoService oauthUserInfoService;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{


        http
//                .cors()
//                .and()
//                .csrf().disable()
                .authorizeHttpRequests()
                .mvcMatchers("/favicon.ico").permitAll()
//                .anyRequest().denyAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .successHandler((request, response, authentication) -> {
//                    response.sendRedirect("/login/success");})
//                .failureHandler((request, response, exception) -> {
//                    response.sendRedirect("/login/fail");
//                })
//                .and()
//                .oauth2Login()
//                .loginPage("/login/aa")
//                .authorizationEndpoint()
//                .baseUri("/oauth2/authorization")
//                .and()
//                .redirectionEndpoint()
//                .baseUri("/*/oauth2/code/*")
//                .and()
//                .userInfoEndpoint()
//                .userService(oauthUserInfoService);
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(oauthUserInfoService);

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsServicez(){

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

}
