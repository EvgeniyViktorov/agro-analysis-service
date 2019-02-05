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
            user4.setIsVerified(true);
            User user5 = new User("Marina", "TRI", "arrrwork@gmail.com");
            user3.getUserRoles().add(UserRole.SUPERVISOR);
            user3.setIsVerified(true);
            userService.save(user1);
            userService.save(user2);
            userService.save(user3);
            userService.save(user4);
            userService.save(user5);
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
                    .value("10").build();
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
                    .value("5").build();
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
                    .value("Комментар до першого обстеження рослин поля").build();
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
            List<FormStructure> formStructures1 = new ArrayList<>();
             formStructures1.add(formStructure1);
             formStructures1.add(formStructure2);
             formStructures1.add(formStructure3);
             formStructures1.add(formStructure4);
             formStructures1.add(formStructure5);
             formStructures1.add(formStructure6);
             formStructures1.add(formStructure7);
             formStructures1.add(formStructure8);
             formStructures1.add(formStructure9);
             formStructures1.add(formStructure10);
             formStructures1.add(formStructure11);
            Form form1 = Form.builder()
                    .formName("Название формы 1")
                    .field(field1)
                    .dueDate(LocalDate.of(2018, 12, 1))
                    .dateUpdated(LocalDate.of(2018, 12, 1))
                    .isAccepted(true)
                    .isCompleted(false)
                    .formValues(formValue1)
                    .formStructures(formStructures1)
                    .submittedBy(user2)
                    .build();
            formService.save(form1);

            formStructure1 = FormStructure.builder()
                    .fieldName("plantType")
                    .fieldNameShown("Вид растения")
                    .fieldType("select")
                    .isRequired(true)
                    .value("" + plantType1.getId()).build();
            formStructure2 = FormStructure.builder()
                    .fieldName("stemLength")
                    .fieldNameShown("Длина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("15").build();
            formStructure3 = FormStructure.builder()
                    .fieldName("stemThickness")
                    .fieldNameShown("Толщина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            formStructure4 = FormStructure.builder()
                    .fieldName("branchesAmount")
                    .fieldNameShown("Количество веток")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("2").build();
             formStructure5 = FormStructure.builder()
                    .fieldName("leafLength")
                    .fieldNameShown("Длина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
             formStructure6 = FormStructure.builder()
                    .fieldName("leafWidth")
                    .fieldNameShown("Ширина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
             formStructure7 = FormStructure.builder()
                    .fieldName("leafColor")
                    .fieldNameShown("Цвет листа")
                    .fieldType("colorInput")
                    .isRequired(true)
                    .value("" + leafColor1.getId()).build();
             formStructure8 = FormStructure.builder()
                    .fieldName("fruitsAmount")
                    .fieldNameShown("Количество плодов")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("5").build();
             formStructure9 = FormStructure.builder()
                    .fieldName("fruitLength")
                    .fieldNameShown("Длина плода")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("3").build();
             formStructure10 = FormStructure.builder()
                    .fieldName("sweetness")
                    .fieldNameShown("Оценка по уровню сладости")
                    .fieldType("rangeInput")
                    .isRequired(false)
                    .value("1").build();
             formStructure11 = FormStructure.builder()
                    .fieldName("note")
                    .fieldNameShown("Комментарии")
                    .fieldType("textarea")
                    .isRequired(false)
                    .value("Комментар до другого обстеження рослин поля").build();
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
            List<FormStructure> formStructures2 = new ArrayList<>();
            formStructures2.add(formStructure1);
            formStructures2.add(formStructure2);
            formStructures2.add(formStructure3);
            formStructures2.add(formStructure4);
            formStructures2.add(formStructure5);
            formStructures2.add(formStructure6);
            formStructures2.add(formStructure7);
            formStructures2.add(formStructure8);
            formStructures2.add(formStructure9);
            formStructures2.add(formStructure10);
            formStructures2.add(formStructure11);
            Form form2 = Form.builder()
                    .formName("Название формы 2")
                    .field(field1)
                    .dueDate(LocalDate.of(2018, 12, 1).plusWeeks(1))
                    .dateUpdated(LocalDate.of(2018, 12, 1).plusWeeks(1))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(formValue2)
                    .formStructures(formStructures2)
                    .submittedBy(user2)
                    .build();
            formService.save(form2);

            formStructure1 = FormStructure.builder()
                    .fieldName("plantType")
                    .fieldNameShown("Вид растения")
                    .fieldType("select")
                    .isRequired(true)
                    .value("" + plantType1.getId()).build();
            formStructure2 = FormStructure.builder()
                    .fieldName("stemLength")
                    .fieldNameShown("Длина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("20").build();
            formStructure3 = FormStructure.builder()
                    .fieldName("stemThickness")
                    .fieldNameShown("Толщина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("2").build();
            formStructure4 = FormStructure.builder()
                    .fieldName("branchesAmount")
                    .fieldNameShown("Количество веток")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("6").build();
            formStructure5 = FormStructure.builder()
                    .fieldName("leafLength")
                    .fieldNameShown("Длина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("3").build();
            formStructure6 = FormStructure.builder()
                    .fieldName("leafWidth")
                    .fieldNameShown("Ширина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("1").build();
            formStructure7 = FormStructure.builder()
                    .fieldName("leafColor")
                    .fieldNameShown("Цвет листа")
                    .fieldType("colorInput")
                    .isRequired(true)
                    .value("" + leafColor1.getId()).build();
            formStructure8 = FormStructure.builder()
                    .fieldName("fruitsAmount")
                    .fieldNameShown("Количество плодов")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("5").build();
            formStructure9 = FormStructure.builder()
                    .fieldName("fruitLength")
                    .fieldNameShown("Длина плода")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("4").build();
            formStructure10 = FormStructure.builder()
                    .fieldName("sweetness")
                    .fieldNameShown("Оценка по уровню сладости")
                    .fieldType("rangeInput")
                    .isRequired(false)
                    .value("1").build();
            formStructure11 = FormStructure.builder()
                    .fieldName("note")
                    .fieldNameShown("Комментарии")
                    .fieldType("textarea")
                    .isRequired(false)
                    .value("Комментар до третього обстеження рослин поля").build();
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
            List<FormStructure> formStructures3 = new ArrayList<>();
            formStructures3.add(formStructure1);
            formStructures3.add(formStructure2);
            formStructures3.add(formStructure3);
            formStructures3.add(formStructure4);
            formStructures3.add(formStructure5);
            formStructures3.add(formStructure6);
            formStructures3.add(formStructure7);
            formStructures3.add(formStructure8);
            formStructures3.add(formStructure9);
            formStructures3.add(formStructure10);
            formStructures3.add(formStructure11);
            Form form3 = Form.builder()
                    .formName("Название формы 3")
                    .field(field1)
                    .dueDate(LocalDate.of(2018, 12, 1).plusWeeks(2))
                    .dateUpdated(LocalDate.of(2018, 12, 1).plusWeeks(2))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(formValue2)
                    .formStructures(formStructures3)
                    .submittedBy(user2)
                    .build();
            formService.save(form3);

            formStructure1 = FormStructure.builder()
                    .fieldName("plantType")
                    .fieldNameShown("Вид растения")
                    .fieldType("select")
                    .isRequired(true)
                    .value("" + plantType1.getId()).build();
            formStructure2 = FormStructure.builder()
                    .fieldName("stemLength")
                    .fieldNameShown("Длина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("25").build();
            formStructure3 = FormStructure.builder()
                    .fieldName("stemThickness")
                    .fieldNameShown("Толщина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("2").build();
            formStructure4 = FormStructure.builder()
                    .fieldName("branchesAmount")
                    .fieldNameShown("Количество веток")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("7").build();
            formStructure5 = FormStructure.builder()
                    .fieldName("leafLength")
                    .fieldNameShown("Длина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("4").build();
            formStructure6 = FormStructure.builder()
                    .fieldName("leafWidth")
                    .fieldNameShown("Ширина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("2").build();
            formStructure7 = FormStructure.builder()
                    .fieldName("leafColor")
                    .fieldNameShown("Цвет листа")
                    .fieldType("colorInput")
                    .isRequired(true)
                    .value("" + leafColor1.getId()).build();
            formStructure8 = FormStructure.builder()
                    .fieldName("fruitsAmount")
                    .fieldNameShown("Количество плодов")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("5").build();
            formStructure9 = FormStructure.builder()
                    .fieldName("fruitLength")
                    .fieldNameShown("Длина плода")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("5").build();
            formStructure10 = FormStructure.builder()
                    .fieldName("sweetness")
                    .fieldNameShown("Оценка по уровню сладости")
                    .fieldType("rangeInput")
                    .isRequired(false)
                    .value("2").build();
            formStructure11 = FormStructure.builder()
                    .fieldName("note")
                    .fieldNameShown("Комментарии")
                    .fieldType("textarea")
                    .isRequired(false)
                    .value("Комментар до четвертого обстеження рослин поля").build();
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
            List<FormStructure> formStructures4 = new ArrayList<>();
            formStructures4.add(formStructure1);
            formStructures4.add(formStructure2);
            formStructures4.add(formStructure3);
            formStructures4.add(formStructure4);
            formStructures4.add(formStructure5);
            formStructures4.add(formStructure6);
            formStructures4.add(formStructure7);
            formStructures4.add(formStructure8);
            formStructures4.add(formStructure9);
            formStructures4.add(formStructure10);
            formStructures4.add(formStructure11);
            Form form4 = Form.builder()
                    .formName("Название формы 4")
                    .field(field1)
                    .dueDate(LocalDate.of(2018, 12, 1).plusWeeks(3))
                    .dateUpdated(LocalDate.of(2018, 12, 1).plusWeeks(3))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(formValue2)
                    .formStructures(formStructures4)
                    .submittedBy(user2)
                    .build();
            formService.save(form4);

            formStructure1 = FormStructure.builder()
                    .fieldName("plantType")
                    .fieldNameShown("Вид растения")
                    .fieldType("select")
                    .isRequired(true)
                    .value("" + plantType1.getId()).build();
            formStructure2 = FormStructure.builder()
                    .fieldName("stemLength")
                    .fieldNameShown("Длина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("35").build();
            formStructure3 = FormStructure.builder()
                    .fieldName("stemThickness")
                    .fieldNameShown("Толщина стебля")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("2").build();
            formStructure4 = FormStructure.builder()
                    .fieldName("branchesAmount")
                    .fieldNameShown("Количество веток")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("7").build();
            formStructure5 = FormStructure.builder()
                    .fieldName("leafLength")
                    .fieldNameShown("Длина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("4").build();
            formStructure6 = FormStructure.builder()
                    .fieldName("leafWidth")
                    .fieldNameShown("Ширина листа")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("2").build();
            formStructure7 = FormStructure.builder()
                    .fieldName("leafColor")
                    .fieldNameShown("Цвет листа")
                    .fieldType("colorInput")
                    .isRequired(true)
                    .value("" + leafColor1.getId()).build();
            formStructure8 = FormStructure.builder()
                    .fieldName("fruitsAmount")
                    .fieldNameShown("Количество плодов")
                    .fieldType("numericInput")
                    .isRequired(true)
                    .value("5").build();
            formStructure9 = FormStructure.builder()
                    .fieldName("fruitLength")
                    .fieldNameShown("Длина плода")
                    .fieldType("textInput")
                    .isRequired(true)
                    .value("6").build();
            formStructure10 = FormStructure.builder()
                    .fieldName("sweetness")
                    .fieldNameShown("Оценка по уровню сладости")
                    .fieldType("rangeInput")
                    .isRequired(false)
                    .value("4").build();
            formStructure11 = FormStructure.builder()
                    .fieldName("note")
                    .fieldNameShown("Комментарии")
                    .fieldType("textarea")
                    .isRequired(false)
                    .value("Комментар до пятого обстеження рослин поля").build();
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
            List<FormStructure> formStructures5 = new ArrayList<>();
            formStructures5.add(formStructure1);
            formStructures5.add(formStructure2);
            formStructures5.add(formStructure3);
            formStructures5.add(formStructure4);
            formStructures5.add(formStructure5);
            formStructures5.add(formStructure6);
            formStructures5.add(formStructure7);
            formStructures5.add(formStructure8);
            formStructures5.add(formStructure9);
            formStructures5.add(formStructure10);
            formStructures5.add(formStructure11);
            Form form5 = Form.builder()
                    .formName("Название формы 5")
                    .field(field1)
                    .dueDate(LocalDate.of(2018, 12, 1).plusWeeks(4))
                    .dateUpdated(LocalDate.of(2018, 12, 1).plusWeeks(4))
                    .isAccepted(false)
                    .isCompleted(false)
                    .formValues(formValue2)
                    .formStructures(formStructures5)
                    .submittedBy(user2)
                    .build();
            formService.save(form5);
        }
    }
}