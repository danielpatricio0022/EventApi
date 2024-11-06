package org.api.model.DTO;
import java.time.LocalDateTime;

public class RequestEventDTO {

  private String nome;
  private String local;
  private LocalDateTime data;
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
