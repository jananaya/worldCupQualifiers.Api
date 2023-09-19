package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamDto {
    private Long id;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("bandera")
    private String flagUrl;

    @JsonProperty("directorTecnico")
    private PersonDto manager;

    @JsonProperty("jugadores")
    private List<PersonDto> players;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public PersonDto getManager() {
        return manager;
    }
    public void setManager(PersonDto manager) {
        this.manager = manager;
    }
    public List<PersonDto> getPlayers() {
        return players;
    }
    public void setPlayers(List<PersonDto> players) {
        this.players = players;
    }
}
