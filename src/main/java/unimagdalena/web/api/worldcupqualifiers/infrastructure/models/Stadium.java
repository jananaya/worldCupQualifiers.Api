package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "estadios")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String name;

    @Column(name = "descripción", nullable = true)
    private String description;

    @OneToMany(mappedBy = "stadium")
    private Set<Match> matches;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Match> getMatches() {
        return matches;
    }
}
