package br.com.devschool.devschool.service.Grupo;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Grupo;
import br.com.devschool.devschool.model.formDto.GrupoFormDTO;
import br.com.devschool.devschool.repository.GrupoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    public GrupoRepository grupoRepository;

    @Override
    public List<Grupo> listarGrupos() {
        List<Grupo> grupos = grupoRepository.findAll();

        return grupos;
    }

    @Override
    public Grupo buscarGrupoPorId(Integer id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Não foi possivel encontrar a grupo com id " + id));
    }


    @Override
    public Grupo inserirGrupo(GrupoFormDTO grupoDTO) {
        Grupo grupo = Grupo.builder()
                .nome(grupoDTO.getNome())
                .build();

        return  grupoRepository.save(grupo);
    }

    @Override
    public Grupo alterarGrupo(Integer id, GrupoFormDTO grupoDTO) {
        Grupo grupo = this.buscarGrupoPorId(id);

        grupo.setNome(grupoDTO.getNome());

        return grupoRepository.save(grupo);
    }

    @Override
    public void excluirGrupo(Integer id) {
    	this.buscarGrupoPorId(id);
        grupoRepository.deleteById(id);
    }

    @Override
    public Grupo listarGrupoById(Integer grupoId) {
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ContentNotFoundException("Grupo com id " + grupoId + " não encontrado"));
    }

}
