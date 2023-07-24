package pl.pingwit.pingwitdemospring.controller.dto;

/**
 * @author Pavel Radkevich
 * @since 24.07.23
 */
public class JokeDto {

    private String setup;
    private String punchline;

    public JokeDto(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
