package com.vast.system.repository.mongodb;

import com.vast.system.entity.SysUserInfoDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<SysUserInfoDO,Long> {
}
