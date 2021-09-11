package br.com.devschool.devschool.service.Disciplina;

import java.util.List;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;

public interface DisciplinaService {
	
	public List<Disciplina> listarDisciplinas();
	
	public Disciplina inserirDisciplina(DisciplinaDTO disciplinaDTO);
	
	public Disciplina alterarDisciplina(Integer id, DisciplinaDTO disciplinaDTO);
	
	public void excluirDisciplina(Integer id);
	
}
