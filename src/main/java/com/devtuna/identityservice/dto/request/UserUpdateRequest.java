package com.devtuna.identityservice.dto.request;

import com.devtuna.identityservice.validator.DobConstraint;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    private String password;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate dob;
    private Set<String> roles;

}
