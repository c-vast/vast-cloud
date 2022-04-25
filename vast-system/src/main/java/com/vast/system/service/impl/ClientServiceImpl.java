package com.vast.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vast.common.dto.ClientInfoDTO;
import com.vast.common.exception.BusinessException;
import com.vast.common.util.Utils;
import com.vast.system.entity.OAuthClientDetailsDO;
import com.vast.system.mapper.OAuthClientDetailsMapper;
import com.vast.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private OAuthClientDetailsMapper oAuthClientDetailsMapper;

    @Override
    public ClientInfoDTO getClientByClientId(String clientId) {
        LambdaQueryWrapper<OAuthClientDetailsDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OAuthClientDetailsDO::getClientId, clientId);
        OAuthClientDetailsDO oAuthClientDetailsDO = oAuthClientDetailsMapper.selectOne(lambdaQueryWrapper);
        if (oAuthClientDetailsDO == null) {
            throw new BusinessException("客户端不存在");
        }
        ClientInfoDTO clientInfoDTO = Utils.BeanConverter(ClientInfoDTO.class, oAuthClientDetailsDO);
        return clientInfoDTO;
    }
}
