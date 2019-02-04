package ua.help.agro.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.domain.UserRole;
import ua.help.agro.core.service.FieldService;
import ua.help.agro.core.service.FormService;
import ua.help.agro.core.service.FormStructureService;
import ua.help.agro.core.service.FormValueService;
import ua.help.agro.core.service.LeafColorService;
import ua.help.agro.core.service.PlantTypeService;
import ua.help.agro.core.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
//@EnableOAuth2Sso
public class AgroHelpCoreApplication {

    @Autowired
    private UserService userService;
    @Autowired
    private FormService formService;
    @Autowired
    private PlantTypeService plantTypeService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private FormValueService formValueService;
    @Autowired
    private FormStructureService formStructureService;
    @Autowired
    private LeafColorService leafColorService;

    public static void main(String[] args) {
        SpringApplication.run(AgroHelpCoreApplication.class, args);
    }

    @Component
    public class AddSomeData implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            User user1 = new User("Evgeniy", "Viktorov", "eugeniy.viktorov@gmail.com");
            user1.getUserRoles().add(UserRole.ADMINISTRATOR);
            User user2 = new User("Some", "OtherGuys", "lmaolol@evgenitv.com");
            user2.getUserRoles().add(UserRole.SUPERVISOR);
            user2.setIsVerified(true);
            User user3 = new User("Marina", "ADIN", "mariina.sou@gmail.com");
            user3.getUserRoles().add(UserRole.USER);
            user3.setIsVerified(true);
            User user4 = new User("Marina", "DVA", "forrte@gmail.com");
            user4.getUserRoles().add(UserRole.ADMINISTRATOR);
            userService.save(user1);
            userService.save(user2);
            userService.save(user3);
            userService.save(user4);
            PlantType plantType1 = PlantType.builder()
                    .value("Weed").build();
            PlantType plantType2 = PlantType.builder()
                    .value("Wheat").build();
            plantTypeService.save(plantType1);
            plantTypeService.save(plantType2);
            Field field1 = Field.builder()
                    .number(100001)
                    .responsible(user1)
                    .sowingDate(LocalDate.now().minusMonths(15))
                    .plant("Weed")
                    .plantType(plantType1)
                    .creator(user1)
                    .approximatePlantsAmount(20000L)
                    .googleMapsSrc("https://www.google.com/maps/d/u/0/embed?mid=1i8YYFhUJYKf3zNqOhBlHr1iuCyM4wgPd").build();

