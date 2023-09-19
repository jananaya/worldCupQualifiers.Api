package unimagdalena.web.api.worldcupqualifiers.infrastructure.services;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        return teamsMapper.toTeamDtos(teams);
    }

    @Override
    public List<TeamDto> findByName(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Team team = new Team();
        team.setName(name);

        Example<Team> example = Example.of(team, matcher);
        List<Team> teams = teamsRepository.findAll(example);

        return teamsMapper.toTeamDtos(teams);
    }
}
