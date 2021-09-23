package br.com.devschool.devschool.service.Questoes;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.QuestaoFormDto;
import br.com.devschool.devschool.repository.PerguntaRepository;
import br.com.devschool.devschool.repository.QuestoesRepository;
import br.com.devschool.devschool.repository.RespostaRepository;
import br.com.devschool.devschool.service.Avaliacao.AvaliacaoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestoesServiceImpl implements QuestoesService {

    private QuestoesRepository questoesRepository;
    private PerguntaRepository perguntaRepository;
    private RespostaRepository respostaRepository;
    private AvaliacaoService avaliacaoService;
    
    @Override
    public List<Questoes> listarQuestoes(Integer avaliacaoId) {
        if (avaliacaoId != null) {
            return questoesRepository.findAllByAvaliacao_Id(avaliacaoId);
        }
        return questoesRepository.findAll();
    }

    @Override
    public Questoes listarQuestoesById(Integer id) {
        return questoesRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Questao com o id "+ id + " não encontrada"));
    }

    @Override
    public Questoes inserirQuestoes(QuestaoFormDto questoesDTO) {
    	List<Integer> respostasId = questoesDTO.getPerguntaResposta()
    			.subList(1, questoesDTO.getPerguntaResposta().size());
        Pergunta pergunta = perguntaRepository.getById(questoesDTO.getPerguntaResposta().get(0));
        List<Resposta> respostas = respostaRepository.findAllById(respostasId);
        Avaliacao avaliacao = avaliacaoService.listarAvaliacoesById(questoesDTO.getId_avaliacao());
    	
    	Questoes questoes = Questoes.builder()
                .numero(questoesDTO.getNumero())
                .avaliacao(avaliacao)
                .pergunta(pergunta)
                .resposta(respostas)
                .build();

        return  questoesRepository.save(questoes);
    }

    @Override
    public Questoes alterarQuestoes(Integer id, QuestaoFormDto questoesDTO) {

        Questoes questoes = questoesRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Questao com o : " + id + " não foi encontrada."));

        Avaliacao avaliacao = avaliacaoService.listarAvaliacoesById(questoesDTO.getId_avaliacao());
        
        List<Integer> respostasId = questoesDTO.getPerguntaResposta()
    			.subList(1, questoesDTO.getPerguntaResposta().size());
        Pergunta pergunta = perguntaRepository.getById(questoesDTO.getPerguntaResposta().get(0));
        List<Resposta> respostas = respostaRepository.findAllById(respostasId);
        
        questoes.setNumero(questoes.getNumero());
        questoes.setPergunta(pergunta);
        questoes.setResposta(respostas);
        questoes.setAvaliacao(avaliacao);
        
        return  questoesRepository.save(questoes);
    }

    @Override
    public void excluirQuestao(Integer id) {
        this.listarQuestoesById(id);
        questoesRepository.deleteById(id);

    }


}
