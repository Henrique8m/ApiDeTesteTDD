package com.henrique;

import com.henrique.cadastro.CadastroPessoas;
import com.henrique.entity.Pessoa;
import com.henrique.exception.CastroOrazioException;
import com.henrique.exception.PessoaSemNotException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

//TDD o nome deste teste

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas pessoas = new CadastroPessoas();

        //verificação]
        Assertions.assertThat(pessoas.getPessoa()).isEmpty();
    }

    @Test
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

    @Test( expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //verificação feita no titulo

        //execução
        cadastroPessoas.adicionar(pessoa);

    }

    @Test
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

    @Test(expected = CastroOrazioException.class)
    public void deveLancarErrroAoTentarRemoverPessoaInexistente(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.remover(pessoa);
    }

}
