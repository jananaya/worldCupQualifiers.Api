package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreDto {
    private Long id;

    @JsonProperty("golLocal")
    private Integer localGoalsCount;

    @JsonProperty("golVisitante")
    private Integer visitorGoalsCount;

    @JsonProperty("numeroTarjetasAmarillas")
    private Integer yellowCardsCount;

    @JsonProperty("numeroTarjetasRojas")
    private Integer redCardsCount;

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
}
