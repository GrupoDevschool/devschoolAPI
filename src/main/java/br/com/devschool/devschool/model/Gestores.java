package br.com.devschool.devschool.model;


import br.com.devschool.devschool.model.dto.GestoresDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gestores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;

    private String contato;

    public Gestores(GestoresDTO gestoresDTO) {
        this.nome = gestoresDTO.getNome();
        this.contato = gestoresDTO.getContato();

    }
}
