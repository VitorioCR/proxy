package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Voo implements IVoo {

    private Integer codigo;
    private String origem;
    private String destino;
    private String passageiro1;
    private String passageiro2;

    public Voo(int codigo) {
        this.codigo = codigo;
        Voo objeto = BD.getVoo(codigo);
        this.origem = objeto.origem;
        this.destino = objeto.destino;
        this.passageiro1 = objeto.passageiro1;
        this.passageiro2 = objeto.passageiro2;
    }

    public Voo(Integer codigo, String origem, String destino, String passageiro1, String passageiro2) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.passageiro1 = passageiro1;
        this.passageiro2 = passageiro2;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosVoo() {
        return Arrays.asList(this.origem, this.destino);
    }

    @Override
    public List<String> obterPassageiros(Funcionario funcionario) {
        return Arrays.asList(this.passageiro1, this.passageiro2);
    }
}
