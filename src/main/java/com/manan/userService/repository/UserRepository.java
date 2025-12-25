package com.manan.userService.repository;

import com.manan.userService.entities.UserInfo;
import com.manan.userService.entities.UserInfoDto;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {

    UserInfoDto findByUserId(String userId);

}
