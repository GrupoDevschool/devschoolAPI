package br.com.devschool.devschool.service.Gestor;

import java.util.List;
import java.util.Optional;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.dto.GestorDTO;
import br.com.devschool.devschool.repository.GestorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GestorServiceImpl implements GestorService{

    public GestorRepository gestorRepository;

    @Override
    public List<Gestor> listarGestores() {
        List<Gestor> gestores = gestorRepository.findAll();

        return gestores;
    }

    @Override
    public Gestor listarGestorById(Integer id) {

        return gestorRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Gestor com id o " + id + " nao encontrada."));
    }

    @Override
    public Gestor inserirGestor(GestorDTO gestorDTO) {
        Gestor gestor = Gestor.builder()
                .nome(gestorDTO.getNome())
                .tipo(gestorDTO.getTipo())
                .build();

        return  gestorRepository.save(gestor);
    }

    @Override
    public Gestor alterarGestor(Integer id, GestorDTO gestorDTO) {
        Gestor gestor = this.listarGestorById(id);


        gestor.setNome(gestorDTO.getNome());
        gestor.setTipo(gestorDTO.getTipo());

        return  gestorRepository.save(gestor);
    }

    @Override
    public void excluirGestor(Integer id) {
        this.listarGestorById(id);
        gestorRepository.deleteById(id);
    }
}
