package br.com.devschool.devschool.service.Disciplina;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.formDto.DisciplinaFormDTO;
import br.com.devschool.devschool.repository.DisciplinaRepository;
import br.com.devschool.devschool.service.Area.AreaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService{

	private final DisciplinaRepository disciplinaRepository;
	private final AreaService areaService;
	
	@Override
	public List<Disciplina> listarDisciplinas(Integer areaId) {
		if (areaId != null) {
			return disciplinaRepository.findAllByArea_Id(areaId);
		}
		return disciplinaRepository.findAll();
	}

	@Override
	public Disciplina getDisciplinaById(Integer id) {
		return disciplinaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Disciplina com id " + id + " nao encontrada."));
	}

	@Override
	public Disciplina inserirDisciplina(DisciplinaFormDTO disciplinaDTO) {
		Area area = areaService.listarAreaById(disciplinaDTO.getArea());
		
		Disciplina disciplina = Disciplina.builder()
				.nome(disciplinaDTO.getNome())
				.area(area)
				.build();
		
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public Disciplina alterarDisciplina(Integer id, DisciplinaFormDTO disciplinaDTO) {
		Disciplina disciplina = this.getDisciplinaById(id);
		Area area = areaService.listarAreaById(disciplinaDTO.getArea());
				
		disciplina.setNome(disciplinaDTO.getNome());
		disciplina.setArea(area);
		
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public void excluirDisciplina(Integer id) {
		this.getDisciplinaById(id);
		disciplinaRepository.deleteById(id);
	}
}
