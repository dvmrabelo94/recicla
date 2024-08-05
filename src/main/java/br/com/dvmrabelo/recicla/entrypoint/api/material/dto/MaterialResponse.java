package br.com.dvmrabelo.recicla.entrypoint.api.material.dto;

import java.time.LocalDateTime;

public record MaterialResponse(
        Long id,
        String name,
        String description,
        String category,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated
) {
}
