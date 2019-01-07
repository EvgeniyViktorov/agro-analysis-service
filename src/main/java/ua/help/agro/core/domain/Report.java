package ua.help.agro.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "report")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
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

    private Integer sweetness;

    private Boolean isAccepted = false;

    @OneToOne
    private User submitedBy;


    public Report(PlantType plantType, Integer stemLength, Integer stemThickness, Integer branchesAmount, Integer leafLength, Integer leafWidth, String leafColor, Integer fruitsAmount, Integer fruitLength, Integer fruitWidth, Integer sweetness, Boolean isAccepted, User submitedBy) {
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
        this.sweetness = sweetness;
        this.isAccepted = isAccepted;
        this.submitedBy = submitedBy;
    }
}
