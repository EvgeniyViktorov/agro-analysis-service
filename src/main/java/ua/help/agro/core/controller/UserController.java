package ua.help.agro.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.dto.Email;
import ua.help.agro.core.dto.ResponseMessage;
import ua.help.agro.core.dto.UserDto;
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
    public ResponseEntity<?> getUserWithEmail(@RequestBody Email email) {
        User userByEmail = userService.getUserByEmail(email.getEmail());
        if (userByEmail != null) {
            if (!userByEmail.getIsVerified()) {
                return new ResponseEntity<>(new ResponseMessage("User with email " + email.getEmail() + " is not verified. Please contact administrator."), HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(userByEmail, HttpStatus.OK);
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
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        User userById = userService.getUserById(userDto.getId());
        userService.save(UserDto.convertToUser(userDto, userById));
        userById = userService.getUserById(userDto.getId());
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

}
