package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.domain.UserRole;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isVerified;

    private Boolean isNightMode;

    private List<UserRole> userRoles;

    public static User convertToUser(UserDto dto, User user) {
        if (dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }
        if (dto.getIsNightMode() != null) {
            user.setIsNightMode(dto.getIsNightMode());
        }
        return user;
    }
}
