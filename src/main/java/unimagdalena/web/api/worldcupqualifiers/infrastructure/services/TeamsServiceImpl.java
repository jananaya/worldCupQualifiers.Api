package unimagdalena.web.api.worldcupqualifiers.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.CreateTeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.UpdateTeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers.TeamsMapper;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Person;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Team;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories.PersonsRepository;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories.TeamsRepository;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService {
    private final TeamsRepository teamsRepository;
    private final PersonsRepository personsRepository;
    private final TeamsMapper teamsMapper;

    public TeamsServiceImpl(TeamsRepository teamsRepository, PersonsRepository personsRepository, TeamsMapper teamsMapper) {
        this.teamsRepository = teamsRepository;
        this.personsRepository = personsRepository;
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

    @Override
    public TeamDto createTeam(CreateTeamDto dto) {
        Team team = new Team();
        Optional<Person> managerOptional = personsRepository.findById(dto.getManagerId());

        team.setName(dto.getName());
        team.setFlagUrl(dto.getFlagUrl());
        team.setManager(managerOptional.get());

        return teamsMapper.teamToTeamDto(teamsRepository.save(team));
    }

    @Override
    public TeamDto updateTeam(Long id, UpdateTeamDto dto) {
        Team existingTeam = teamsRepository.findById(id).orElse(null);
        Optional<Person> managerOptional = personsRepository.findById(dto.getManagerId());

        existingTeam.setName(dto.getName());
        existingTeam.setFlagUrl(dto.getFlagUrl());
        existingTeam.setManager(managerOptional.get());

        return teamsMapper.teamToTeamDto(teamsRepository.save(existingTeam));
    }
}
