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
}
