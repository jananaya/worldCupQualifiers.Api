package unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces;

import java.util.List;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.CreateMatchDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.FindMatchesDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.MatchDto;
public interface MatchesService {
    List<MatchDto> findMatches(FindMatchesDto query);
    MatchDto findMatchById(Long id);
    MatchDto createMatch(CreateMatchDto createMatchDto);
}
