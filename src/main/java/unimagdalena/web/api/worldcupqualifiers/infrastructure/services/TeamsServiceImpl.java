package unimagdalena.web.api.worldcupqualifiers.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers.TeamsMapper;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Team;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories.TeamsRepository;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService {

    private final TeamsRepository teamsRepository;
    private final TeamsMapper teamsMapper;

    public TeamsServiceImpl(TeamsRepository teamsRepository, TeamsMapper teamsMapper) {
        this.teamsRepository = teamsRepository;
        this.teamsMapper = teamsMapper;
    }

    @Override
    public List<TeamDto> getAll() {
        List<Team> teams = teamsRepository.findAll();

        return teams.stream()
            .map(t -> teamsMapper.teamToTeamDto(t))
            .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
            .toList();
    }
}
