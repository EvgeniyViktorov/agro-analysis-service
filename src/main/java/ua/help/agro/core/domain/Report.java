package ua.help.agro.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    private PlantType plantType;

    private Integer stemLength;

    private Integer stemThickness;

    private Integer branchesAmount;

    private Integer leafLength;

    private Integer leafWidth;

    private String leafColor;

    private Integer fruitsAmount;

    private Integer fruitLength;

    private Integer fruitWidth;

    private Integer sweeteness;

    private Boolean isAccepted;
}
