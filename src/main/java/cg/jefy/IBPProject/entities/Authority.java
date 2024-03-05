package cg.jefy.IBPProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "authorities")
public class Authority {

    @Id
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    List<Role> roles;
}
