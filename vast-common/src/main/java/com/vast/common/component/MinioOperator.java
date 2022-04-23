package com.vast.common.component;

import com.vast.common.properties.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Component
@Slf4j
public class MinioOperator {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties minioProperties;

    public boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return false;
    }

    public void createBucket(String bucketName) {
        if (!this.bucketExists(bucketName)) {
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
        }
    }

    public String putObject(MultipartFile file) {
        String fileName = getFileName(Objects.requireNonNull(file.getOriginalFilename()));
        this.putMultipartFile(minioProperties.getBucketName(), fileName, file);
        return minioProperties.getEndpoint() + "/" + minioProperties.getBucketName() + "/" + fileName;
    }

    private void putMultipartFile(String bucketName, String objectName, MultipartFile file) {
        InputStream stream = null;
        try {
            stream = file.getInputStream();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .contentType(file.getContentType())
                            .stream(stream, stream.available(), -1)
                            .build()
            );
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    private static String getFileName(String objectName) {
        int lastIndexOf = objectName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return String.format("%s_%s", objectName, System.currentTimeMillis());
        } else {
            String filePrefix = objectName.substring(0, objectName.lastIndexOf("."));
            String fileSuffix = objectName.substring(objectName.lastIndexOf(".") + 1);
            return String.format("%s_%s.%s", filePrefix, System.currentTimeMillis(), fileSuffix);
        }
    }
}
