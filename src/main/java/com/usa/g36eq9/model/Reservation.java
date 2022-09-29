package com.usa.g36eq9.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private LocalDateTime starDate = LocalDateTime.now();
    private LocalDateTime devolutionDate = LocalDateTime.now();

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDateTime getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDateTime starDate) {
        this.starDate = starDate;
    }

    public LocalDateTime getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDateTime devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}
