package br.com.devschool.devschool.service.Chamada;


import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.Gestores;
import br.com.devschool.devschool.model.dto.ChamadaDTO;
import br.com.devschool.devschool.repository.ChamadaRepository;
import br.com.devschool.devschool.repository.GestoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChamadaServiceImpl  implements ChamadaService{
    public ChamadaRepository chamadaRepository;


    @Override
    public List<Chamada> ListarChamadas() {
        List<Chamada> chamadas = chamadaRepository.findAll();
        return chamadas;
    }

    @Override
    public Chamada inserirChamadas(ChamadaDTO chamadaDTO) {
        Chamada chamadas = Chamada.builder()
                .id(chamadaDTO.getId())
                .aluno(chamadaDTO.getAlunoId())
                .aula(chamadaDTO.getAulaId())
                .horaEntrada(chamadaDTO.getHoraEntrada())
                .build();

        return  chamadaRepository.save(chamadas);
    }

    @Override
    public Chamada alterarChamada(Integer id, ChamadaDTO chamadaDTO) {
        Optional<Chamada> chamadaOptional = chamadaRepository.findById(id);

        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("não encontrado");
        }
        Chamada chamadas = chamadaOptional.get();

        chamadas.setAluno(chamadaDTO.getAlunoId());
        chamadas.setHoraEntrada(chamadaDTO.getHoraEntrada());
        chamadas.setAula(chamadaDTO.getAulaId());

        return  chamadaRepository.save(chamadas);
    }

    @Override
    public void excluirChamada(Integer id) {
        Optional<Chamada> chamadaOptional = chamadaRepository.findById(id);

        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }
        chamadaRepository.deleteById(id);

    }
}
