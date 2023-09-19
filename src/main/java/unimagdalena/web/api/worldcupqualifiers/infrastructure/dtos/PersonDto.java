package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDto {
    private Long id;

    @JsonProperty("nombreCompleto")
    private String fullName;

    @JsonProperty("fotografia")
    private String photographyUrl;

    @JsonProperty("edad")
    private Integer age;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhotographyUrl() {
        return photographyUrl;
    }
    public void setPhotographyUrl(String photographyUrl) {
        this.photographyUrl = photographyUrl;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
