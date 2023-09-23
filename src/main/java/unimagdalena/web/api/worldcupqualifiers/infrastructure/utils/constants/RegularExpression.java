package unimagdalena.web.api.worldcupqualifiers.infrastructure.utils.constants;

public class RegularExpression {
    public static final String VALID_DATE_TIME = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/"
                   + "\\d{4} (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";

    public static final String VALID_DATE = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$";

    private RegularExpression() { }
}
