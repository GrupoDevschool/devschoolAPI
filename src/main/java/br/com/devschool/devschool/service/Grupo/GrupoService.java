package br.com.devschool.devschool.service.Grupo;


import br.com.devschool.devschool.model.Grupo;
import br.com.devschool.devschool.model.formDto.GrupoFormDTO;

import java.util.List;

public interface GrupoService {
    List<Grupo> listarGrupos();

    Grupo buscarGrupoPorId(Integer id);

    Grupo inserirGrupo(GrupoFormDTO grupoDTO);

    Grupo alterarGrupo(Integer id, GrupoFormDTO grupoDTO);

    void excluirGrupo(Integer id);

}
