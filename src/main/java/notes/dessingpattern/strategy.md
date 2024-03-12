## Strategy - Concept
El Patrón Strategy define una familia de algoritmos, encapsula cada uno, y los hace intercambiables. La estrategia permite que el algoritmo varíe independientemente de los clientes que lo usan.

## Componentes
+ `Contexto`: Mantiene una referencia a una estrategia concreta y puede definir una interfaz para permitir que la estrategia acceda a sus datos.
+ `Estrategia (Interface)`: Una interfaz común para todos los algoritmos soportados.
+ `Estrategias Concretas`: Implementaciones diferentes de la interfaz de estrategia.

## Ejemplo
``` java
interface EstrategiaRuta {
    String calcularRuta(String puntoA, String puntoB);
}

class EstrategiaRapida implements EstrategiaRuta {
    public String calcularRuta(String puntoA, String puntoB) {
        return "Ruta más rápida entre " + puntoA + " y " + puntoB;
    }
}

class EstrategiaCorta implements EstrategiaRuta {
    public String calcularRuta(String puntoA, String puntoB) {
        return "Ruta más corta entre " + puntoA + " y " + puntoB;
    }
}

class Navegador {
    private EstrategiaRuta estrategia;

    public Navegador(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }

    public void calcularRuta(String puntoA, String puntoB) {
        System.out.println(estrategia.calcularRuta(puntoA, puntoB));
    }
}
```

### Diferencias con Template

1. Template Method usa herencia para variar parte de un algoritmo. Las subclases extienden la funcionalidad para pasos específicos del algoritmo sin cambiar su estructura.
2. Strategy usa composición. Diferentes comportamientos se encapsulan en objetos separados, y el contexto original puede variar su comportamiento componiéndose con un objeto de estrategia diferente.