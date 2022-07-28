package com.shinmj.auth.init;


import com.shinmj.auth.config.WebSecurityConfig;
import com.shinmj.auth.domain.User;
import com.shinmj.auth.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();


        System.out.println(WebSecurityConfig.passwordEncoder().encode("1234"));

        user.setId("tester");
        user.setEncryptPw(WebSecurityConfig.passwordEncoder().encode("1234")); // 될까;;?
        user.setName("tester");
        user.setRole("USER");

        userRepository.save(user);

    }
}
