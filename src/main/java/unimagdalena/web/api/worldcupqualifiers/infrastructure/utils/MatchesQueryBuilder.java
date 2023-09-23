package unimagdalena.web.api.worldcupqualifiers.infrastructure.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Match;

public class MatchesQueryBuilder {
    private Collection<Match> matchesCollection;

    public MatchesQueryBuilder(Collection<Match> matchesCollection) {
        this.matchesCollection = matchesCollection;
    }

    public MatchesQueryBuilder withTeam(String teamName) {
        if (teamName != null) {
            String lowerCaseTeamName = teamName.toLowerCase();

            matchesCollection = matchesCollection.stream()
                .filter(match -> match.getLocalTeam().getName().toLowerCase().contains(lowerCaseTeamName)
                    || match.getVisitorTeam().getName().toLowerCase().contains(lowerCaseTeamName))
                .toList();
        }
    
        return this;
    }

    public MatchesQueryBuilder withDate(String dateStr) {
        if (dateStr != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date date = Date.valueOf(LocalDate.parse(dateStr, formatter));

            matchesCollection = matchesCollection.stream()
                .filter(match -> Date.from(match.getTimeOfRealization().atZone(ZoneId.systemDefault()).toInstant()).getTime() == date.getTime())
                .toList();
        }

        return this;
    }

    public List<Match> build() {
        return List.copyOf(matchesCollection);
    }
}
