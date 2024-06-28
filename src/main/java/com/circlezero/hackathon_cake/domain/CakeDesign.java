package com.circlezero.hackathon_cake.domain;

import jakarta.persistence.*;

public class CakeDesign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
