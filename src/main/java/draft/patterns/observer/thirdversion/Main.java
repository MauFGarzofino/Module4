package draft.patterns.observer.thirdversion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Numeros n = new Numeros();
        int umbral = 5;
        IObservador sumador = new ObservadorSumador(n);
        n.Attach(new DecoradorRegistro(sumador));
        ObservadorMayor mayor = new ObservadorMayor(n);
        n.Attach(new DecoradorFiltradoUmbral(mayor, n, umbral));
        ObservadorMenor menor = new ObservadorMenor(n);
        n.Attach(new DecoradorRegistro(menor));
        ObservadorImpares impares = new ObservadorImpares(n);
        n.Attach(new DecoradorRegistro(impares));

        n.Adicionar(3);
        n.Adicionar(2);
        n.Adicionar(5);
        n.Adicionar(10);
        n.Adicionar(13);
        n.Adicionar(9);
        n.Adicionar(7);
        n.Adicionar(1);
        n.Adicionar(12);
    }
}

interface IObservador
{
    void Actualizar();
}

class DecoradorRegistro  implements IObservador {
    private IObservador observadorDecorado;

    public DecoradorRegistro (IObservador observador) {
        this.observadorDecorado = observador;
    }

    @Override
    public void Actualizar() {
        observadorDecorado.Actualizar();
        System.out.println("Observador " + observadorDecorado.getClass().getSimpleName() + " actualizado.");
    }
}

class DecoradorFiltradoUmbral implements IObservador {
    private  IObservador observadorDecorado;
    private final Numeros numeros;
    private final int umbral;

    public DecoradorFiltradoUmbral(IObservador observador, Numeros numeros, int umbral) {
        this.observadorDecorado = observador;
        this.numeros = numeros;
        this.umbral = umbral;
    }

    @Override
    public void Actualizar() {
        int ultimoNumero = numeros.GetListaNumeros().getLast();

        System.out.println("Ultimo numero: " + ultimoNumero);

        if (ultimoNumero >= umbral) {
            System.out.println("Número:  " + ultimoNumero + "  es mayor que: " + umbral);
            observadorDecorado.Actualizar();
        } else {
            System.out.println("Número:  " + ultimoNumero + "  no supera el umbral " + umbral);
        }
    }
}

class Numeros
{
    List<Integer> numeros;
    List<IObservador> observadores;
    public Numeros()
    {
        numeros = new ArrayList<>();
        observadores = new ArrayList<>();
    }

    public void Attach(IObservador observador)
    {
        observadores.add(observador);
    }

    public void Adicionar(int n)
    {
        if (!numeros.contains(n)){
            numeros.add(n);
            Notificar();
        }
    }

    private void Notificar()
    {
        for(IObservador obs : observadores){
            obs.Actualizar();
        }
    }

    public List<Integer> GetListaNumeros(){
        return numeros;
    }
}

class ObservadorSumador implements IObservador
{
    private Numeros numeros;

    public ObservadorSumador(Numeros nums)
    {
        numeros = nums;
    }
    public void Actualizar()
    {
        int sumatoria=0;
        for (int n : numeros.GetListaNumeros())
        {
            sumatoria+=n;
        }

        System.out.println("Sumatoria "+sumatoria);
    }
}

class ObservadorMayor implements IObservador
{
    private Numeros numeros;

    public ObservadorMayor(Numeros nums)
    {
        numeros = nums;
    }
    public void Actualizar()
    {
        int mayor = Integer.MIN_VALUE;
        for (int n : numeros.GetListaNumeros())
        {
            if(n>mayor){
                mayor = n;
            }
        }

        System.out.println("El mayor es "+ mayor);
    }
}
class ObservadorMenor implements IObservador
{
    private Numeros numeros;

    public ObservadorMenor(Numeros nums)
    {
        numeros = nums;
    }
    public void Actualizar()
    {
        int menor = Integer.MAX_VALUE;
        for (int n : numeros.GetListaNumeros())
        {
            if(n<menor){
                menor = n;
            }
        }

        System.out.println("El menor es "+ menor);
    }
}
class ObservadorImpares implements IObservador {
    private Numeros numeros;

    public ObservadorImpares(Numeros nums){
        this.numeros = nums;
    }

    @Override
    public void Actualizar() {
        List<Integer> impares = new ArrayList<>();

        for(Integer num : numeros.GetListaNumeros()) {
            if(num % 2 != 0){
                impares.add(num);
            }
        }

        if(impares.isEmpty()){
            System.out.println("No hay números impares");
            return;
        }

        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for (int n : impares) {
            if (n > mayor) {
                mayor = n;
            }
            if (n < menor) {
                menor = n;
            }
        }

        int suma = 0;
        for (Integer num : impares) {
            suma += num;
        }

        System.out.println("Suma de impares: " + suma);
        System.out.println("Mayor número impar: " + mayor);
        System.out.println("Menor número impar: " + menor);
    }
}