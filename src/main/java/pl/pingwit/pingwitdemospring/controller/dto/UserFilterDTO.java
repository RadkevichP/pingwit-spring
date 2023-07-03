package pl.pingwit.pingwitdemospring.controller.dto;

/**
 * @author Pavel Radkevich
 * @since 3.07.23
 */
public class UserFilterDTO {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserFilterDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
