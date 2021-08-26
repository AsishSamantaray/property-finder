package com.asish.propertyfinder.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String name;
    private String image;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private String email;
    private String mobileNumber;

    @Column(name = "is_mvp", columnDefinition = "boolean default false")
    private boolean isMvp;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private Set<Property> properties;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime hireDate;

    public void addProperty(Property property) {
        if (property != null) {
            if (properties == null) {
                properties = new HashSet<>();
            }
            property.setAgent(this);
            properties.add(property);
        }
    }
}
