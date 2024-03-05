package cg.jefy.IBPProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author: JefYamba
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String role;

    @OneToMany(mappedBy = "role")
    private List<AppUser> appUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_authorities",
            joinColumns = {
                    @JoinColumn(name = "role_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "authority_id")
            }
    )
    List<Authority> authorities;
}
