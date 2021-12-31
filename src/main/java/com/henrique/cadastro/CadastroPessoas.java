package com.henrique.cadastro;

import com.henrique.entity.Pessoa;
import com.henrique.exception.CastroOrazioException;
import com.henrique.exception.PessoaSemNotException;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoa;

    public CadastroPessoas() {
        this.pessoa = new ArrayList<>();
    }

    public List<Pessoa> getPessoa() {
        return this.pessoa;
    }

    public void adicionar(Pessoa pessoa) {
        if(pessoa.getName() == null){
            throw new PessoaSemNotException();
        }
        this.pessoa.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if(this.pessoa.isEmpty()){
            throw new CastroOrazioException();
        }
        this.pessoa.remove(pessoa);
    }
}
