package assignments.paginador.comandos;

import java.util.HashMap;
import java.util.Map;

public class EjecutorComandos implements IEjecturoComandos{

    private Map<String, IComando> comandos;

    public EjecutorComandos() {
        comandos = new HashMap<>();
    }

    @Override
    public void ejecutarComando(String nombreComando, String argumento) {
        IComando comando = comandos.get(nombreComando);
        if (comando != null) {
            comando.setArgumento(argumento);
            comando.ejecutar();
        } else {
            System.out.println("Comando no reconocido");
        }
    }


    @Override
    public void adicionarComando(String token, IComando comando) {
        comandos.put(token, comando);
    }
}
