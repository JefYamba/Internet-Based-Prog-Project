package cg.jefy.IBPProject.dtos;

import lombok.*;

/**
 * @author: JefYamba
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentUserInfo {

    private String fullName;
    private String role;
}
