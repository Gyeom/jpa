package spring.data.jpa.user.model.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String value;

    protected Email() {
    }

    public Email(String value) {
        this.value = value;
    }

    public void change(final String email) {
        this.value = email;
    }

    public String value() {
        return this.value;
    }
}
