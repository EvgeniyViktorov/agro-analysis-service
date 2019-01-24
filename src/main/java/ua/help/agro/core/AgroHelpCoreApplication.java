package ua.help.agro.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormFieldStructure;
import ua.help.agro.core.domain.FormFieldValue;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.domain.UserRole;
import ua.help.agro.core.service.FieldService;
import ua.help.agro.core.service.FormFieldStructureService;
import ua.help.agro.core.service.FormFieldValueService;
import ua.help.agro.core.service.FormService;
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
    private FormFieldValueService formFieldValueService;
    @Autowired
    private FormFieldStructureService formFieldStructureService;
    @Autowired
    private LeafColorService leafColorService;

    public static void main(String[] args) {
        SpringApplication.run(AgroHelpCoreApplication.class, args);
    }

    @Component
    public class AddSomeData implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            User user1 = new User("Evgeniy", "Viktorov", "email@evgenitv.com");
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
                    .name("Weed").build();
            PlantType plantType2 = PlantType.builder()
                    .name("Wheat").build();
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
                    .googleMapsSrc("Some google maps src link..").build();

            Field field2 = Field.builder()
                    .number(100002)
                    .responsible(user2)
                    .sowingDate(LocalDate.now().minusMonths(60))
                    .plant("Wheat")
                    .plantType(plantType2)
                    .creator(user4)
                    .approximatePlantsAmount(200140L)
                    .googleMapsSrc("Some google maps src link.. Second one.").build();
            fieldService.save(field1);
            fieldService.save(field2);

            LeafColor leafColor1 = LeafColor.builder()
                    .value("SOME HEX VALUE").build();
            LeafColor leafColor2 = LeafColor.builder()
                    .value("1111ANOTHER HEX VALUE").build();
            leafColorService.save(leafColor1);
            leafColorService.save(leafColor2);
            FormFieldValue formFieldValue1 = FormFieldValue.builder()
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
            FormFieldValue formFieldValue2 = FormFieldValue.builder()
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
            formFieldValueService.save(formFieldValue1);
            formFieldValueService.save(formFieldValue2);
            FormFieldStructure formFieldStructure1 = FormFieldStructure.builder()
                    .fieldName("plant_type")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("1").build();
            FormFieldStructure formFieldStructure2 = FormFieldStructure.builder()
                    .fieldName("stem length")
                    .fieldNameShown("Stem length")
                    .fieldType("String")
                    .isRequired(true)
                    .value("1").build();
            FormFieldStructure formFieldStructure3 = FormFieldStructure.builder()
                    .fieldName("whatever")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("2").build();
            FormFieldStructure formFieldStructure4 = FormFieldStructure.builder()
                    .fieldName("etc")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("2").build();
            FormFieldStructure formFieldStructure5 = FormFieldStructure.builder()
                    .fieldName("noone cares for now")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("2").build();
            FormFieldStructure formFieldStructure6 = FormFieldStructure.builder()
                    .fieldName("dunno")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("2").build();
            FormFieldStructure formFieldStructure7 = FormFieldStructure.builder()
                    .fieldName("youwot")
                    .fieldNameShown("Plant Type")
                    .fieldType("String")
                    .isRequired(true)
                    .value("2").build();
            formFieldStructureService.save(formFieldStructure1);
            formFieldStructureService.save(formFieldStructure2);
            formFieldStructureService.save(formFieldStructure3);
            formFieldStructureService.save(formFieldStructure4);
            formFieldStructureService.save(formFieldStructure5);
            formFieldStructureService.save(formFieldStructure6);
            formFieldStructureService.save(formFieldStructure7);

            List<FormFieldStructure> formFieldStructures = new ArrayList<>();
            formFieldStructures.add(formFieldStructure1);
            formFieldStructures.add(formFieldStructure2);
            formFieldStructures.add(formFieldStructure3);
            formFieldStructures.add(formFieldStructure4);


            Form form1 = Form.builder()
                    .formName("Form name1")
                    .plantType(plantType1)
                    .field(field1)
                    .dueDate(LocalDate.now().plusDays(2))
                    .dateUpdated(LocalDate.now())
                    .note("This is random shitty note")
                    .isAccepted(true)
                    .isCompleted(false)
                    .formFieldStructures(formFieldStructures)
                    .submittedBy(user3)
                    .build();
            formService.save(form1);
            Form form2 = Form.builder()
                    .formName("Form name2")
                    .plantType(plantType2)
                    .field(field2)
                    .dueDate(LocalDate.now().plusDays(5))
                    .dateUpdated(LocalDate.now().minusWeeks(1))
                    .note("This is random shitty note")
                    .isAccepted(false)
                    .isCompleted(false)
                    .formFieldStructures(formFieldStructures)
                    .submittedBy(user2)
                    .build();
            formFieldStructures.clear();
            formFieldStructures.add(formFieldStructure5);
            formFieldStructures.add(formFieldStructure6);
            formFieldStructures.add(formFieldStructure7);

            formService.save(form2);
        }
    }
}