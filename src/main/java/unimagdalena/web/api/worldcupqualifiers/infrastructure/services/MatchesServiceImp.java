package unimagdalena.web.api.worldcupqualifiers.infrastructure.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.*;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers.MatchesMapper;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.*;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories.*;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.MatchesService;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.utils.MatchesQueryBuilder;

@Service
public class MatchesServiceImp implements MatchesService {
    private final MatchesRepository matchesRepository;
    private final StadiumsRepository stadiumsRepository;
    private final PersonsRepository personsRepository;
    private final TeamsRepository teamsRepository;
    private final MatchTeamsRepository matchTeamsRepository;
    private final MatchesMapper matchesMapper;

    public MatchesServiceImp(MatchesRepository matchesRepository, StadiumsRepository stadiumsRepository,
        PersonsRepository personsRepository, TeamsRepository teamsRepository, MatchTeamsRepository matchTeamsRepository, MatchesMapper matchesMapper) {
        this.matchesRepository = matchesRepository;
        this.stadiumsRepository = stadiumsRepository;
        this.personsRepository = personsRepository;
        this.teamsRepository = teamsRepository;
        this.matchTeamsRepository = matchTeamsRepository;
        this.matchesMapper = matchesMapper;
    }

    @Override
    public List<MatchDto> findMatches(FindMatchesDto query) {

        List<Match> matches = new MatchesQueryBuilder(matchesRepository.findAll())
            .withTeam(query.getEquipo())
            .withDate(query.getFecha())
            .build();

        return matchesMapper.toMatchDtos(matches);
    }

    @Override
    public Optional<MatchDto> findMatchById(Long id) {
        Optional<Match> match = matchesRepository.findById(id);

        if (!match.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(matchesMapper.matchToMatchDto(match.get()));
    }

    @Override
    public MatchDto createMatch(CreateMatchDto createMatchDto) {
        Person referee = personsRepository.findById(createMatchDto.getChiefRefereeId()).orElse(null);
        Stadium stadium = stadiumsRepository.findById(createMatchDto.getStadiumId()).orElse(null);
        Team localTeam = teamsRepository.findById(createMatchDto.getLocalTeamId()).orElse(null);
        Team visitorTeam = teamsRepository.findById(createMatchDto.getVisitorTeamId()).orElse(null);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(createMatchDto.getTimeOfRealization(), formatter);
        Match match = new Match();
        MatchTeam matchTeam = new MatchTeam();

        match.setTimeOfRealization(localDateTime);
        match.setChiefReferee(referee);
        match.setStadium(stadium);

        Match newMatch = matchesRepository.save(match);

        matchTeam.setLocalTeam(localTeam);
        matchTeam.setVisitorTeam(visitorTeam);
        matchTeam.setMatch(newMatch);

        MatchTeam newMatchTeam = matchTeamsRepository.save(matchTeam);

        newMatchTeam.getMatch().setMatchTeam(newMatchTeam);

        return matchesMapper.matchToMatchDto(newMatchTeam.getMatch());
    }

}
