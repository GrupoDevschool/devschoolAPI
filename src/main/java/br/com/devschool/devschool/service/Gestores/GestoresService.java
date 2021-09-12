package br.com.devschool.devschool.service.Gestores;

import br.com.devschool.devschool.model.Gestores;
import br.com.devschool.devschool.model.dto.GestoresDTO;

import java.util.List;

public interface GestoresService {

    public List<Gestores> listarGestores();

    public Gestores inserirGestor(GestoresDTO gestoresDTO);

    public Gestores alterarGestor(String nome,GestoresDTO gestoresDTO);

    public void excluirGestor(String nome);
}
