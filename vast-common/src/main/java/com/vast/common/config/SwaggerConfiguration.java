package com.vast.common.config;

import com.google.common.base.Predicates;
import com.vast.common.constant.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfiguration {

    @Value("${spring.application.name}")
    protected String name;

    @Bean
    public Docket createRestApi() {
        List<Parameter> parameters = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(Constants.AUTHORIZATION)
                .description("token令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        parameters.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(Predicates.or(RequestHandlerSelectors.withClassAnnotation(Api.class)
                        , RequestHandlerSelectors.withClassAnnotation(ApiOperation.class)))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("【vast-cloud】微服务平台")
                .version("v1.0.0")
                .description("【vast-cloud】" + name + "-API文档")
                .build();
    }
}
