package ua.help.agro.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "field")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "forms")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer number;
    @OneToOne
    private User responsible;
    private LocalDate sowingDate;
    private String plant;
    @OneToOne
    private PlantType plantType;
    @OneToOne
    private User creator;
    private Long approximatePlantsAmount;
    private String googleMapsSrc;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Form> forms;
}
