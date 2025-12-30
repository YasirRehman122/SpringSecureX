package com.springsecurex.spring_securex.role.model;

import com.springsecurex.spring_securex.user.model.User;
import com.springsecurex.spring_securex.utility.model.BaseAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseAuditableEntity {

    @Column(name = "roll_name", nullable = false, length = 50, unique = true)
    private String rollName;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
