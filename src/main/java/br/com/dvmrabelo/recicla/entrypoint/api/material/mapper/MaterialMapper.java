package br.com.dvmrabelo.recicla.entrypoint.api.material.mapper;

import br.com.dvmrabelo.recicla.dataprovider.material.entity.Material;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapper {

    public MaterialResponse toDTO(Material material) {
        return new MaterialResponse(
                material.getId(),
                material.getName(),
                material.getDescription(),
                material.getCategory(),
                material.getDateCreated(),
                material.getLastUpdated()
        );
    }

    public Material toEntity(MaterialRequest dto) {
        Material material = new Material();
        material.setName(dto.name());
        material.setDescription(dto.description());
        material.setCategory(dto.category());
        return material;
    }
}