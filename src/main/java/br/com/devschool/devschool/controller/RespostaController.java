package br.com.devschool.devschool.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resposta")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RespostaController {
}
