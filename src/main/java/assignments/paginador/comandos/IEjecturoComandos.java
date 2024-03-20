package assignments.paginador.comandos;

public interface IEjecturoComandos {
    void ejecutarComando(String comando, String argumento);
    void adicionarComando(String token, IComando comando);
}
