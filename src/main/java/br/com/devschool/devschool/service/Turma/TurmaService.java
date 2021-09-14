package br.com.devschool.devschool.service.Turma;


import java.util.List;

import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.formDto.TurmaFormDTO;

public interface TurmaService {
    public List<Turma> listarTurmas();

    public Turma inserirTurma(TurmaFormDTO turmaDTO);

    public Turma alterarTurma(Integer id, TurmaFormDTO turmaDTO);

    public void excluirTurma(Integer id);

}
