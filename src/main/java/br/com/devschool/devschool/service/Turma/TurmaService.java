package br.com.devschool.devschool.service.Turma;


import java.util.List;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.formDto.TurmaFormDTO;

public interface TurmaService {
    List<Turma> listarTurmas();

    Turma listarTurmaByNome(String nome);

    Turma inserirTurma(TurmaFormDTO turmaDTO);

    Turma alterarTurma(Integer id, TurmaFormDTO turmaDTO);

    void excluirTurma(Integer id);

}
