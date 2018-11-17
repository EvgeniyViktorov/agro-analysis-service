package ua.help.agro.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "report")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
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


    public Report(PlantType plantType, Integer stemLength, Integer stemThickness, Integer branchesAmount, Integer leafLength, Integer leafWidth, String leafColor, Integer fruitsAmount, Integer fruitLength, Integer fruitWidth, Integer sweeteness, Boolean isAccepted) {
        this.plantType = plantType;
        this.stemLength = stemLength;
        this.stemThickness = stemThickness;
        this.branchesAmount = branchesAmount;
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.leafColor = leafColor;
        this.fruitsAmount = fruitsAmount;
        this.fruitLength = fruitLength;
        this.fruitWidth = fruitWidth;
        this.sweeteness = sweeteness;
        this.isAccepted = isAccepted;
    }
}
