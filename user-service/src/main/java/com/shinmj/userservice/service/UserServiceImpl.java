package com.shinmj.userservice.service;

import com.shinmj.userservice.domain.UserDetailsImpl;
import com.shinmj.userservice.domain.UserDto;
import com.shinmj.userservice.domain.repository.UserRepository;
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
    public UserDto createUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    // 토큰에 포함된 유저 정보로 유저를 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new UserDetailsImpl(user);
        //return new User(user.get().getId(), user.get().getEncrypt_pw());
    }


}
