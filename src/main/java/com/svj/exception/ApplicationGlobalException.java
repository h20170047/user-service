package com.svj.exception;

import com.svj.dto.ErrorDTO;
import com.svj.dto.ServiceResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ServiceResponse<?> handlePaymentValidator(MethodArgumentNotValidException exception){
        ServiceResponse response= new ServiceResponse();
        List<ErrorDTO> errors= new ArrayList<>();
        for(ObjectError error: exception.getAllErrors()) {
            ConstraintViolation validationError = error.unwrap(ConstraintViolation.class);
            errors.add(new ErrorDTO((validationError.getPropertyPath()+ " : "+validationError.getMessage())));
        }
        response.setErrors(errors);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ServiceResponse<?> handlePaymentValidator(ConstraintViolationException exception){
        ServiceResponse response= new ServiceResponse();
        List<ErrorDTO> errors= new ArrayList<>();
        for(ConstraintViolation violation: exception.getConstraintViolations())
            errors.add(new ErrorDTO(violation.getPropertyPath()+": "+ violation.getMessage()));
        response.setErrors(errors);
        return response;
    }
}
