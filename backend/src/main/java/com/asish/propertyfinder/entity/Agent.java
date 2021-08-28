package com.asish.propertyfinder.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID agentId;

    private String name;
    private String image;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private String email;
    private String mobileNumber;

    @Column(name = "is_mvp", columnDefinition = "boolean default false")
    private boolean isMvp;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
