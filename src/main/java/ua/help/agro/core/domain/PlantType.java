package ua.help.agro.core.domain;

import lombok.Getter;

@Getter
public enum PlantType {
    WHEAT(1),
    BUCKWHEAT(2),
    RICE(3),
    ;

    private int id;

    PlantType(int i) {
        this.id = i;
    }
}
