package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDto {
    private Long id;

    @JsonProperty("fecha")
    private LocalDateTime timeOfRealization;

    @JsonProperty("estadio")
    private String stadium;

    @JsonProperty("local")
    private TeamDto localTeam;

    @JsonProperty("visitante")
    private TeamDto visitorTeam;

    @JsonProperty("marcador")
    private ScoreDto score;

    @JsonProperty("arbitroPrincipal")
    private String chiefRefereeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeOfRealization() {
        return timeOfRealization;
    }

    public void setTimeOfRealization(LocalDateTime timeOfRealization) {
        this.timeOfRealization = timeOfRealization;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public TeamDto getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(TeamDto localTeam) {
        this.localTeam = localTeam;
    }

    public TeamDto getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(TeamDto visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public ScoreDto getScore() {
        return score;
    }

    public void setScore(ScoreDto score) {
        this.score = score;
    }

    public String getChiefRefereeName() {
        return chiefRefereeName;
    }

    public void setChiefRefereeName(String refereeName) {
        this.chiefRefereeName = refereeName;
    }
}
