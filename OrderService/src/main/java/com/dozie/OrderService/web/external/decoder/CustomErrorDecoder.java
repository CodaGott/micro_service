package com.dozie.OrderService.web.external.decoder;

import com.dozie.OrderService.web.exception.CustomException;
import com.dozie.OrderService.web.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper mapper = new ObjectMapper();

        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        try {
            ErrorResponse errorResponse = mapper.readValue(response.body().asInputStream(),
                    ErrorResponse.class);

            return new CustomException(errorResponse.getMessage(), errorResponse.getErrorCode(), errorResponse.getStatus());
        } catch (IOException e) {
            throw new CustomException(e.getMessage(), "Internal Server Error", 500);
        }

    }
}
