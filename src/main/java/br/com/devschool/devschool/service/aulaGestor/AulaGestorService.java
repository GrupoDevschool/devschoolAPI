package br.com.devschool.devschool.service.aulaGestor;

import java.util.List;

import br.com.devschool.devschool.model.AulaGestor;
import br.com.devschool.devschool.model.formDto.AulaGestorFormDTO;

public interface AulaGestorService {

	public List<AulaGestor> listarAulasGestores();
	
	public AulaGestor inserirAulaGestor(AulaGestorFormDTO aulaGestorDTO);
	
	public AulaGestor alterarAulaGestor(Integer id, AulaGestorFormDTO aulaGestorDTO);
	
	public void excluirAulaGestor(Integer id);
	
}
