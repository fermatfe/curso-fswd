package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Poblacion;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Direccion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Direccion   {
  @JsonProperty("tipoVia")
  private String tipoVia = null;

  @JsonProperty("nombreVia")
  private String nombreVia = null;

  @JsonProperty("numeroVia")
  private String numeroVia = null;

  @JsonProperty("codigoPostal")
  private String codigoPostal = null;

  @JsonProperty("poblacion")
  private Poblacion poblacion = null;

  public Direccion tipoVia(String tipoVia) {
    this.tipoVia = tipoVia;
    return this;
  }

  /**
   * Codigo de via
   * @return tipoVia
  **/
  @ApiModelProperty(example = "Calle", value = "Codigo de via")


  public String getTipoVia() {
    return tipoVia;
  }

  public void setTipoVia(String tipoVia) {
    this.tipoVia = tipoVia;
  }

  public Direccion nombreVia(String nombreVia) {
    this.nombreVia = nombreVia;
    return this;
  }

  /**
   * Nombre de via
   * @return nombreVia
  **/
  @ApiModelProperty(example = "Duque de la Victoria", required = true, value = "Nombre de via")
  @NotNull


  public String getNombreVia() {
    return nombreVia;
  }

  public void setNombreVia(String nombreVia) {
    this.nombreVia = nombreVia;
  }

  public Direccion numeroVia(String numeroVia) {
    this.numeroVia = numeroVia;
    return this;
  }

  /**
   * Numero de via
   * @return numeroVia
  **/
  @ApiModelProperty(example = "20", required = true, value = "Numero de via")
  @NotNull


  public String getNumeroVia() {
    return numeroVia;
  }

  public void setNumeroVia(String numeroVia) {
    this.numeroVia = numeroVia;
  }

  public Direccion codigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
    return this;
  }

  /**
   * Codigo postal del Edificio
   * @return codigoPostal
  **/
  @ApiModelProperty(example = "47002", required = true, value = "Codigo postal del Edificio")
  @NotNull


  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public Direccion poblacion(Poblacion poblacion) {
    this.poblacion = poblacion;
    return this;
  }

  /**
   * Get poblacion
   * @return poblacion
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Poblacion getPoblacion() {
    return poblacion;
  }

  public void setPoblacion(Poblacion poblacion) {
    this.poblacion = poblacion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Direccion direccion = (Direccion) o;
    return Objects.equals(this.tipoVia, direccion.tipoVia) &&
        Objects.equals(this.nombreVia, direccion.nombreVia) &&
        Objects.equals(this.numeroVia, direccion.numeroVia) &&
        Objects.equals(this.codigoPostal, direccion.codigoPostal) &&
        Objects.equals(this.poblacion, direccion.poblacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoVia, nombreVia, numeroVia, codigoPostal, poblacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Direccion {\n");
    
    sb.append("    tipoVia: ").append(toIndentedString(tipoVia)).append("\n");
    sb.append("    nombreVia: ").append(toIndentedString(nombreVia)).append("\n");
    sb.append("    numeroVia: ").append(toIndentedString(numeroVia)).append("\n");
    sb.append("    codigoPostal: ").append(toIndentedString(codigoPostal)).append("\n");
    sb.append("    poblacion: ").append(toIndentedString(poblacion)).append("\n");
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

