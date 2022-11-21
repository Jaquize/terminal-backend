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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final OauthUserInfoService oauthUserInfoService;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{


        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
//                .mvcMatchers("/favicon.ico").permitAll()
                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .successHandler((request, response, authentication) -> {
//                    response.sendRedirect("/login/success");})
//                .failureHandler((request, response, exception) -> {
//                    response.sendRedirect("/login/fail");
//                })
                .and()
                .oauth2Login()
//                .loginPage("/login/aa")
                .defaultSuccessUrl("/login/success")
                .authorizationEndpoint()
                .baseUri("/oauth2/authorization")
                .and()
                .redirectionEndpoint()
                .baseUri("/*/oauth2/code/*")
                .and()
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

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**",corsConfiguration);

        return src;

    }

}
