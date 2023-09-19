package unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos;

public class FindMatchesDto {
    private String fecha;

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
