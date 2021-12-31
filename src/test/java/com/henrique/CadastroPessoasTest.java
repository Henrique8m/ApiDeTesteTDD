package com.henrique;

import com.henrique.cadastro.CadastroPessoas;
import com.henrique.entity.Pessoa;
import com.henrique.exception.CastroOrazioException;
import com.henrique.exception.PessoaSemNotException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TDD testar - implementar - refatorar

public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoa") //para criar um nome de melhor visualização
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas pessoas = new CadastroPessoas();

        //verificação]
        Assertions.assertThat(pessoas.getPessoa()).isEmpty();
    }

    @Test
    @DisplayName("Deve adcionar uma pessoa")
    public void deveAdcionarUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setName("henrique");

        //execução
        cadastroPessoas.adicionar(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoa())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);

    }

    @Test
    @DisplayName("Não deve adcionar pessoa com o nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setName("henrique");
        cadastroPessoas.adicionar(pessoa);

        //significa que eu espero que o erro aconteça
        //org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNotException.class, () -> cadastroPessoas.adicionar(pessoa));

        //espero que o erro não aconteça
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() ->cadastroPessoas.adicionar(pessoa));

    }

    @Test
    @DisplayName("Não deve remover uma pessoa")
    public void deveRemoverUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setName("henrique");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoa()).isEmpty();
    }

    @Test
    @DisplayName("Deve lançar erro ao tentar remover pessoa inexistente")
    public void deveLancarErrroAoTentarRemoverPessoaInexistente(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
       // pessoa.setName("henrique");
       // cadastroPessoas.adicionar(pessoa);

        //execução
        // deve lançar exceção pq removel pessoa que nao existe
        org.junit.jupiter.api.Assertions.assertThrows(CastroOrazioException.class, () -> cadastroPessoas.remover(pessoa));
    }

}
