package ua.help.agro.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.domain.UserRole;
import ua.help.agro.core.service.UserService;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
//@EnableOAuth2Sso
public class AgroHelpCoreApplication {

    @Autowired
    private UserService userService;

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


        }
    }
}