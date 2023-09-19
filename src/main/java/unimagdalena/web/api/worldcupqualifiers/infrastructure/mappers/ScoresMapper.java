package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import org.mapstruct.Mapper;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.ScoreDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Score;

@Mapper(componentModel = "spring")
public interface ScoresMapper {
    ScoreDto scoreToScoreDto(Score score);
}
