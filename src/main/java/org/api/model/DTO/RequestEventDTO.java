package org.api.model.DTO;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class RequestEventDTO {

  @NotBlank(message = "O nome é obrigatório e deve ter entre 5 e 100 caracteres.")
  @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres.")
  private String nome;

  @NotBlank(message = "O local é obrigatório e deve ter entre 5 e 100 caracteres.")
  @Size(min = 5, max = 100, message = "O local deve ter entre 5 e 100 caracteres.")
  private String local;

  @NotNull(message = "A data é obrigatória.")
  private LocalDateTime data;

  @Positive(message = "O número de vagas deve ser um valor positivo.")
  private int vagasTotais;



  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public int getVagasTotais() {
    return vagasTotais;
  }

  public void setVagasTotais(int vagasTotais) {
    this.vagasTotais = vagasTotais;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }
}
