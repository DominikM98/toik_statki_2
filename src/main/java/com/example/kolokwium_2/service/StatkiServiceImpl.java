package com.example.kolokwium_2.service;

import com.example.kolokwium_2.dto.PlanszaDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatkiServiceImpl implements StatkiService{

    private final int SIZE = 8;

    private PlanszaDto planszaDto;

    public StatkiServiceImpl() {
        String[] plns = {"","S","","","","S","","S"};
        String[] plns2 = {"S","","","","","S","S","S"};
        String[][] arr = {plns2, plns.clone(), plns.clone(), plns.clone(), plns.clone(), plns.clone(), plns.clone(), plns.clone()};
        planszaDto = new PlanszaDto(arr);
    }

    @Override
    public PlanszaDto getPlansza() {
        return planszaDto;
    }

    @Override
    public Optional<Boolean> shot(int y, int x) {
        if(x >= SIZE || x < 0 || y >= SIZE || y < 0 || planszaDto.getPlansza()[y][x].equals("X") || planszaDto.getPlansza()[y][x].equals("O")){
            return Optional.empty();
        }
        if(planszaDto.getPlansza()[y][x].equals("S")){
            planszaDto.getPlansza()[y][x] = "X";
            return Optional.of(true);
        }
        planszaDto.getPlansza()[y][x] = "O";
        return Optional.of(false);
    }
}
