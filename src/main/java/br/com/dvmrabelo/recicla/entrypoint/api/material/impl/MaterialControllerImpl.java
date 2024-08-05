package br.com.dvmrabelo.recicla.entrypoint.api.material.impl;

import br.com.dvmrabelo.recicla.entrypoint.api.material.MaterialController;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.material.facade.MaterialFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/materials")
public class MaterialControllerImpl implements MaterialController {

    private final MaterialFacade materialFacade;

    public MaterialControllerImpl(MaterialFacade materialFacade) {
        this.materialFacade = materialFacade;
    }

    @Override
    @PostMapping
    public ResponseEntity<MaterialResponse> createMaterial(MaterialRequest materialRequest) {
        return ResponseEntity.ok(materialFacade.saveMaterial(materialRequest));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MaterialResponse>> findMaterials() {
        return ResponseEntity.ok(materialFacade.findAllMaterials());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MaterialResponse> findMaterialsById(Long id) {
        return ResponseEntity.ok(materialFacade.findMaterialById(id));
    }

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<MaterialResponse> findMaterialsByName(String name) {
        return ResponseEntity.ok(materialFacade.findMaterialByName(name));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponse> updateMaterial(Long id, MaterialRequest materialRequest) {
        return ResponseEntity.ok(materialFacade.updateMaterial(id, materialRequest));
    }
}
