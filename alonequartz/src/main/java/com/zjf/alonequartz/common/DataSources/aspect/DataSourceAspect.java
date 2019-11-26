package com.zjf.alonequartz.common.DataSources.aspect;

import com.zjf.alonequartz.common.DataSources.DataSourceNames;
import com.zjf.alonequartz.common.DataSources.DynamicDataSource;
import com.zjf.alonequartz.common.DataSources.annotation.CurDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 * AOP拦截多数据源注解 @CurDataSource 注解更换数据源
 */

@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 切点
     */
    @Pointcut("@annotation(com.zjf.alonequartz.common.DataSources.annotation.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CurDataSource curDataSource = method.getAnnotation(CurDataSource.class);
        if (curDataSource == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            logger.info("set datasource is " + DataSourceNames.FIRST);
        } else {

            DynamicDataSource.setDataSource(curDataSource.name());
            logger.info("set datasource is " + curDataSource.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.info("clean datasource");
        }
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
