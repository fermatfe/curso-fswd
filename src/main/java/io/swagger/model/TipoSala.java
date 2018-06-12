package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TipoSala
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class TipoSala   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("tipo")
  private String tipo = null;

  public TipoSala id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Id de Tipo de Sala
   * @return id
  **/
  @ApiModelProperty(example = "1", required = true, value = "Id de Tipo de Sala")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TipoSala tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Nombre de Tipo de Sala
   * @return tipo
  **/
  @ApiModelProperty(example = "Sala de reunion", required = true, value = "Nombre de Tipo de Sala")
  @NotNull


  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipoSala tipoSala = (TipoSala) o;
    return Objects.equals(this.id, tipoSala.id) &&
        Objects.equals(this.tipo, tipoSala.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipoSala {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

