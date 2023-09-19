package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import org.mapstruct.Mapper;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.PersonDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Person;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Player;

@Mapper(componentModel = "spring")
public interface PersonsMapper {
    default PersonDto playerToPersonDto(Player player) {
        return personToPersonDto(player.getPerson());
    }

    PersonDto personToPersonDto(Person person);
}
