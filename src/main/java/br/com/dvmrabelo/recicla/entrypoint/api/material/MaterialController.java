package br.com.dvmrabelo.recicla.entrypoint.api.material;

import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;
import br.com.dvmrabelo.recicla.entrypoint.exception.model.ErrorResponseDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MaterialController", description = "API responsável por operações com materiais.")
public interface MaterialController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MaterialResponse.class))),
            @ApiResponse(responseCode = "400, 403, 404", description = "Requisição inválida",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class))),
            @ApiResponse(responseCode = "500, 503", description = "Requisição indisponível",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class)))})
    @Operation(
            summary = "Serviço responsável por cadastrar o material recilável",
            description = "<u>\t<li>Para efetuar compra e venda de materiais é necessário cadastrá-lo antes.</li>\n\t</u>"
    )
    @PostMapping("v1/materials")
    ResponseEntity<MaterialResponse> createMaterial(
            @RequestBody MaterialRequest materialRequest
    );

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MaterialResponse.class))),
            @ApiResponse(responseCode = "400, 403, 404", description = "Requisição inválida",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class))),
            @ApiResponse(responseCode = "500, 503", description = "Requisição indisponível",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class)))})
    @Operation(
            summary = "Serviço responsável por retornar todos os materiais recicláveis cadastrados",
            description = "<u>\t<li>Para efetuar compra e venda de materiais é necessário cadastrá-lo antes.</li>\n\t</u>"
    )
    @GetMapping("v1/materials")
    ResponseEntity<List<MaterialResponse>> findMaterials();

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MaterialResponse.class))),
            @ApiResponse(responseCode = "400, 403, 404", description = "Requisição inválida",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class))),
            @ApiResponse(responseCode = "500, 503", description = "Requisição indisponível",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class)))})
    @Operation(
            summary = "Serviço responsável por retornar todos os materiais recicláveis cadastrados",
            description = "<u>\t<li>Para efetuar compra e venda de materiais é necessário cadastrá-lo antes.</li>\n\t</u>"
    )
    @GetMapping("v1/materials/{id}")
    ResponseEntity<MaterialResponse> findMaterialsById(
            @PathVariable Long id
    );

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MaterialResponse.class))),
            @ApiResponse(responseCode = "400, 403, 404", description = "Requisição inválida",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class))),
            @ApiResponse(responseCode = "500, 503", description = "Requisição indisponível",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class)))})
    @Operation(
            summary = "Serviço responsável por retornar todos os materiais recicláveis cadastrados",
            description = "<u>\t<li>Para efetuar compra e venda de materiais é necessário cadastrá-lo antes.</li>\n\t</u>"
    )
    @GetMapping("v1/materials/{name}")
    ResponseEntity<MaterialResponse> findMaterialsByName(
            @PathVariable String name
    );

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MaterialResponse.class))),
            @ApiResponse(responseCode = "400, 403, 404", description = "Requisição inválida",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class))),
            @ApiResponse(responseCode = "500, 503", description = "Requisição indisponível",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponseDomain.class)))})
    @Operation(
            summary = "Serviço responsável por retornar todos os materiais recicláveis cadastrados",
            description = "<u>\t<li>Para efetuar compra e venda de materiais é necessário cadastrá-lo antes.</li>\n\t</u>"
    )
    @PutMapping("v1/materials/{id}")
    ResponseEntity<MaterialResponse> updateMaterial(
            @PathVariable Long id,
            @RequestBody MaterialRequest materialRequest
    );
}
