package br.com.devschool.devschool.service.Turma;


import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.dto.TurmaDTO;

import java.util.List;

public interface TurmaService {
    public List<Turma> listarTurmas();

    public Turma inserirTurma(TurmaDTO turmaDTO);

    public Turma alterarTurma(Integer numero, TurmaDTO turmaDTO);

    public void excluirTurma(Integer numero);

}
