package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Team;

@Mapper(componentModel = "spring", uses = PersonsMapper.class)
public interface TeamsMapper {
    default List<TeamDto> toTeamDtos(List<Team> teams) {
        return teams.stream()
            .map(t -> teamToTeamDto(t))
            .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
            .toList();
    }

    TeamDto teamToTeamDto(Team team);
}
