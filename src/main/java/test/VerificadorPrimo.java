package test;

public class VerificadorPrimo {
    public boolean esPrimo(int numero) {
        int contador = 0;
        if (numero <= 1) {
            return false;
        }
        for(int i = 1; i <= numero; i++)
        {
            if((numero % i) == 0)
            {
                contador++;
            }
        }
        return contador <= 2;
    }
}
