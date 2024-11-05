package eu.profinit.education.flightlog.flight;

import eu.profinit.education.flightlog.common.JpaConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {

    public static final Task TOWPLANE_TASK = new Task("VLEK");

    @Getter
    @Column(name= JpaConstants.Columns.TASK)
    private String value;

    public static Task of(String value) {
        return new Task(value);
    }

}