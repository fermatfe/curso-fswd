package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Provincia;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Poblacion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Poblacion   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("poblacion")
  private String poblacion = null;

  @JsonProperty("latitud")
  private String latitud = null;

  @JsonProperty("longitud")
  private String longitud = null;

  @JsonProperty("provincia")
  private Provincia provincia = null;

  public Poblacion id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador de la población
   * @return id
  **/
  @ApiModelProperty(example = "7467", required = true, value = "Identificador de la población")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Poblacion poblacion(String poblacion) {
    this.poblacion = poblacion;
    return this;
  }

  /**
   * Nombre de la Población
   * @return poblacion
  **/
  @ApiModelProperty(example = "Valladolid\"", required = true, value = "Nombre de la Población")
  @NotNull


  public String getPoblacion() {
    return poblacion;
  }

  public void setPoblacion(String poblacion) {
    this.poblacion = poblacion;
  }

  public Poblacion latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * Latitud de la población (geoposicionamiento)
   * @return latitud
  **/
  @ApiModelProperty(example = "41.653363", value = "Latitud de la población (geoposicionamiento)")


  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public Poblacion longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * Longitud de la población (geoposicionamiento)\"
   * @return longitud
  **/
  @ApiModelProperty(example = "-4.728874", value = "Longitud de la población (geoposicionamiento)\"")


  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public Poblacion provincia(Provincia provincia) {
    this.provincia = provincia;
    return this;
  }

  /**
   * Get provincia
   * @return provincia
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Provincia getProvincia() {
    return provincia;
  }

  public void setProvincia(Provincia provincia) {
    this.provincia = provincia;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Poblacion poblacion = (Poblacion) o;
    return Objects.equals(this.id, poblacion.id) &&
        Objects.equals(this.poblacion, poblacion.poblacion) &&
        Objects.equals(this.latitud, poblacion.latitud) &&
        Objects.equals(this.longitud, poblacion.longitud) &&
        Objects.equals(this.provincia, poblacion.provincia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, poblacion, latitud, longitud, provincia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Poblacion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    poblacion: ").append(toIndentedString(poblacion)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
    sb.append("    provincia: ").append(toIndentedString(provincia)).append("\n");
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

