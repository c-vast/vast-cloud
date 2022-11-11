package com.vast.system.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    void upload(MultipartFile[] multipartFile);
    void download(String fileName, HttpServletResponse response, HttpServletRequest request);
    void batchDownload(List<String> fileNames, String zip, HttpServletResponse response, HttpServletRequest request);

}
