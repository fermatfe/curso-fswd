/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Edificio;
import io.swagger.model.Sala;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T19:52:47.566Z")

@Api(value = "edificios", description = "Gestionar edificios y salas", tags="Edificios")
public interface EdificiosApi {

    @ApiOperation(value = "Actualizar edificio", nickname = "actualizarEdificio", notes = "", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "ID invalido", response = Error.class),
        @ApiResponse(code = 404, message = "Edificio no encontrado", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> actualizarEdificio(@ApiParam(value = "ID del edificio a actualizar",required=true) @PathVariable("idEdificio") Integer idEdificio,@ApiParam(value = "Nuevos Datos del edificio" ,required=true )  @Valid @RequestBody Edificio edificio);


    @ApiOperation(value = "Actualizar sala", nickname = "actualizarSala", notes = "Actualiza una sala", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "Sala no encontrada", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}/salas/{idSala}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> actualizarSala(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio,@ApiParam(value = "ID de la sala a actualizar",required=true) @PathVariable("idSala") Integer idSala,@ApiParam(value = "Nuevos Datos de la sala" ,required=true )  @Valid @RequestBody Sala sala);


    @ApiOperation(value = "Agregar edificio", nickname = "agregarEdificio", notes = "Agrega un edificio al sistema", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Edificio creado"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class) })
    @RequestMapping(value = "/edificios",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> agregarEdificio(@ApiParam(value = "Datos del nuevo edificio" ,required=true )  @Valid @RequestBody Edificio body);


    @ApiOperation(value = "Agregar sala", nickname = "agregarSala", notes = "Agrega una sala al sistema", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Sala creada"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}/salas",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> agregarSala(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio,@ApiParam(value = "Datos de la nueva sala"  )  @Valid @RequestBody Sala body);


    @ApiOperation(value = "Borra un edificio", nickname = "borrarEdificio", notes = "", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Edificio borrado"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "Edificio no encontrado\"", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> borrarEdificio(@ApiParam(value = "ID del edificio a borrar",required=true) @PathVariable("idEdificio") Integer idEdificio);


    @ApiOperation(value = "Borra una sala", nickname = "borrarSala", notes = "", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sala borrada"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "Sala no encontrada", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}/salas/{idSala}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> borrarSala(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio,@ApiParam(value = "ID de la sala a borrar",required=true) @PathVariable("idSala") Integer idSala);


    @ApiOperation(value = "Busca edificio por ID", nickname = "getEdificioPorId", notes = "Devuelve un edificio por ID", response = Edificio.class, tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Edificio obtenido", response = Edificio.class),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "Edificio no encontrado", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Edificio> getEdificioPorId(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio);


    @ApiOperation(value = "Busca edificios", nickname = "getEdificios", notes = "Busqueda de edificios", response = Edificio.class, responseContainer = "List", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Edificio.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "No hay edificios con esos criterios", response = Error.class) })
    @RequestMapping(value = "/edificios",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Edificio>> getEdificios(@ApiParam(value = "Pasa una cadena opcional para buscar edificios") @Valid @RequestParam(value = "searchString", required = false) String searchString,@ApiParam(value = "Busca los edificios de una provincia\"") @Valid @RequestParam(value = "idProvincia", required = false) Integer idProvincia);


    @ApiOperation(value = "Busca sala por ID", nickname = "getSalaPorId", notes = "Devuelve una sala por ID", response = Sala.class, tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Obtenida la sala del edificio", response = Sala.class),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class),
        @ApiResponse(code = 404, message = "Sala no encontrada", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}/salas/{idSala}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Sala> getSalaPorId(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio,@ApiParam(value = "ID de la sala a recuperar",required=true) @PathVariable("idSala") Integer idSala);


    @ApiOperation(value = "Buscar salas", nickname = "getSalas", notes = "Busqueda de salas", response = Sala.class, responseContainer = "List", tags={ "Edificios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Obtenidas las salas del edificio", response = Sala.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Peticion incorrecta", response = Error.class) })
    @RequestMapping(value = "/edificios/{idEdificio}/salas",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Sala>> getSalas(@ApiParam(value = "ID del edificio a recuperar",required=true) @PathVariable("idEdificio") Integer idEdificio);

}