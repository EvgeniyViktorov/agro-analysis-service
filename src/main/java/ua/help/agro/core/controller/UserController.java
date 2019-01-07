package ua.help.agro.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.dto.Email;
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
        return new ResponseEntity<>(userService.getUserByEmail(email.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateEmail(@RequestBody Email email) {
        return new ResponseEntity<>(userService.getUserByEmail(email.getEmail()).getIsVerified(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
