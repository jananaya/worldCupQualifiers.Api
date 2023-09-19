package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import jakarta.persistence.*;

@Entity
@Table(name = "marcadores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goles_local")
    private Integer localGoalsCount;

    @Column(name = "goles_visitante")
    private Integer visitorGoalsCount;

    @Column(name = "tarjetas_amarillas")
    private Integer yellowCardsCount;

    @Column(name = "tarjetas_rojas")
    private Integer redCardsCount;

    @OneToOne
    @JoinColumn(name = "id_partido")
    private Match match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLocalGoalsCount() {
        return localGoalsCount;
    }

    public void setLocalGoalsCount(Integer localGoalsCount) {
        this.localGoalsCount = localGoalsCount;
    }

    public Integer getVisitorGoalsCount() {
        return visitorGoalsCount;
    }

    public void setVisitorGoalsCount(Integer visitorGoalsCount) {
        this.visitorGoalsCount = visitorGoalsCount;
    }

    public Integer getYellowCardsCount() {
        return yellowCardsCount;
    }

    public void setYellowCardsCount(Integer yellowCardsCount) {
        this.yellowCardsCount = yellowCardsCount;
    }

    public Integer getRedCardsCount() {
        return redCardsCount;
    }

    public void setRedCardsCount(Integer redCardsCount) {
        this.redCardsCount = redCardsCount;
    }

    public Match getMatch() {
        return match;
    }
}
