package padroesestruturais.proxy;

import java.util.List;

public class VooProxy implements IVoo {

    private Voo voo;

    private Integer codigo;

    public VooProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosVoo() {
        if (this.voo == null) {
            this.voo = new Voo(this.codigo);
        }
        return this.voo.obterDadosVoo();
    }

    @Override
    public List<String> obterPassageiros(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.voo == null) {
            this.voo = new Voo(this.codigo);
        }
        return this.voo.obterPassageiros(funcionario);
    }
}
