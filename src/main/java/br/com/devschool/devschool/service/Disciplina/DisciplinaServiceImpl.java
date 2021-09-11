package br.com.devschool.devschool.service.Disciplina;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService{

	private DisciplinaRepository disciplinaRepository;
	
	@Override
	public List<Disciplina> listarDisciplinas() {
		List<Disciplina> disciplinas = disciplinaRepository.findAll();
		
		return disciplinas;
	}

	@Override
	public Disciplina inserirDisciplina(DisciplinaDTO disciplinaDTO) {
		Disciplina disciplina = Disciplina.builder()
				.nome(disciplinaDTO.getNome())
				.build();
		
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public Disciplina alterarDisciplina(Integer id, DisciplinaDTO disciplinaDTO) {
		Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);
		
		if (disciplinaOptional.isEmpty()) {
			throw new RuntimeException("Disciplina inexistente");
		}
		
		Disciplina disciplina = disciplinaOptional.get();
		
		disciplina.setNome(disciplinaDTO.getNome());
		
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public void excluirDisciplina(Integer id) {
		Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);
		
		if (disciplinaOptional.isEmpty()) {
			throw new RuntimeException("Disciplina inexistente");
		}
		
		disciplinaRepository.deleteById(id);
	}
}
