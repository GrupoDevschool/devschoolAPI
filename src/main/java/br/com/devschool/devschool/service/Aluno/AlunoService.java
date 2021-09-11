package br.com.devschool.devschool.service.Aluno;


import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.dto.AlunoDTO;

import java.util.List;

public interface AlunoService {
    public List<Aluno> listarAlunos();

    public Aluno inserirAluno(AlunoDTO alunoDTO);

    public Aluno alterarAluno(Integer matricula, AlunoDTO alunoDTO);

    public void excluirAluno(Integer matricula);

}
