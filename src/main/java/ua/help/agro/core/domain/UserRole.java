package ua.help.agro.core.domain;

import lombok.Getter;

@Getter
public enum UserRole {
    USER(1),
    SUPERVISOR(2),
    ADMINISTRATOR(3);

    private int id;

    UserRole(int i) {
        this.id = i;
    }

}
