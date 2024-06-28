package com.circlezero.hackathon_cake.domain.mapping;

import com.circlezero.hackathon_cake.domain.CakeImage;
import com.circlezero.hackathon_cake.domain.CakeStore;
import com.circlezero.hackathon_cake.domain.common.BaseEntity;
import com.circlezero.hackathon_cake.domain.enums.CakeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CakeStoreImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private CakeType cake_type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_store_id")
    private CakeStore cakeStore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_image_id")
    private CakeImage cakeImage;
}
