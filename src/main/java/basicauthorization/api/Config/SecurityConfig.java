package basicauthorization.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withUsername("user")
                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("user1"))
                .roles("USER")
                .build();

        UserDetails admin=User.withUsername("admin")
                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("admin1"))
                .roles("ADMIN")
                .build();

        UserDetails moderator=User.withUsername("moderator")
                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("moderator1"))
                .roles("MODERATOR")
                .build();
        return new InMemoryUserDetailsManager(user,admin,moderator);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/wypozyczalnia").permitAll()
                .antMatchers(HttpMethod.POST,"/wypozyczalnia").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.PUT ,"/wypozyczalnia").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.DELETE,"/wypozyczalnia/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/wypozyczalnia/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/klienci").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/klienci").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.PUT ,"/klienci").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.DELETE,"/klienci/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/klienci/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/samochody").permitAll()
                .antMatchers(HttpMethod.POST,"/samochody").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.PUT ,"/samochody").hasAnyRole("MODERATOR","ADMIN")
                .antMatchers(HttpMethod.DELETE,"/samochody/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/samochody/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/wypozyczalnia/informacje").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .formLogin().permitAll();
    }
}
