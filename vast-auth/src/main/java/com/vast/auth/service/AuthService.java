package com.vast.auth.service;

import com.vast.common.dto.UserDTO;

public interface AuthService {
    UserDTO login(String username,String password);
    String refreshToken(String token,String refreshToken);
}
