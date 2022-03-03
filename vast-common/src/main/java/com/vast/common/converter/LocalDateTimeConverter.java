package com.vast.common.converter;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        DateTimeFormat annotation = excelContentProperty.getField().getAnnotation(DateTimeFormat.class);
        return LocalDateTime.parse(cellData.getStringValue(),
                DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : DEFAULT_PATTERN));
    }

    @Override
    public CellData convertToExcelData(LocalDateTime localDateTime, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        DateTimeFormat annotation = excelContentProperty.getField().getAnnotation(DateTimeFormat.class);
        return new CellData(localDateTime.format(DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : DEFAULT_PATTERN)));
    }
}
