package ua.help.agro.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "form_field_value")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FormValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    private PlantType plantType;
    private String stemLength;
    private String stemThickness;
    private Integer branchesAmount;
    private String leafLength;
    private String leafWidth;
    @OneToOne
    private LeafColor leafColor;
    private Integer fruitsAmount;
    private String fruitLength;
    private Integer sweetness;
    private String note;
}
