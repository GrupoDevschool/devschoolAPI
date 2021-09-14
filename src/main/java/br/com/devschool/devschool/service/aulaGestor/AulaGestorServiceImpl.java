package br.com.devschool.devschool.service.aulaGestor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.AulaGestor;
import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.formDto.AulaGestorFormDTO;
import br.com.devschool.devschool.repository.AulaGestorRepository;
import br.com.devschool.devschool.repository.AulaRepository;
import br.com.devschool.devschool.repository.GestorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AulaGestorServiceImpl implements AulaGestorService {
	
	private final AulaGestorRepository aulaGestorRepository;
	private final GestorRepository gestorRepository;
	private final AulaRepository aulaRepository;
	
	@Override
	public List<AulaGestor> listarAulasGestores() {
		List<AulaGestor> aulasGestores = aulaGestorRepository.findAll();
		return aulasGestores;
	}

	@Override
	public AulaGestor inserirAulaGestor(AulaGestorFormDTO aulaGestorDTO) {
		Optional<Gestor> gestorOptional = gestorRepository.findById(aulaGestorDTO.getGestorId());
		if (gestorOptional.isEmpty()) {
			throw new RuntimeException("Gestor inexistente");
		}
		Gestor gestor = gestorOptional.get();
		
		Optional<Aula> aulaOptional = aulaRepository.findById(aulaGestorDTO.getAulaId());
		if (aulaOptional.isEmpty()) {
			throw new RuntimeException("Aula inexistente");
		}
		Aula aula = aulaOptional.get();
		
		AulaGestor aulaGestor = AulaGestor.builder()
				.gestor(gestor)
				.aula(aula)
				.build();
		
		return aulaGestorRepository.save(aulaGestor);
	}

	@Override
	public AulaGestor alterarAulaGestor(Integer id, AulaGestorFormDTO aulaGestorDTO) {
		Optional<AulaGestor> aulaGestorOptional = aulaGestorRepository.findById(id);
		if (aulaGestorOptional.isEmpty()) {
			throw new RuntimeException("AulaGestor inexistente");
		}
		AulaGestor aulaGestor = aulaGestorOptional.get();
		
		Optional<Gestor> gestorOptional = gestorRepository.findById(aulaGestorDTO.getGestorId());
		if (gestorOptional.isEmpty()) {
			throw new RuntimeException("Gestor inexistente");
		}
		Gestor gestor = gestorOptional.get();
		
		Optional<Aula> aulaOptional = aulaRepository.findById(aulaGestorDTO.getAulaId());
		if (aulaOptional.isEmpty()) {
			throw new RuntimeException("Aula inexistente");
		}
		Aula aula = aulaOptional.get();
		
		aulaGestor.setAula(aula);
		aulaGestor.setGestor(gestor);
		
		return aulaGestorRepository.save(aulaGestor);
		
	}

	@Override
	public void excluirAulaGestor(Integer id) {
		Optional<AulaGestor> aulaGestorOptional = aulaGestorRepository.findById(id);
		if (aulaGestorOptional.isEmpty()) {
			throw new RuntimeException("AulaGestor inexistente");
		}
		
		aulaGestorRepository.deleteById(id);
	}

}
