package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateTeamDto {
    @NotNull
    @NotBlank
    @JsonProperty("nombre")
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty("bandera")
    private String flagUrl;

    @NotNull
    @Positive
    @JsonProperty("idDirectorTecnico")
    private Long managerId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFlagUrl() {
        return flagUrl;
    }
    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
    public Long getManagerId() {
        return managerId;
    }
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
