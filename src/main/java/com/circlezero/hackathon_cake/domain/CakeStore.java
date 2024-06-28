package com.circlezero.hackathon_cake.domain;

import com.circlezero.hackathon_cake.domain.common.BaseEntity;
import com.circlezero.hackathon_cake.domain.mapping.CakeStoreImage;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CakeStore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(nullable = false, length = 30)
    private String phone_number;

    @OneToMany(mappedBy = "cake_store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "cakeStore", cascade = CascadeType.ALL)
    private List<CakeStoreImage> cake_store_imageList = new ArrayList<>();
}
