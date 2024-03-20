package draft.patterns.observer.secondversion.refactor;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Numeros n = new Numeros();
        attachObservers(n);

        int[] listaDeNumeros = {3, 2, 5, 10, 13, 9, 28, 12, 4};
        for (int numero : listaDeNumeros) {
            n.Adicionar(numero);
        }
    }
    private static void attachObservers(Numeros n) {
        n.Attach(decorarConRegistro(new ObservadorSumador(n)));
        n.Attach(decorarConRegistro(new ObservadorMayor(n)));
        n.Attach(decorarConRegistro(new ObservadorMenor(n)));
        n.Attach(decorarConRegistro(new ObservadorImpares(n)));
        n.Attach(decorarConRegistro(new ObservadoresPares(n)));
    }
    private static IObservador decorarConRegistro(IObservador observador) {
        return new DecoradorRegistro(observador);
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
        printRegistro();
        observadorDecorado.Actualizar();
    }
    public void printRegistro() {
        System.out.println("Observador " + observadorDecorado.getClass().getSimpleName() + " actualizado.");
    }
}

abstract class ObservadorBase implements IObservador {
    protected Numeros numeros;

    public ObservadorBase(Numeros nums) {
        this.numeros = nums;
    }

    protected List<Integer> filtrarNumeros(Predicate<Integer> criterio) {
        List<Integer> resultado = new ArrayList<>();

        for (Integer num : numeros.GetListaNumeros()) {
            if (criterio.test(num)) {
                resultado.add(num);
            }
        }
        return resultado;
    }

    protected int calcularSuma(List<Integer> lista) {
        int sumatoria=0;
        for (int n : lista)
        {
            sumatoria+=n;
        }

        return sumatoria;
    }

    protected int encontrarMaximo(List<Integer> lista) {
        int mayor = Integer.MIN_VALUE;
        for (int n : lista)
        {
            if(n > mayor){
                mayor = n;
            }
        }
        return mayor;
    }

    protected int encontrarMinimo(List<Integer> lista) {
        int menor = Integer.MAX_VALUE;
        for (int n : lista)
        {
            if(n < menor){
                menor = n;
            }
        }
        return menor;
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

class ObservadorSumador extends ObservadorBase {
    public ObservadorSumador(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        int suma = calcularSuma(numeros.GetListaNumeros());
        System.out.println("Sumatoria: " + suma);
    }
}

class ObservadorMayor extends ObservadorBase {
    public ObservadorMayor(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        List<Integer> lista = numeros.GetListaNumeros();
        if (!lista.isEmpty()) {
            int mayor = encontrarMaximo(lista);
            System.out.println("El mayor es: " + mayor);
        }
    }
}

class ObservadorMenor extends ObservadorBase {
    public ObservadorMenor(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        List<Integer> lista = numeros.GetListaNumeros();
        if (!lista.isEmpty()) {
            int menor = encontrarMinimo(lista);
            System.out.println("El menor es: " + menor);
        }
    }
}

class ObservadorImpares extends ObservadorBase {
    public ObservadorImpares(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        Predicate<Integer> esImpar = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 != 0;
            }
        };

        List<Integer> impares = filtrarNumeros(esImpar);

        if (impares.isEmpty()) {
            System.out.println("No hay números impares.");
            return;
        }

        int suma = calcularSuma(impares);
        int mayor = encontrarMaximo(impares);
        int menor = encontrarMinimo(impares);

        System.out.println("Suma de impares: " + suma);
        System.out.println("Mayor número impar: " + mayor);
        System.out.println("Menor número impar: " + menor);
    }
}

class ObservadoresPares extends ObservadorBase {
    public ObservadoresPares(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        List<Integer> pares = filtrarNumeros(n -> n % 2 == 0);

        if (pares.isEmpty()) {
            System.out.println("No hay números pares.");
            return;
        }

        int suma = calcularSuma(pares);
        int mayor = encontrarMaximo(pares);
        int menor = encontrarMinimo(pares);

        System.out.println("Suma de pares: " + suma);
        System.out.println("Mayor número pares: " + mayor);
        System.out.println("Menor número pares: " + menor);
    }
}