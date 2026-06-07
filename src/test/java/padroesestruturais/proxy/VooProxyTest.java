package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VooProxyTest {

    @BeforeEach
    void setUp() {
        BD.addVoo(new Voo(101, "São Paulo", "Rio de Janeiro", "Carlos Silva", "Ana Souza"));
        BD.addVoo(new Voo(202, "Brasília", "Salvador", "Pedro Lima", "Maria Oliveira"));
    }

    @Test
    void deveObterDadosDoVoo() {
        IVoo voo = new VooProxy(101);
        List<String> dados = voo.obterDadosVoo();

        assertEquals(2, dados.size());
        assertEquals("São Paulo", dados.get(0));
        assertEquals("Rio de Janeiro", dados.get(1));
    }

    @Test
    void deveObterPassageirosComAdministrador() {
        IVoo voo = new VooProxy(101);
        Funcionario admin = new Funcionario("João", true);

        List<String> passageiros = voo.obterPassageiros(admin);

        assertEquals(2, passageiros.size());
        assertEquals("Carlos Silva", passageiros.get(0));
        assertEquals("Ana Souza", passageiros.get(1));
    }

    @Test
    void deveLancarExcecaoQuandoNaoAdministrador() {
        IVoo voo = new VooProxy(202);
        Funcionario comum = new Funcionario("Maria", false);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> voo.obterPassageiros(comum)
        );

        assertEquals("Funcionário não autorizado", exception.getMessage());
    }

    @Test
    void deveObterDadosDeOutroVoo() {
        IVoo voo = new VooProxy(202);
        List<String> dados = voo.obterDadosVoo();

        assertEquals("Brasília", dados.get(0));
        assertEquals("Salvador", dados.get(1));
    }

    @Test
    void deveObterPassageirosDeOutroVooComAdmin() {
        IVoo voo = new VooProxy(202);
        Funcionario admin = new Funcionario("Gerente", true);

        List<String> passageiros = voo.obterPassageiros(admin);

        assertEquals("Pedro Lima", passageiros.get(0));
        assertEquals("Maria Oliveira", passageiros.get(1));
    }
}
