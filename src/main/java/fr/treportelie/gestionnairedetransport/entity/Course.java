package fr.treportelie.gestionnairedetransport.entity;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private User client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_chauffeur", referencedColumnName = "id")
    private User chauffeur;

    @Column(name = "date_course")
    private LocalDate date_course;

    @Column(name = "temp")
    private Time temp;

    @Column(name = "distance")
    private Integer distance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(User chauffeur) {
        this.chauffeur = chauffeur;
    }

    public LocalDate getDate_course() {
        return date_course;
    }

    public void setDate_course(LocalDate date_course) {
        this.date_course = date_course;
    }

    public Time getTemp() {
        return temp;
    }

    public void setTemp(Time temp) {
        this.temp = temp;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
