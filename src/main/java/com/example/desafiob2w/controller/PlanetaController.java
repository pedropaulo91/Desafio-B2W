package com.example.desafiob2w.controller;
import com.example.desafiob2w.model.Planeta;
import com.example.desafiob2w.model.Resposta;
import com.example.desafiob2w.repository.PlanetaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;
    private final String ID_INVALIDO = "O id informado é inválido";
    private final String PLANETA_ADICIONADO = "Planeta adicionado";
    private final String PLANETA_NAO_ENCONTRADO = "Planeta não encontrado";
    private final String PLANETA_REMOVIDO = "Planeta removido";

    //Adiciona um planeta
    @PostMapping()
    public ResponseEntity salvarPlaneta(@Valid @RequestBody Planeta planeta){
        repository.save(planeta);
        return new ResponseEntity(new Resposta(PLANETA_ADICIONADO), HttpStatus.CREATED);
    }

    //Lista os planetas
    @GetMapping()
    public List<Planeta> obterPlanetas(){
        return repository.findAll();
    }


    //Busca por id
    @GetMapping("/{id}")
    public ResponseEntity obterPlanetaPeloId(@PathVariable String id){

        if(validarId(id) != null){
            return validarId(id);
        }

        Optional<Planeta> planetaOpt = repository.findById(new ObjectId(id));
        if(planetaExiste(id) != null){
            return planetaExiste(id);
        }

        Planeta planeta = planetaOpt.get();
        return new ResponseEntity(planeta, HttpStatus.OK);

    }


    //Busca por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity obterPlanetaPeloNome(@PathVariable String nome){

        Optional planetaOpt = repository.findByNomeIgnoreCase(nome);

        if(planetaExiste(planetaOpt) != null){
            return planetaExiste(planetaOpt);
        }

        Planeta planeta = (Planeta) planetaOpt.get();
        return new ResponseEntity(planeta, HttpStatus.OK);
    }

    //Remover
    @DeleteMapping("/{id}")
    public ResponseEntity removerPlaneta(@PathVariable String id){

        if(validarId(id) != null){
            return validarId(id);
        }

        if(planetaExiste(id) != null){
            return planetaExiste(id);
        }

        repository.deleteById(new ObjectId(id));
        return new ResponseEntity(new Resposta(PLANETA_REMOVIDO), HttpStatus.OK);

    }


    private ResponseEntity validarId(String id){
        if(!ObjectId.isValid(id)){
            return new ResponseEntity(new Resposta(ID_INVALIDO), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private ResponseEntity planetaExiste(Optional planetaOpt){
        if(!planetaOpt.isPresent()){
            return new ResponseEntity(new Resposta(PLANETA_NAO_ENCONTRADO), HttpStatus.NOT_FOUND);
        }
        return null;
    }

    private ResponseEntity planetaExiste(String id){
        Optional<Planeta> planetaOpt = repository.findById(new ObjectId(id));
        if(!planetaOpt.isPresent()){
            return new ResponseEntity(new Resposta(PLANETA_NAO_ENCONTRADO), HttpStatus.NOT_FOUND);
        }
        return null;
    }



}
