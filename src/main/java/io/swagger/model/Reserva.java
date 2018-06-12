package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Sala;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reserva
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

public class Reserva   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("sala")
  private Sala sala = null;

  @JsonProperty("fechaReserva")
  private LocalDate fechaReserva = null;

  @JsonProperty("usuario")
  private String usuario = null;

  public Reserva id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Id de la Reserva
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "Id de la Reserva")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Reserva sala(Sala sala) {
    this.sala = sala;
    return this;
  }

  /**
   * Get sala
   * @return sala
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Sala getSala() {
    return sala;
  }

  public void setSala(Sala sala) {
    this.sala = sala;
  }

  public Reserva fechaReserva(LocalDate fechaReserva) {
    this.fechaReserva = fechaReserva;
    return this;
  }

  /**
   * Fecha de la Reserva
   * @return fechaReserva
  **/
  @ApiModelProperty(example = "", required = true, value = "Fecha de la Reserva")
  @NotNull

  @Valid

  public LocalDate getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(LocalDate fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public Reserva usuario(String usuario) {
    this.usuario = usuario;
    return this;
  }

  /**
   * Usuario que realiza la reserva
   * @return usuario
  **/
  @ApiModelProperty(example = "marmarma", required = true, value = "Usuario que realiza la reserva")
  @NotNull


  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reserva reserva = (Reserva) o;
    return Objects.equals(this.id, reserva.id) &&
        Objects.equals(this.sala, reserva.sala) &&
        Objects.equals(this.fechaReserva, reserva.fechaReserva) &&
        Objects.equals(this.usuario, reserva.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sala, fechaReserva, usuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reserva {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sala: ").append(toIndentedString(sala)).append("\n");
    sb.append("    fechaReserva: ").append(toIndentedString(fechaReserva)).append("\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
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

