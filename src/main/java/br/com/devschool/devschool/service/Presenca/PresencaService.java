package br.com.devschool.devschool.service.Presenca;

import java.util.List;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;

public interface PresencaService {
    List<Presenca> ListarChamadas();

    Presenca listarChamadaById(Integer id);

    Presenca listarChamadaByAula(Aula aula);

    //Presenca listarChamadaByAluno(Aluno aluno);

    Presenca inserirChamadas(PresencaFormDTO chamadaDTO);

    Presenca alterarChamada(Integer id, PresencaFormDTO gestoresDTO);

    void excluirChamada(Integer id);


}
