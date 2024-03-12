package usfx.strategy;

public class Main {
    public static void main(String[] args) {
        Producto manzana = new Producto("Manzana", 0.5, 0, 20);
        manzana.establecerEstrategiaPrecio(new PrecioPorDocena());
        System.out.println("Total por comprar 13 manzanas: " + manzana.comprar(13) + ". Stock restante: " + manzana.stock);

        Producto naranja = new Producto("Naranja", 1, 0, 10);
        naranja.establecerEstrategiaPrecio(new PrecioPorUnidad());
        System.out.println("Total por comprar 6 naranjas: " + naranja.comprar(6) + ". Stock restante: " + naranja.stock);

        manzana.comprar(15);
    }

    static class Producto {
        String nombre;
        double precio;
        int cantidad;
        int stock;
        EstrategiaPrecio estrategiaPrecio;

        public Producto(String nombre, double precio, int cantidad, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
            this.stock = stock;
        }

        public void establecerEstrategiaPrecio(EstrategiaPrecio estrategiaPrecio) {
            this.estrategiaPrecio = estrategiaPrecio;
        }

        public double comprar(int cantidad) {
            if (cantidad > this.stock) {
                System.out.println("No hay suficiente stock para: " + this.nombre);
            }
            this.stock -= cantidad; // Reducir el stock
            return estrategiaPrecio.calcularPrecio(this.precio, cantidad);
        }
    }

    interface EstrategiaPrecio {
        double calcularPrecio(double precio, int cantidad);
    }

    static class PrecioPorUnidad implements EstrategiaPrecio {
        @Override
        public double calcularPrecio(double precio, int cantidad) {
            return precio * cantidad;
        }
    }

    static class PrecioPorDocena implements EstrategiaPrecio {
        @Override
        public double calcularPrecio(double precio, int cantidad) {
            if (cantidad < 12) {
                return precio * cantidad;
            }
            int docenas = cantidad / 12;
            int resto = cantidad % 12;
            return precio * (docenas * 10 + resto);
        }
    }
}
