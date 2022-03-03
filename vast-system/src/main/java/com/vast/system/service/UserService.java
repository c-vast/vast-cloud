package com.vast.system.service;

import com.vast.common.dto.UserDTO;

public interface UserService {
    UserDTO getUserInfoByUsername(String username);
    UserDTO getUserInfoByUsernameAndPassword(String username,String password);
}
