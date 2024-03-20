package assignments.restaurant.comandos;

import assignments.restaurant.comandos.interfaces.IComando;
import assignments.restaurant.comandos.interfaces.IEjecutorComandos;

import java.util.HashMap;
import java.util.Map;

public class EjecutorComandos implements IEjecutorComandos {
    private Map<String, IComando> comandos;

    public EjecutorComandos() {
        this.comandos = new HashMap<>();
    }

    @Override
    public void ejecutarComando(String nombre) {
        IComando comando = comandos.get(nombre);

        if (comando != null) {
            comando.ejecutar();
        }
        else {
            System.out.println("Comando no reconocido");
        }
    }

    @Override
    public void adicionarComando(String token, IComando comando) {
        comandos.put(token, comando);
    }
}
