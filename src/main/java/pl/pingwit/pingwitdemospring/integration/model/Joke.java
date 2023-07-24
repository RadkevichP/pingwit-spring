package pl.pingwit.pingwitdemospring.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Pavel Radkevich
 * @since 24.07.23
 */
public class Joke {

    private String setup;
    private String punchline;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
