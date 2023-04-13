package com.inpowered.candidate.levy.domain;

import com.inpowered.candidate.levy.domain.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "customer", schema = "public")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active = 'true'")
public class Customer implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "firs_tname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    @Column(name = "modification_date", nullable = false)
    private ZonedDateTime modificationDate;

    @Column(name = "delete_date")
    private ZonedDateTime deleteDate;

    @Column(name = "active")
    private Boolean active;


}
