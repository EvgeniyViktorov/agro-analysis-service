package ua.help.agro.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String formName;
    @OneToOne
    private Field field;
    private LocalDate dueDate;
    private LocalDate dateUpdated;
    private Boolean isAccepted;
    private Boolean isCompleted;
    @OneToOne
    private FormValue formValues;
    @ElementCollection(targetClass = FormStructure.class)
    private List<FormStructure> formStructures;
    @OneToOne
    private User submittedBy;
}
