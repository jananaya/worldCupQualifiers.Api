package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.MatchDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Match;

@Mapper(componentModel = "spring", uses = { ScoresMapper.class, TeamsMapper.class })
public interface MatchesMapper {
    @Mapping(target = "stadium", source = "match.stadium.name")
    @Mapping(target = "chiefRefereeName", source = "chiefReferee.fullName")
    MatchDto matchToMatchDto(Match match);

    default List<MatchDto> toMatchDtos(List<Match> matches) {
        return matches.stream().map(match -> matchToMatchDto(match))
            .sorted()
            .toList();
    }
}
