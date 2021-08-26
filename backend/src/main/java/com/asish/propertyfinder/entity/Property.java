package com.asish.propertyfinder.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long propertyId;

    @Embedded
    private Address address;

    private BigInteger price;
    private Integer totalArea;
    private Integer bathroom;
    private Integer bedroom;

    @Column(name = "garage", columnDefinition = "integer default 0")
    private Integer garage;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_published", columnDefinition = "integer default true")
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