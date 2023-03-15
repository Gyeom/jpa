package spring.data.jpa.user.model;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String value;

    protected Email() {}

    public Email(String value) {
        this.value = value;

    }

    public String value() {
        return this.value;
    }
}
