package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import org.mapstruct.Mapper;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Team;

@Mapper(componentModel = "spring", uses = PersonsMapper.class)
public interface TeamsMapper {
    TeamDto teamToTeamDto(Team team);
}
