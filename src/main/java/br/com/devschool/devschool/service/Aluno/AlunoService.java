package br.com.devschool.devschool.service.Aluno;


import java.util.List;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.formDto.AlunoFormDTO;

public interface AlunoService {
    public List<Aluno> listarAlunos();

    public Aluno inserirAluno(AlunoFormDTO alunoDTO);

    public Aluno alterarAluno(Integer matricula, AlunoFormDTO alunoDTO);

    public void excluirAluno(Integer matricula);

}
