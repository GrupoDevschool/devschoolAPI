package br.com.devschool.devschool.service.Disciplina;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.repository.AreaRepository;
import br.com.devschool.devschool.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService{

	private DisciplinaRepository disciplinaRepository;
	private AreaRepository areaRepository;
	
	@Override
	public List<Disciplina> listarDisciplinas(Integer areaId) {
		if (areaId != null) {
			return disciplinaRepository.findAllByArea_Id(areaId);
		}
		return disciplinaRepository.findAll();
	}

	@Override
	public Disciplina getDisciplinaById(Integer id) {
		return disciplinaRepository.findById(id).get();
	}

	@Override
	public Disciplina inserirDisciplina(DisciplinaDTO disciplinaDTO) {
		Disciplina disciplina = Disciplina.builder()
				.nome(disciplinaDTO.getNome())
				.area(new Area(disciplinaDTO.getArea()))
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
		disciplina.setArea(new Area(disciplinaDTO.getArea()));
		
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
