package org.api.model.DTO;

import java.time.LocalDateTime;

public class ResponseEventDTO {

  private int event_id;
  private String nome;
  private String local;
  private LocalDateTime data;
  private int vagasTotais;
  private int vagasDisponiveis;


  public ResponseEventDTO(int event_id, String nome, String local, LocalDateTime data, int vagasTotais, int vagasDisponiveis) {
    this.event_id = event_id;
    this.nome = nome;
    this.local = local;
    this.data = data;
    this.vagasTotais = vagasTotais;
    this.vagasDisponiveis = vagasDisponiveis;
  }

  public int getEvent_id() {
    return event_id;
  }

  public void setEvent_id(int event_id) {
    this.event_id = event_id;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public int getVagasTotais() {
    return vagasTotais;
  }

  public void setVagasTotais(int vagasTotais) {
    this.vagasTotais = vagasTotais;
  }

  public int getVagasDisponiveis() {
    return vagasDisponiveis;
  }

  public void setVagasDisponiveis(int vagasDisponiveis) {
    this.vagasDisponiveis = vagasDisponiveis;
  }
}
