package eu.profinit.education.flightlog.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long memberId;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
