package com.vast.system.service.impl;

import com.vast.common.component.MinioOperator;
import com.vast.system.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Service
public class MinioFileServiceImpl implements FileService {

    @Autowired
    private MinioOperator minioOperator;

    @Override
    public void upload(MultipartFile[] multipartFile) {

    }

    @Override
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) {

    }

    @Override
    public void batchDownload(List<String> fileNames, String zip, HttpServletResponse response, HttpServletRequest request) {

    }
}
