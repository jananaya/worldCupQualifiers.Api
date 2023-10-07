package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre_de_usuario"),
        @UniqueConstraint(columnNames = "correo_electrónico")
    })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_de_usuario")
    private String username;
    @Column(name = "correo_electrónico")
    private String email;
    @Column(name = "contraseña")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_usuarios",
                joinColumns = @JoinColumn(name="id_usuario"),
                inverseJoinColumns = @JoinColumn(name="id_rol"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) { 
        this.roles = roles;
    }
}
