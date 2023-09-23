package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.utils.constants.RegularExpression;

public class CreateMatchDto {
    @NotNull
    @Positive
    @JsonProperty("idEstadio")
    private Long stadiumId;

    @NotNull
    @Positive
    @JsonProperty("idArbitroPrincipal")
    private Long chiefRefereeId;

    @NotNull
    @Positive
    @JsonProperty("idEquipoLocal")
    private Long localTeamId;

    @NotNull
    @Positive
    @JsonProperty("idEquipoVisitante")
    private Long visitorTeamId;

    @NotNull
    @NotBlank
    @Pattern(regexp = RegularExpression.VALID_DATE_TIME)
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
