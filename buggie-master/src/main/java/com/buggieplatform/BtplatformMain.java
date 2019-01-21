package com.buggieplatform;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.buggieplatform.entity.User;
import com.buggieplatform.repository.UserRepository;

@SpringBootApplication
public class BtplatformMain extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(BtplatformMain.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurerAdapter() {
    		@Override
    		public void addCorsMappings(CorsRegistry registry) {
    			registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
    				.allowedHeaders("*");
    		}
    	};
    }
    @Bean
    protected CommandLineRunner init(final UserRepository userRepository) {

        return args -> {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin123");
            user.setRole("admin");
            user.setSubscriptionType("premium");
            user.setProjectId("SE-15689");
            user.setPaymentType("NA");
            user.setPaymentStatus(0);
            userRepository.save(user);

        };
    }
}