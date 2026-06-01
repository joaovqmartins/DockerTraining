package br.com.dev.DockerTraining.service;


import br.com.dev.DockerTraining.model.Cerveja;
import br.com.dev.DockerTraining.repository.CervejaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CervejaService {

    private final CervejaRepository repository;

    public CervejaService(CervejaRepository repository) {
        this.repository = repository;
    }

    public List<Cerveja> listarTodas() {
        return repository.findAll();
    }

    public Cerveja buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cerveja não encontrada"));
    }

    public Cerveja cadastrar(Cerveja cerveja) {

        if (cerveja.getTeorAlcoolico() < 0) {
            throw new RuntimeException("Teor alcoólico inválido");
        }

        return repository.save(cerveja);
    }

    public Cerveja atualizar(Long id, Cerveja dadosAtualizados) {

        Cerveja cerveja = buscarPorId(id);

        cerveja.setNome(dadosAtualizados.getNome());
        cerveja.setMarca(dadosAtualizados.getMarca());
        cerveja.setTipo(dadosAtualizados.getTipo());
        cerveja.setTeorAlcoolico(dadosAtualizados.getTeorAlcoolico());

        return repository.save(cerveja);
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Cerveja não encontrada");
        }

        repository.deleteById(id);
    }
}