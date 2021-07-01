package com.example.neo4jtest.rest;

import com.example.neo4jtest.dto.DirectorDto;
import com.example.neo4jtest.entities.Director;
import com.example.neo4jtest.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }
    @GetMapping("/{name}")
    public DirectorDto findById(@PathVariable String name){
        return this.directorService.findByName(name);
    }
    @GetMapping
    public List<DirectorDto> findAll(){
        return this.directorService.findAll();
    }

}
