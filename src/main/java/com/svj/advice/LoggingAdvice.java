package com.svj.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

//    public Jackson2ObjectMapperBuilder jacksonBuilder= new Jackson2ObjectMapperBuilder();
//    public ObjectMapper mapper= jacksonBuilder.build();

    private ObjectMapper objectMapper;
    public LoggingAdvice(ObjectMapper objectMapper){
        this.objectMapper= objectMapper;
    }

    @Around(value= "execution( * com.svj..*.*.*(..)) && !execution(* com.svj..*.*.*(..)) && @target(com.svj.annotations.ExcludeAop)")// !@target(com.svj.annotations.ExcludeAop)") // all public methods, of com.svj package, every subpackage, every class, and every method irrespective of the argument type
    public Object captureRequestAndResponse(ProceedingJoinPoint pjp) throws Throwable {

        // logic before logic
        log.info( "Request: "+pjp.getTarget()+ " : " + pjp.getSignature().getName() + " : Request Body- " + objectMapper.writeValueAsString(pjp.getArgs()));

        Object response = pjp.proceed();

        // after logic
        log.info( "Response: "+pjp.getTarget()+ " : " + pjp.getSignature().getName() + " : Response Body- " + objectMapper.writeValueAsString(response));
        return response;
    }
}
