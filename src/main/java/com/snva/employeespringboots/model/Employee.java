package com.snva.employeespringboots.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "employee")
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private long id;
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String email;
}
