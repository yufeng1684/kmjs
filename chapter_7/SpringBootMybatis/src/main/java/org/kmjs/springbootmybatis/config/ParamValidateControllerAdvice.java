package org.kmjs.springbootmybatis.config;

import org.kmjs.springbootmybatis.result.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ParamValidateControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return handleFieldErrors(e.getBindingResult());
    }

    private Result<String> handleFieldErrors(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errors = new ArrayList<>();
        for(FieldError error : fieldErrors) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        Result<String> result = new Result<>();
        result.setResultCode(400);
        result.setMsg(errors.toString());
        return result;
    }


}
