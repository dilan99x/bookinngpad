package com.candela.bookingpad.aspect;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ExceptionHandlerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAspect.class);

    @AfterThrowing(pointcut = "execution(* com.candela.bookingpad.activityops.service.*.*(..))) || execution(* com.candela.bookingpad.activityops.custom.*.*(..)))", throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        if (!(throwable instanceof Exception)) {
            logNotificationMail(stackTrace, Thread.currentThread().getName(), joinPoint.getTarget().toString(), joinPoint.getSignature().getName());
        }
        if (throwable instanceof Error) {
            logNotificationMail(stackTrace, Thread.currentThread().getName(), joinPoint.getTarget().toString(), joinPoint.getSignature().getName());
        }
    }

    void logNotificationMail(String stackTrace, String threadName, String targetObject, String targetMethod) {
        LOGGER.info("time", new Date().toString());
        LOGGER.info("threadName", threadName);
        LOGGER.info("error", stackTrace);
        LOGGER.info("targetObject", targetObject);
        LOGGER.info("targetMethod", targetMethod);
        LOGGER.error(stackTrace);
    }

}
