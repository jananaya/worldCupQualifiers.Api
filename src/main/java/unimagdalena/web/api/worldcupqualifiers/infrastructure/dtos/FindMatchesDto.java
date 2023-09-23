package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.utils.constants.RegularExpression;

public class FindMatchesDto {
    @NotNull
    @NotBlank
    @Pattern(regexp = RegularExpression.VALID_DATE)
    private String fecha;

    @NotNull
    @NotBlank
    private String equipo;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String date) {
        this.fecha = date;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String teamName) {
        this.equipo = teamName;
    }
}
