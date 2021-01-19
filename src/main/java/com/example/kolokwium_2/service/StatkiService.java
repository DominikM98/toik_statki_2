package com.example.kolokwium_2.service;

import com.example.kolokwium_2.dto.PlanszaDto;

import java.util.Optional;

public interface StatkiService {
    PlanszaDto getPlansza();
    Optional<Boolean> shot(int y, int x);
}
