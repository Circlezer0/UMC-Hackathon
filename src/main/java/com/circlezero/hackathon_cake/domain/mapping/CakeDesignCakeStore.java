package com.circlezero.hackathon_cake.domain.mapping;

import com.circlezero.hackathon_cake.domain.CakeDesign;
import com.circlezero.hackathon_cake.domain.CakeImage;
import com.circlezero.hackathon_cake.domain.CakeStore;
import com.circlezero.hackathon_cake.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CakeDesignCakeStore extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_store_id")
    private CakeStore cakeStore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_design_id")
    private CakeDesign cakeDesign;
}
