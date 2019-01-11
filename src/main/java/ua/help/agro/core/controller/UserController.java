package ua.help.agro.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.dto.Email;
import ua.help.agro.core.dto.ResponseMessage;
import ua.help.agro.core.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/users",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/find")
    public ResponseEntity<?> getUserWithEmail(@RequestBody Email email) throws JsonProcessingException {
        User userByEmail = userService.getUserByEmail(email.getEmail());
        if (userByEmail != null) {
            if (!userByEmail.getIsVerified()) {
                return new ResponseEntity<>(new ResponseMessage("User with email " + email.getEmail() + " is not verified. Please contact administrator."), HttpStatus.UNAUTHORIZED);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(userByEmail).length()));
//            return ResponseEntity.ok().header(headers).body(userByEmail);
            return new ResponseEntity<>(userByEmail, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseMessage("User with email " + email.getEmail() + " does not exist. Please, consider registration in application."), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateUserEmail(@RequestBody Email email) {
        return new ResponseEntity<>(userService.getUserByEmail(email.getEmail()).getIsVerified(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        User userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail == null) {
            return new ResponseEntity<>(new ResponseMessage("User with email " + user.getEmail() + " exists in database."), HttpStatus.OK);
        } else userService.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

}
