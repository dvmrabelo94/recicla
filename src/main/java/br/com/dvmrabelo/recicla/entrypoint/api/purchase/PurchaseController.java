package br.com.dvmrabelo.recicla.entrypoint.api.purchase;

import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.material.dto.MaterialResponse;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseRequest;
import br.com.dvmrabelo.recicla.entrypoint.api.purchase.dto.PurchaseResponse;
import br.com.dvmrabelo.recicla.entrypoint.exception.model.ErrorResponseDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "PurchaseController", description = "API responsável por registrar compra de material reciclável.")
public interface PurchaseController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PurchaseResponse.class))),
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
    @PostMapping("v1/purchases")
    ResponseEntity<PurchaseResponse> effectPurchase(
            @RequestBody PurchaseRequest purchaseRequest
    );

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATE",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PurchaseResponse.class))),
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
    @GetMapping("v1/purchases")
    ResponseEntity<List<PurchaseResponse>> findAllPurchase();
}
