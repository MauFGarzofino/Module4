package usfx.patterns.observer;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Numeros n = new Numeros();
        ObservadorSumador sumador = new ObservadorSumador(n);
        n.Attach(sumador);
        ObservadorMayor mayor =new ObservadorMayor(n);
        n.Attach(mayor);
        ObservadorMenor menor = new ObservadorMenor(n);
        n.Attach(menor);
        ObservadorImpares impares = new ObservadorImpares(n);
        n.Attach(impares);

        n.Adicionar(3);
        n.Adicionar(2);
        n.Adicionar(5);
        n.Adicionar(10);
        n.Adicionar(13);
        n.Adicionar(9);
    }
}

interface IObservador
{
    void Actualizar();
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
        for (int n : numeros.GetListaNumeros())
        {
            sumatoria+=n;
        }

        return sumatoria;
    }

    protected int encontrarMaximo(List<Integer> lista) {
        int mayor = Integer.MIN_VALUE;
        for (int n : numeros.GetListaNumeros())
        {
            if(n>mayor){
                mayor = n;
            }
        }
        return mayor;
    }

    protected int encontrarMinimo(List<Integer> lista) {
        int menor = Integer.MAX_VALUE;
        for (int n : numeros.GetListaNumeros())
        {
            if(n<menor){
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
class ObservadorMenor extends ObservadorBase
{
    public ObservadorMenor(Numeros nums) {
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

class ObservadorImpares extends ObservadorBase {
    public ObservadorImpares(Numeros nums) {
        super(nums);
    }

    @Override
    public void Actualizar() {
        List<Integer> impares = filtrarNumeros(n -> n % 2 != 0);

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
