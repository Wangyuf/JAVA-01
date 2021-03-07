package com.example.lesson14.aspect;

import com.example.lesson14.annotation.DataSource;
import com.example.lesson14.datasource.DataSourceContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: lesson14 DynamicDataSourceAspect.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:24
 */
@Component
@Aspect
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.example.lesson14.service.*.*(..)))")
    private void aspect(){}


    @Before("aspect()")
    public void before(JoinPoint point) {
        try {
            //获取类上@DataSource注解
            DataSource annotationOfClass = point.getTarget().getClass().getAnnotation(DataSource.class);

            //获取方法上@DataSource注解
            String methodName = point.getSignature().getName();
            Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();
            Method method = point.getTarget().getClass().getMethod(methodName, parameterTypes);
            DataSource methodAnnotation = method.getAnnotation(DataSource.class);

            methodAnnotation = methodAnnotation == null ? annotationOfClass : methodAnnotation;
            String dsName = "";
            if(methodAnnotation!=null) {
                System.out.println("使用注解上标记的数据源:"+dsName);
                dsName = methodAnnotation.value();
            }else {
                System.out.println("没有注解指定数据源，随机使用一个数据源");
                dsName = DataSourceContext.randomDataSource();
            }
            DataSourceContext.setDataSource(dsName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("aspect()")
    public void after(JoinPoint point) {
        DataSourceContext.clearDataSource();
    }
}
