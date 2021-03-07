package com.example.lesson14.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: lesson14 DynamicDataSource.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:26
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContext.getDataSource();
        System.out.println("determineCurrentLookupKey ===> "+dataSource);
        return dataSource;
    }
}