package br.com.devschool.devschool.service.Gestores;

import br.com.devschool.devschool.model.Gestores;
import br.com.devschool.devschool.model.dto.GestoresDTO;
import br.com.devschool.devschool.repository.GestoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GestoresServiceImpl implements GestoresService{

    public GestoresRepository gestoresRepository;

    @Override
    public List<Gestores> listarGestores() {
        List<Gestores> aulas = gestoresRepository.findAll();

        return aulas;
    }

    @Override
    public Gestores inserirGestor(GestoresDTO gestoresDTO) {
        Gestores gestores = Gestores.builder()
                .nome(gestoresDTO.getNome())
                .contato(gestoresDTO.getContato())
                .build();

        return  gestoresRepository.save(gestores);
    }

    @Override
    public Gestores alterarGestor(String nome, GestoresDTO gestoresDTO) {
        Optional<Gestores> gestoresOptional = gestoresRepository.findByNome(nome);

        if (gestoresOptional.isEmpty()) {
            throw new RuntimeException("Gestor não encontrado");
        }
        Gestores gestores = gestoresOptional.get();

        gestores.setNome(gestoresDTO.getNome());
        gestores.setContato(gestoresDTO.getContato());

        return  gestoresRepository.save(gestores);
    }

    @Override
    public void excluirGestor(String nome) {
        Optional<Gestores> gestoresOptional = gestoresRepository.findByNome(nome);

        if (gestoresOptional.isEmpty()) {
            throw new RuntimeException("Gestor não existe");
        }
        gestoresRepository.deleteByName(nome);
    }
}
