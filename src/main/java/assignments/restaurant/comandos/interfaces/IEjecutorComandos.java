package assignments.restaurant.comandos.interfaces;

public interface IEjecutorComandos {
    void ejecutarComando(String comando);
    void adicionarComando(String token, IComando comando);
}
