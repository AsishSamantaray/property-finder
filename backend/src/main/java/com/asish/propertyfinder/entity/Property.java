package com.asish.propertyfinder.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long id;

    @Embedded
    private Address address;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private BigInteger price;
    private Integer bedroom;

    @Column(name = "garage", columnDefinition = "integer default 0")
    private Integer garage;

    private Integer bathroom;
    private Integer totalArea;

    @Column(name = "is_published", columnDefinition = "boolean default true")
    private boolean isPublished;

    private String mainImage;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime publishedDate;
}
