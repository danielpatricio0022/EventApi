package org.api.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String email;

    @Column(name = "status", nullable = false, length = 20)
    @Size(max = 20)
    @NotNull
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event; //fk

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
