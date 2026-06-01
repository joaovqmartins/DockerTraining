package br.com.dev.DockerTraining.controller;

import br.com.dev.DockerTraining.model.Cerveja;
import br.com.dev.DockerTraining.service.CervejaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cervejas")
public class CervejaController {

    private final CervejaService service;

    public CervejaController(CervejaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cerveja>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cerveja> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cerveja> cadastrar(@RequestBody Cerveja cerveja) {
        return ResponseEntity.ok(service.cadastrar(cerveja));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveja> atualizar(
            @PathVariable Long id,
            @RequestBody Cerveja cerveja) {

        return ResponseEntity.ok(service.atualizar(id, cerveja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}