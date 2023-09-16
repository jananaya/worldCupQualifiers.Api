package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Player {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Team team;

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
