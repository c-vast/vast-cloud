package com.vast.common.resolver;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vast.common.annotation.PageParam;
import com.vast.common.base.query.PageQueryParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageParamArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (!methodParameter.hasParameterAnnotation(PageParam.class)) {
            return false;
        }
        Class<?> type = methodParameter.getParameterType();
        return type.isAssignableFrom(PageQueryParam.class) || type.isAssignableFrom(Page.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        PageParam anno = methodParameter.getParameterAnnotation(PageParam.class);
        if (anno == null) {
            return null;
        }
        Class<?> type = methodParameter.getParameterType();

        Integer current = getIntParamNotNullByWebRequest(anno.currentName(), nativeWebRequest);
        Integer size = getIntParamNotNullByWebRequest(anno.sizeName(), nativeWebRequest);
        String column = nativeWebRequest.getParameter(anno.columnName());
        String isAsc = nativeWebRequest.getParameter(anno.isAscName());

        PageQueryParam pageParam = new PageQueryParam();
        pageParam.setCurrent(current);
        pageParam.setSize(size);
        if (StringUtils.isNotBlank(column)) {
            pageParam.setColumn(column);
            // 默认是升序排列
            pageParam.setIsAsc(!Boolean.FALSE.toString().equalsIgnoreCase(isAsc));
        }
        if (type.isAssignableFrom(Page.class)) {
            return pageParam.toPage();
        }
        return pageParam;
    }

    private Integer getIntParamNotNullByWebRequest(String name, NativeWebRequest webRequest) {
        String value = webRequest.getParameter(name);
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(String.format("参数: %s 为空", name));
        }
        return Integer.parseInt(value);
    }
}
