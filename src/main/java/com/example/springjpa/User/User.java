package com.example.springjpa.User;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                            "email", "user_id"
                        },
                        name = "unique_const"
                )
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long user_id;


    @Column private String email;
    @Column private Long telephone;

    @Embedded
    private Profile profile;


}
