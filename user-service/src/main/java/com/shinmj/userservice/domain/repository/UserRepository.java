package com.shinmj.userservice.domain.repository;

import com.shinmj.userservice.domain.UserDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//@Repository
public interface UserRepository extends CrudRepository<UserDto, String> {
    UserDto findUserDtoBy(String id);
    Optional<UserDto> findById(String id);
}
