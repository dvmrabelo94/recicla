package br.com.dvmrabelo.recicla.entrypoint.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponseDomain(
        String code,
        String timestamp,
        String message,
        String customMessage,
        Integer httpStatusCode
) {

}