package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "momento_realización")
    private Date timeOfRealization;

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

    public Date getTimeOfRealization() {
        return timeOfRealization;
    }

    public void setTimeOfRealization(Date timeOfRealization) {
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
}
