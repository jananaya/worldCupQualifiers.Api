package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos_del_partido")
public class MatchTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_partido")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "id_equipo_local")
    private Team localTeam;

    @ManyToOne
    @JoinColumn(name = "id_equipo_visitante")
    private Team visitorTeam;

    public Long getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(Team localTeam) {
        this.localTeam = localTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }
}
