package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "momento_realización")
    private LocalDateTime timeOfRealization;

    @ManyToOne
    @JoinColumn(name = "id_estadio")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "id_arbitro_principal")
    private Person chiefReferee;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id_partido")
    private MatchTeam matchTeam;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id_partido")
    private Score score;

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimeOfRealization() {
        return timeOfRealization;
    }

    public void setTimeOfRealization(LocalDateTime timeOfRealization) {
        this.timeOfRealization = timeOfRealization;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Person getChiefReferee() {
        return chiefReferee;
    }

    public void setChiefReferee(Person chiefReferee) {
        this.chiefReferee = chiefReferee;
    }

    public Score getScore() {
        return score;
    }

    public Team getLocalTeam() {
        return matchTeam.getLocalTeam();
    }

    public Team getVisitorTeam() {
        return matchTeam.getVisitorTeam();
    }

    public MatchTeam getMatchTeam() {
        return matchTeam;
    }

    public void setMatchTeam(MatchTeam matchTeam) {
        this.matchTeam = matchTeam;
    }

}
