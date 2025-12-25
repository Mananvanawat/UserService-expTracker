package com.manan.userService.repository;

import com.manan.userService.entities.UserInfo;
import com.manan.userService.entities.UserInfoDto;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {

    Optional<UserInfo> findByUserId(String userId);

}
