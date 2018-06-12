package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Direccion;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Edificio
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Edificio   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("direccion")
  private Direccion direccion = null;

  @JsonProperty("titularidad")
  private String titularidad = null;

  public Edificio id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador del edificio
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "Identificador del edificio")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Edificio nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del Edificio
   * @return nombre
  **/
  @ApiModelProperty(example = "E.U.M. I", required = true, value = "Nombre del Edificio")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Edificio direccion(Direccion direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Get direccion
   * @return direccion
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Edificio titularidad(String titularidad) {
    this.titularidad = titularidad;
    return this;
  }

  /**
   * Titularidad del edificio
   * @return titularidad
  **/
  @ApiModelProperty(example = "PR", value = "Titularidad del edificio")


  public String getTitularidad() {
    return titularidad;
  }

  public void setTitularidad(String titularidad) {
    this.titularidad = titularidad;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Edificio edificio = (Edificio) o;
    return Objects.equals(this.id, edificio.id) &&
        Objects.equals(this.nombre, edificio.nombre) &&
        Objects.equals(this.direccion, edificio.direccion) &&
        Objects.equals(this.titularidad, edificio.titularidad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, direccion, titularidad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Edificio {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    titularidad: ").append(toIndentedString(titularidad)).append("\n");
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

