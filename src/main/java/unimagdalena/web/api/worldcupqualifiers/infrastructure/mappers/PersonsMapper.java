package unimagdalena.web.api.worldcupqualifiers.infrastructure.mappers;

import java.time.LocalDate;
import java.time.Period;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.PersonDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Person;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Player;

@Mapper(componentModel = "spring")
public interface PersonsMapper {
    default String getFullName(Person person) {
        return person.getFirstName() + " " + person.getMiddleName() +
            person.getLastName() + " " + person.getSecoundLastName();
    }

    default Integer getAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    default PersonDto playerToPersonDto(Player player) {
        return personToPersonDto(player.getPerson());
    }

    @Mapping(target = "fullName", expression = "java(getFullName(person))")
    @Mapping(target = "age", expression = "java(getAge(person.getDateOfBirth()))")
    PersonDto personToPersonDto(Person person);
}
