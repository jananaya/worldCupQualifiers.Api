package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMatchDto {
    @JsonProperty("idEstadio")
    private Long stadiumId;

    @JsonProperty("idArbitroPrincipal")
    private Long chiefRefereeId;

    @JsonProperty("idEquipoLocal")
    private Long localTeamId;

    @JsonProperty("idEquipoVisitante")
    private Long visitorTeamId;

    @JsonProperty("momentoRealizacion")
    private String timeOfRealization;

    public Long getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Long getChiefRefereeId() {
        return chiefRefereeId;
    }

    public void setChiefRefereeId(Long chiefRefereeId) {
        this.chiefRefereeId = chiefRefereeId;
    }

    public Long getLocalTeamId() {
        return localTeamId;
    }

    public void setLocalTeamId(Long localTeamId) {
        this.localTeamId = localTeamId;
    }

    public Long getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(Long visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public String getTimeOfRealization() {
        return timeOfRealization;
    }

    public void setTimeOfRealization(String timeOfRealization) {
        this.timeOfRealization = timeOfRealization;
    }
}
