package org.api.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id", nullable = false)
  private int id;

  @Column(name = "name", nullable = false)
  @Size(min = 5, max = 100)
  @NotNull
  private String name;

  @Column(name = "local", nullable = false)
  @NotNull
  @Size(min = 5, max = 100)
  private String local;

  @Column(name = "date")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime date;

  @Column(name = "spaceTotal", nullable = false)
  private int vagastotais;

  @Column(name = "spaceAvailable", nullable = false)
  private int vagasDisponiveis;

  @Column
  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Participant> participants; // fk


}
