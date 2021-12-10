package com.vast.common.generator;

public class MyBatisSqlGenerator {
    public static void main(String[] args) {
        System.out.println(generateBatchSql("sys_test","id","id","list",new String[]{
                "name","time"
        }));
    }

    public static String generateBatchSql(String tableName, String pkName, String idName, String collectionName, String[] colNames) {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(tableName)
                .append(" \n")
                .append("<trim prefix=\"set\" suffixOverrides=\",\">\n");
        for (String col : colNames) {
            builder.append(String.format("<trim prefix=\"%s =case\" suffix=\"end,\">\n", col))
                    .append(String.format("<foreach collection=\"%s\" item=\"item\" index=\"index\">\n", collectionName))
                    .append(String.format("<if test=\"item.%s!=null\">\n", col))
                    .append(String.format("when %s=#{item.%s} then #{item.%s}\n", pkName, idName, col))
                    .append("</if>\n")
                    .append("</foreach>\n")
                    .append("</trim>\n");
        }
        builder.append("</trim>\n")
                .append("where ")
                .append(pkName)
                .append(" in \n")
                .append(String.format("<foreach collection=\"%s\" item=\"item\"" +
                        " index=\"index\" separator=\",\" open=\"(\" close=\")\">\n", collectionName))
                .append(String.format("#{item.%s}\n", idName))
                .append("</foreach>");
        return builder.toString();
    }
}
