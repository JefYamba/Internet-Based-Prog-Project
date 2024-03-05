package cg.jefy.IBPProject.dtos;

import cg.jefy.IBPProject.entities.Role;
import lombok.*;

/**
 * @author: JefYamba
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppUserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String department;
    private String role;
}
