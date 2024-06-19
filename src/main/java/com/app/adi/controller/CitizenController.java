package com.app.adi.controller;

import com.app.adi.Entity.CitizenEntity;
import com.app.adi.exceptions.CitizenNotFoundException;
import com.app.adi.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    private CitizenRepo citizenRepo;

    @Autowired
    public CitizenController(CitizenRepo citizenRepo){
        this.citizenRepo = citizenRepo;
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        CitizenEntity citizenEntity = citizenRepo.findAll().stream().sorted((a,b)-> b.getVid() - a.getVid()).findFirst().get();
        System.out.println(citizenEntity);

        Map<CitizenEntity, Long> ans = citizenRepo.findAll().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        double avgVid = citizenRepo.findAll().stream().mapToInt(CitizenEntity::getVid).average().getAsDouble();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CitizenEntity> list(@PathVariable Long id) {
        Optional<CitizenEntity> citizenEntity = citizenRepo.findById(id);
        if(citizenEntity.isPresent()){
            return new ResponseEntity<>(citizenEntity.get(), HttpStatus.OK);
        }
        throw new CitizenNotFoundException("Citizen not found");
    }

    @GetMapping("/vid/{vid}")
    public ResponseEntity<List<CitizenEntity>> getByVid(@PathVariable int vid) {
        return new ResponseEntity<>(citizenRepo.findByVid(vid), HttpStatus.OK);
    }


}
