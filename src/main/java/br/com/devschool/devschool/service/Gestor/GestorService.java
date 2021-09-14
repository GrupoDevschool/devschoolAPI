package br.com.devschool.devschool.service.Gestor;

import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.dto.GestorDTO;

import java.util.List;

public interface GestorService {

    public List<Gestor> listarGestores();

    public Gestor inserirGestor(GestorDTO gestorDTO);

    public Gestor alterarGestor(Integer id,GestorDTO gestorDTO);

    public void excluirGestor(Integer id);
}
