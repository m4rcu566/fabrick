package it.fabrick.test.advice;

import feign.FeignException;
import it.fabrick.test.autogen.internal.dtos.Error;
import it.fabrick.test.autogen.internal.dtos.ModelApiResponse;
import it.fabrick.test.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.*;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class, MissingFormatArgumentException.class,
            IllegalArgumentException.class, MethodArgumentConversionNotSupportedException.class})
    public ResponseEntity<ModelApiResponse> handleInvalidRequestException(Exception ex) {

        logger.error("Error details: {}", ex.getMessage());

        StringBuilder errorMessage = new StringBuilder();
        if (ex instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            errorMessage.append("Not valid arguments: ")
                    .append(methodArgumentNotValidException.getMessage());
        } else if (ex instanceof MethodArgumentTypeMismatchException argumentTypeMismatchException) {
            errorMessage.append("Argument type mismatch: ")
                    .append(argumentTypeMismatchException.getPropertyName())
                    .append(": ")
                    .append(argumentTypeMismatchException.getValue());
        } else if(ex instanceof MissingFormatArgumentException formatArgumentException){
            errorMessage.append("Missing argument: ")
                    .append(formatArgumentException.getMessage());
        } else if(ex instanceof IllegalArgumentException illegalArgumentException){
            errorMessage.append("Illegal argument: ")
                    .append(illegalArgumentException.getMessage());
        } else if(ex instanceof MethodArgumentConversionNotSupportedException argumentConversionNotSupportedException){
            errorMessage.append("Conversion is faild: ")
                    .append(argumentConversionNotSupportedException.getPropertyName())
                    .append(": ")
                    .append(argumentConversionNotSupportedException.getValue());
        }

        List<Error> response = new ArrayList<>();
        response.add(new Error().description(errorMessage.toString()));
        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(response);

        return ResponseEntity.internalServerError().body(modelApiResponse);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ModelApiResponse> handleInvalidException(Exception ex) {

        List<Error> response = new ArrayList<>();
        response.add(new Error().description(ex.getMessage()));
        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(response);

        logger.error("Error code: {} - Error details: {}", HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());

        return ResponseEntity.internalServerError().body(modelApiResponse);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ModelApiResponse> handleInvalidException(FeignException fe) {

        String responseBody;

        if(fe.responseBody().isPresent()) {
            byte[] responseBodyBytes = fe.responseBody().get().array();
            responseBody = new String(responseBodyBytes);
        } else {
            responseBody = "Generic error";
        }

        List<Error> response = new ArrayList<>();

        try {

            response = Arrays.asList((Error[]) JsonUtils.stringToObjectArray(responseBody, Error[].class, "errors"));
        } catch (Exception e) {
            logger.warn("Error parse object response: {} ", responseBody);
        }

        int numberHttpStatus = fe.status() == -1 ? 400 : fe.status();
        ModelApiResponse modelApiResponse = new ModelApiResponse()
                .errors(response)
                .status(HttpStatus.valueOf(numberHttpStatus).toString());

        logger.error("Error code: {} - Error details: {}", numberHttpStatus, responseBody);

        return ResponseEntity.status(numberHttpStatus).body(modelApiResponse);

    }
}
