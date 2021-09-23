package br.com.devschool.devschool.service.Presenca;

import java.util.List;

import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;

public interface PresencaService {
    List<Presenca> ListarChamadas();

    Presenca listarChamadaById(Integer id);

    List<Presenca> listarChamadaByAula(Integer aulaId);

    //Presenca listarChamadaByAluno(Aluno aluno);

    Presenca inserirChamadas(PresencaFormDTO chamadaDTO);

    Presenca alterarChamada(Integer id, PresencaFormDTO gestoresDTO);

    void excluirChamada(Integer id);


  //  List<Presenca> listarChamadaByAluno(Integer aluno);
}
