package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Edificio;
import io.swagger.model.TipoSala;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sala
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Sala   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("descripcion")
  private String descripcion = null;

  @JsonProperty("capacidad")
  private Integer capacidad = null;

  @JsonProperty("localizacion")
  private String localizacion = null;

  @JsonProperty("tipoSala")
  private TipoSala tipoSala = null;

  @JsonProperty("edificio")
  private Edificio edificio = null;

  public Sala id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador de la Sala
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "Identificador de la Sala")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Sala nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre de la sala
   * @return nombre
  **/
  @ApiModelProperty(example = "Sala XXX", required = true, value = "Nombre de la sala")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Sala descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  **/
  @ApiModelProperty(example = "Sala de reuniones nº1", value = "")


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Sala capacidad(Integer capacidad) {
    this.capacidad = capacidad;
    return this;
  }

  /**
   * Get capacidad
   * @return capacidad
  **/
  @ApiModelProperty(example = "10", value = "")


  public Integer getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
  }

  public Sala localizacion(String localizacion) {
    this.localizacion = localizacion;
    return this;
  }

  /**
   * Localización de la sala
   * @return localizacion
  **/
  @ApiModelProperty(example = "SM-24", value = "Localización de la sala")


  public String getLocalizacion() {
    return localizacion;
  }

  public void setLocalizacion(String localizacion) {
    this.localizacion = localizacion;
  }

  public Sala tipoSala(TipoSala tipoSala) {
    this.tipoSala = tipoSala;
    return this;
  }

  /**
   * Get tipoSala
   * @return tipoSala
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TipoSala getTipoSala() {
    return tipoSala;
  }

  public void setTipoSala(TipoSala tipoSala) {
    this.tipoSala = tipoSala;
  }

  public Sala edificio(Edificio edificio) {
    this.edificio = edificio;
    return this;
  }

  /**
   * Get edificio
   * @return edificio
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Edificio getEdificio() {
    return edificio;
  }

  public void setEdificio(Edificio edificio) {
    this.edificio = edificio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sala sala = (Sala) o;
    return Objects.equals(this.id, sala.id) &&
        Objects.equals(this.nombre, sala.nombre) &&
        Objects.equals(this.descripcion, sala.descripcion) &&
        Objects.equals(this.capacidad, sala.capacidad) &&
        Objects.equals(this.localizacion, sala.localizacion) &&
        Objects.equals(this.tipoSala, sala.tipoSala) &&
        Objects.equals(this.edificio, sala.edificio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, descripcion, capacidad, localizacion, tipoSala, edificio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sala {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    capacidad: ").append(toIndentedString(capacidad)).append("\n");
    sb.append("    localizacion: ").append(toIndentedString(localizacion)).append("\n");
    sb.append("    tipoSala: ").append(toIndentedString(tipoSala)).append("\n");
    sb.append("    edificio: ").append(toIndentedString(edificio)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

