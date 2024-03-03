package cg.jefy.IBPProject.entities;

import cg.jefy.IBPProject.security.entities.Account;
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
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstname;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    private String department;

    @Lob
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
