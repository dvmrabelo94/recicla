package br.com.dvmrabelo.recicla.entrypoint.api.material.dto;

public record MaterialRequest(
        String name,
        String description,
        String category
) {
}
