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
import java.time.LocalDate;

@Entity(name = "form")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String formName;

    @Enumerated(EnumType.ORDINAL)
    private PlantType plantType;

    @OneToOne
    private Field field;

    private LocalDate dueDate;

    private LocalDate dateUpdated;

    private String note;

    private Boolean isCompleted;
}
