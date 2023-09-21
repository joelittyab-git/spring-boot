package com.example.springjpa.User;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.MatrixVariable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "first_name",
                        column = @Column(name = "profile_first_name", length = 40)
                ),
                @AttributeOverride(
                        name = "address",
                        column = @Column(name = "profile_address")
                ),
                @AttributeOverride(
                        name = "last_name",
                        column = @Column(name = "profile_last_name", length = 40)
                ),
                @AttributeOverride(
                        name = "main",
                        column = @Column()
                )
        }
)
public class Profile {

    private String gender;
    private String address;
    private String first_name;
    private String last_name;
    private Integer main;

}
