package cg.jefy.IBPProject.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author: JefYamba
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(length = 100)
    private String publisher;

    private Double unitPrice;
}
