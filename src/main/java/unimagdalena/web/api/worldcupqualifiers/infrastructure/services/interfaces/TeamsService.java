package unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces;

import java.util.List;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.CreateTeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.UpdateTeamDto;

public interface TeamsService {
    List<TeamDto> getAll();
    List<TeamDto> findByName(String name);
    TeamDto createTeam(CreateTeamDto dto);
    TeamDto updateTeam(Long id, UpdateTeamDto dto);
}
