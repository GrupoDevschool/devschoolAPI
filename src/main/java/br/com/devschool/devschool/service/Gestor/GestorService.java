package br.com.devschool.devschool.service.Gestor;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.dto.GestorDTO;

import java.util.List;

public interface GestorService {

    List<Gestor> listarGestores();

    Gestor listarGestorById(Integer id);

    Gestor inserirGestor(GestorDTO gestorDTO);

    Gestor alterarGestor(Integer id, GestorDTO gestorDTO);

    void excluirGestor(Integer id);
}
