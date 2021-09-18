package br.com.devschool.devschool.service.Disciplina;

import java.util.List;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Trilha;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;

public interface DisciplinaService {
	
	List<Disciplina> listarDisciplinas(Integer areaId);

	Disciplina getDisciplinaById(Integer id);

	Disciplina inserirDisciplina(DisciplinaDTO disciplinaDTO);
	
	Disciplina alterarDisciplina(Integer id, DisciplinaDTO disciplinaDTO);
	
	void excluirDisciplina(Integer id);
	
}
