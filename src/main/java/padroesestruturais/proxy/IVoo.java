package padroesestruturais.proxy;

import java.util.List;

public interface IVoo {
    List<String> obterDadosVoo();
    List<String> obterPassageiros(Funcionario funcionario);
}
