package ua.help.agro.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "form_field")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FormField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fieldName;
    private String fieldNameShown;
    private String fieldType;
    private Boolean isRequired;
    private String value;
}
