package unimagdalena.web.api.worldcupqualifiers.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.FindMatchesDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.MatchDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers.MatchesMapper;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Match;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories.MatchesRepository;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.MatchesService;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.utils.MatchesQueryBuilder;

@Service
public class MatchesServiceImp implements MatchesService {
    private final MatchesRepository matchesRepository;
    private final MatchesMapper matchesMapper;

    public MatchesServiceImp(MatchesRepository matchesRepository, MatchesMapper matchesMapper) {
        this.matchesRepository = matchesRepository;
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

}
