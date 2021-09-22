package br.com.devschool.devschool.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.infrastructure.exception.PerguntaMalFormuladaException;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(ContentNotFoundException.class)
	public ResponseEntity<Map<String, String>> conteudoNaoEncontrado(ContentNotFoundException exception) {
		Map<String, String> response = new HashMap<>();
		response.put("menssagem", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> atributoInvalido(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
	    exception.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	public ResponseEntity<Map<String, String>> exclusaoDeConteudoComDependencia() {
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> tipoDoAtributoIncorreto(HttpMessageNotReadableException exception) {
		Map<String, String> response = new HashMap<>();
		response.put("menssagem", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(PerguntaMalFormuladaException.class)
	public ResponseEntity<Map<String, String>> perguntaMalFormulada(PerguntaMalFormuladaException exception) {
		Map<String, String> response = new HashMap<>();
		response.put("menssagem", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, String>> violacaoDeIntegridadeDosRegistrosNoBanco(DataIntegrityViolationException exception) {
		Map<String, String> response = new HashMap<>();
		response.put("menssagem", "A operação desejada viola as regras de integridade dos dados");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
