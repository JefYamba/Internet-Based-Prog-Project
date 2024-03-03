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
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(length = 100)
    private String editor;

    @Column(nullable = false)
    private Double unitPrice;

    @Lob
    private byte[] image;
}
