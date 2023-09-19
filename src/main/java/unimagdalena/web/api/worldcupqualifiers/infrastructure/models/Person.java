package unimagdalena.web.api.worldcupqualifiers.infrastructure.models;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primer_nombre")
    private String firstName;

    @Column(name = "segundo_nombre")
    private String middleName;

    @Column(name = "primer_apellido")
    private String lastName;

    @Column(name = "segundo_apellido")
    private String secoundLastName;

    @Column(name = "fecha_nacimiento")
    private LocalDate dateOfBirth;

    @Column(name = "url_fotografía")
    private String photographyUrl;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecoundLastName() {
        return secoundLastName;
    }

    public void setSecoundLastName(String secoundLastName) {
        this.secoundLastName = secoundLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhotographyUrl() {
        return photographyUrl;
    }

    public void setPhotographyUrl(String photographyUrl) {
        this.photographyUrl = photographyUrl;
    }

    public String getFullName() {
        return firstName + " " + (middleName == null? "" : middleName) +
            lastName + (secoundLastName == null? "" : " " + secoundLastName);
    }

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

}
