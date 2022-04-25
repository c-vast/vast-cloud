package com.vast.system.service;

import com.vast.common.dto.ClientInfoDTO;

public interface ClientService {
    ClientInfoDTO getClientByClientId(String clientId);
}
