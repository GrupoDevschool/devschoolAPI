package br.com.devschool.devschool.service.Disciplina;

import java.util.List;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.formDto.DisciplinaFormDTO;

public interface DisciplinaService {
	
	List<Disciplina> listarDisciplinas(Integer areaId);

	Disciplina getDisciplinaById(Integer id);

	Disciplina inserirDisciplina(DisciplinaFormDTO disciplinaDTO);
	
	Disciplina alterarDisciplina(Integer id, DisciplinaFormDTO disciplinaDTO);
	
	void excluirDisciplina(Integer id);
	
}
