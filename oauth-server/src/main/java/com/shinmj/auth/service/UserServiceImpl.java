package com.shinmj.auth.service;


import com.shinmj.auth.domain.User;
import com.shinmj.auth.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 토큰에 포함된 유저 정보로 유저를 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        // TODO. user 권한 print (using stream)
        log.info("user " + user.getName() + "님의 권한은 " + user.getAuthorities().toArray()[0]);

        return user;
        //return new User(user.get().getId(), user.get().getEncrypt_pw());
    }
}
