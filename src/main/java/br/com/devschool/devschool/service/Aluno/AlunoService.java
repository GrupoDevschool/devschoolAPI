package br.com.devschool.devschool.service.Aluno;


import java.util.List;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.formDto.AlunoFormDTO;

public interface AlunoService {
    List<Aluno> listarAlunos();

    List<Aluno> listarAlunosByTurmaId(Integer turmaId);

    Aluno inserirAluno(AlunoFormDTO alunoDTO);

    Aluno alterarAluno(Integer matricula, AlunoFormDTO alunoDTO);

    void excluirAluno(Integer matricula);


    Aluno listarAlunoByMatricula(Integer matricula);
}
