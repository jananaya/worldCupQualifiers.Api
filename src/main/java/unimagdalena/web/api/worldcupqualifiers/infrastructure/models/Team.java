package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "url_bandera")
    private String flagUrl;

    @OneToOne
    @JoinColumn(name = "id_director_técnico")
    private Person manager;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    @OneToMany(mappedBy = "localTeam")
    private Set<MatchTeam> matchesAsLocal;

    @OneToMany(mappedBy = "visitorTeam")
    private Set<MatchTeam> matchesAsVisitor;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Set<MatchTeam> getMatchesAsLocal() {
        return matchesAsLocal;
    }

    public Set<MatchTeam> getMatchesAsVisitor() {
        return matchesAsVisitor;
    }
}