            Field field2 = Field.builder()
                    .number(100002)
                    .responsible(user2)
                    .sowingDate(LocalDate.now().minusMonths(60))
                    .plant("Wheat")
                    .plantType(plantType2)
                    .creator(user4)
                    .approximatePlantsAmount(200140L)
                    .googleMapsSrc("https://www.google.com/maps/d/u/0/embed?mid=1i8YYFhUJYKf3zNqOhBlHr1iuCyM4wgPd").build();
            fieldService.save(field1);
            fieldService.save(field2);
            LeafColor leafColor1 = LeafColor.builder()
                    .value("#000000").build();
            LeafColor leafColor2 = LeafColor.builder()
                    .value("#ff0000").build();
            LeafColor leafColor3 = LeafColor.builder()
                    .value("#00ff00").build();
            leafColorService.save(leafColor1);
            leafColorService.save(leafColor2);
            leafColorService.save(leafColor3);
            FormValue formValue1 = FormValue.builder()
                    .plantType(plantType1)
                    .stemLength("1")
                    .stemThickness("1")
                    .branchesAmount(1)
                    .leafLength("1")
                    .leafWidth("1")
                    .leafColor(leafColor1)
                    .fruitsAmount(1)
                    .fruitLength("1")
                    .sweetness(1)
                    .note("11Note for form field value 1").build();
            FormValue formValue2 = FormValue.builder()
                    .plantType(plantType1)
                    .stemLength("2")
                    .stemThickness("2")
                    .branchesAmount(2)
                    .leafLength("2")
                    .leafWidth("2")
                    .leafColor(leafColor2)
                    .fruitsAmount(2)
                    .fruitLength("2")
                    .sweetness(2)
                    .note("22Note for form field value 2").build();
            formValueService.save(formValue1);
            formValueService.save(formValue2);
            FormStructure formStructure1 = FormStructure.builder()
                    .fieldName("plantType")
                    .fieldNameShown("Вид растения")
                    .fieldType("select")
                    .isRequired(true)
                    .value("" + plantType1.getId()).build();
            FormStructure formStructure2 = FormStructure.builder()
                    .fieldName("stemLength")
                    .fieldNameShown("Длина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure3 = FormStructure.builder()
                    .fieldName("stemThickness")
                    .fieldNameShown("Толщина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure4 = FormStructure.builder()
                    .fieldName("branchesAmount")
                    .fieldNameShown("Количество веток")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure5 = FormStructure.builder()
                    .fieldName("leafLength")
                    .fieldNameShown("Длина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure6 = FormStructure.builder()
                    .fieldName("leafWidth")
                    .fieldNameShown("Ширина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure7 = FormStructure.builder()
                    .fieldName("leafColor")
                    .fieldNameShown("Цвет листа")
                    .fieldType("colorInput")
                    .isRequired(true)
                    .value("" + leafColor1.getId()).build();
            FormStructure formStructure8 = FormStructure.builder()
                    .fieldName("fruitsAmount")
                    .fieldNameShown("Количество плодов")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure9 = FormStructure.builder()
                    .fieldName("fruitLength")
                    .fieldNameShown("Длина плода")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            FormStructure formStructure10 = FormStructure.builder()
                    .fieldName("sweetness")
                    .fieldNameShown("Оценка по уровню сладости")
                    .fieldType("rangeInput")
                    .isRequired(false)
                    .value("1").build();
            FormStructure formStructure11 = FormStructure.builder()
                    .fieldName("note")
                    .fieldNameShown("Комментарии")
                    .fieldType("textarea")
                    .isRequired(false)
                    .value("Lorem ipsum – псевдо-латинский текст, который используется для веб дизайна, типографии, оборудования, и распечатки вместо английского текста для того, чтобы сделать ударение не на содержание, а на элементы дизайна.").build();
            formStructureService.save(formStructure1);
            formStructureService.save(formStructure2);
            formStructureService.save(formStructure3);
            formStructureService.save(formStructure4);
            formStructureService.save(formStructure5);
            formStructureService.save(formStructure6);
            formStructureService.save(formStructure7);
            formStructureService.save(formStructure8);
            formStructureService.save(formStructure9);
            formStructureService.save(formStructure10);
            formStructureService.save(formStructure11);

            List<FormStructure> formStructures = new ArrayList<>();
            formStructures.add(formStructure1);
            formStructures.add(formStructure2);
            formStructures.add(formStructure3);
            formStructures.add(formStructure4);
            formStructures.add(formStructure5);
            formStructures.add(formStructure6);
            formStructures.add(formStructure7);
            formStructures.add(formStructure8);
            formStructures.add(formStructure9);
            formStructures.add(formStructure10);
            formStructures.add(formStructure11);

            Form form1 = Form.builder()
                    .formName("Название формы")
                    .field(field1)
                    .dueDate(LocalDate.now().plusDays(2))
                    .dateUpdated(LocalDate.now())
                    .isAccepted(true)
                    .isCompleted(false)
                    .formValues(formValue1)
                    .formStructures(formStructures)
                    .submittedBy(user3)
                    .build();
            formService.save(form1);
            Form form2 = Form.builder()
                    .formName("Form name2")
                    .field(field2)
                    .dueDate(LocalDate.now().plusDays(5))
                    .dateUpdated(LocalDate.now().minusWeeks(1))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(formValue2)
                    .formStructures(formStructures)
                    .submittedBy(user2)
                    .build();
            formStructures.clear();
            formService.save(form2);
            Form form3 = Form.builder()
                    .formName("Form three")
                    .field(field1)
                    .dueDate(LocalDate.now().plusDays(6))
                    .dateUpdated(LocalDate.now().plusWeeks(1))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(null)
                    .formStructures(null)
                    .submittedBy(user1)
                    .build();
            formService.save(form3);
        }
    }
}