package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Voo> voos = new HashMap<>();

    public static Voo getVoo(Integer codigo) {
        return voos.get(codigo);
    }

    public static void addVoo(Voo voo) {
        voos.put(voo.getCodigo(), voo);
    }
}
