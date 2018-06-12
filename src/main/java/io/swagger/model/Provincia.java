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
 * Provincia
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Provincia   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("provincia")
  private String provincia = null;

  public Provincia id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador de la provincia
   * @return id
  **/
  @ApiModelProperty(example = "40", required = true, value = "Identificador de la provincia")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Provincia provincia(String provincia) {
    this.provincia = provincia;
    return this;
  }

  /**
   * Nombre de la provincia
   * @return provincia
  **/
  @ApiModelProperty(example = "Valladolid", required = true, value = "Nombre de la provincia")
  @NotNull


  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
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
    Provincia provincia = (Provincia) o;
    return Objects.equals(this.id, provincia.id) &&
        Objects.equals(this.provincia, provincia.provincia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, provincia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Provincia {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

