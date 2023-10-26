/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package it.fabrick.test.autogen.external.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import it.fabrick.test.autogen.external.dto.TransferInfos;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T17:25:54.530122400+02:00[Europe/Rome]")
@Validated
@Tag(name = "account", description = "the account API")
public interface AccountApi {

    /**
     * POST /api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers : Finds accounts
     * Multiple status values can be provided with comma separated strings
     *
     * @param accountId  (required)
     * @param xTimeZone  (required)
     * @param authSchema  (required)
     * @param apikey  (required)
     * @param transferInfos  (optional)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @Operation(
        operationId = "createMoneyTransfer",
        summary = "Finds accounts",
        description = "Multiple status values can be provided with comma separated strings",
        tags = { "account" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<String> createMoneyTransfer(
        @Parameter(name = "accountId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountId") Long accountId,
        @NotNull @Parameter(name = "X-Time-Zone", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "X-Time-Zone", required = true) String xTimeZone,
        @NotNull @Parameter(name = "Auth-Schema", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "Auth-Schema", required = true) String authSchema,
        @NotNull @Parameter(name = "apikey", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "apikey", required = true) String apikey,
        @Parameter(name = "TransferInfos", description = "") @Valid @RequestBody(required = false) TransferInfos transferInfos
    );


    /**
     * GET /api/gbs/banking/v4.0/accounts/{accountId}/balance : Finds accounts
     * Multiple status values can be provided with comma separated strings
     *
     * @param accountId  (required)
     * @param xTimeZone  (required)
     * @param authSchema  (required)
     * @param apikey  (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @Operation(
        operationId = "getBalance",
        summary = "Finds accounts",
        description = "Multiple status values can be provided with comma separated strings",
        tags = { "account" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/gbs/banking/v4.0/accounts/{accountId}/balance",
        produces = { "application/json" }
    )
    ResponseEntity<String> getBalance(
        @Parameter(name = "accountId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountId") Long accountId,
        @NotNull @Parameter(name = "X-Time-Zone", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "X-Time-Zone", required = true) String xTimeZone,
        @NotNull @Parameter(name = "Auth-Schema", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "Auth-Schema", required = true) String authSchema,
        @NotNull @Parameter(name = "apikey", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "apikey", required = true) String apikey
    );


    /**
     * GET /api/gbs/banking/v4.0/accounts/{accountId}/transactions : Finds accounts
     * Multiple status values can be provided with comma separated strings
     *
     * @param accountId  (required)
     * @param fromAccountingDate  (required)
     * @param toAccountingDate  (required)
     * @param xTimeZone  (required)
     * @param authSchema  (required)
     * @param apikey  (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @Operation(
        operationId = "getTransactions",
        summary = "Finds accounts",
        description = "Multiple status values can be provided with comma separated strings",
        tags = { "account" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions",
        produces = { "application/json" }
    )
    ResponseEntity<String> getTransactions(
        @Parameter(name = "accountId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountId") Long accountId,
        @NotNull @Parameter(name = "fromAccountingDate", description = "", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "fromAccountingDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromAccountingDate,
        @NotNull @Parameter(name = "toAccountingDate", description = "", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "toAccountingDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toAccountingDate,
        @NotNull @Parameter(name = "X-Time-Zone", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "X-Time-Zone", required = true) String xTimeZone,
        @NotNull @Parameter(name = "Auth-Schema", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "Auth-Schema", required = true) String authSchema,
        @NotNull @Parameter(name = "apikey", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "apikey", required = true) String apikey
    );

}
