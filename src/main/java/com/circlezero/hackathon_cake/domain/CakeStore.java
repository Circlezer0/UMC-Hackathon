package com.circlezero.hackathon_cake.domain;

import com.circlezero.hackathon_cake.domain.common.BaseEntity;
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

    @OneToMany(mappedBy = "CakeStore", cascade = CascadeType.ALL)
    private List<CakeStoreImage> cake_store_imageList = new ArrayList<>();

    @OneToMany(mappedBy = "CakeStore", cascade = CascadeType.ALL)
    private List<CakeDesignCakeStore> cake_design_cake_storeList = new ArrayList<>();

    //@OneToMany(mappedBy = "CakeStore", cascade = CascadeType.ALL)
    //private List<RecordImage> myMissionList = new ArrayList<>();
}
