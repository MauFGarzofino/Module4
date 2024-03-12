
## Template - Concepto
El Patrón Template Method define el esqueleto de un algoritmo en el método de una superclase pero deja que las subclases sobrescriban ciertos pasos del algoritmo sin cambiar su estructura.

## Componentes

+ `Clase Abstracta`: Define métodos abstractos que las subclases concretas implementarán y un método de plantilla (template) que utiliza estos métodos para definir el esqueleto de un algoritmo.
+ `Métodos Concretos`: Implementaciones que serán iguales para todas las clases.
+ `Métodos Abstractos/Hooks`: Declaraciones que las subclases deben implementar.

### Ejemplo

```java
abstract class BebidaCaliente {
    // Template method
    final void prepararReceta() {
        hervirAgua();
        preparar();
        verterEnTaza();
        agregarCondimentos();
    }

    void hervirAgua() {
        System.out.println("Hirviendo agua");
    }

    abstract void preparar();

    void verterEnTaza() {
        System.out.println("Vertiendo en taza");
    }

    abstract void agregarCondimentos();
}

class Te extends BebidaCaliente {
    void preparar() {
        System.out.println("Sumergiendo el té");
    }

    void agregarCondimentos() {
        System.out.println("Añadiendo limón");
    }
}

class Cafe extends BebidaCaliente {
    void preparar() {
        System.out.println("Pasando el café");
    }

    void agregarCondimentos() {
        System.out.println("Añadiendo azúcar y leche");
    }
}
```

## Diferencias con Strategy
1. Template Method usa herencia para variar parte de un algoritmo. Las subclases extienden la funcionalidad para pasos específicos del algoritmo sin cambiar su estructura.
2. Strategy usa composición. Diferentes comportamientos se encapsulan en objetos separados, y el contexto original puede variar su comportamiento componiéndose con un objeto de estrategia diferente.