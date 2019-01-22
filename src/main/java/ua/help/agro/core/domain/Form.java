package ua.help.agro.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "form")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String formName;
    @OneToOne
    private PlantType plantType;
    @OneToOne
    private Field field;
    private LocalDate dueDate;
    private LocalDate dateUpdated;
    private String note;
    private Boolean isAccepted;
    private Boolean isCompleted;
    @OneToOne
    private FormFieldValue formFieldValues;
    @ElementCollection(targetClass = FormFieldStructure.class)
    private List<FormFieldStructure> formFieldStructures;
    @OneToOne
    private User submittedBy;
}
