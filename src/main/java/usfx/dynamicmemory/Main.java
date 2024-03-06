package usfx.dynamicmemory;

public class Main {
    public static void main(String[] args) {

        // Creación del allocator con FirstFitAlgorithm
        IMemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());

        System.out.println("Inicialmente con First Fit Algorithm:");
        allocator.Allocate("A", 50);
        allocator.Allocate("B", 150);
        allocator.Allocate("C", 250);
        allocator.Allocate("D", 350);
        allocator.ShowMemory();

        allocator.DeAllocate("C");
        allocator.Allocate("E", 60);
        allocator.ShowMemory();

        // Cambio a BestFitAlgorithm
        System.out.println("Cambiando a Best Fit Algorithm:");
        allocator.setAllocationStrategy(new BestFitAlgorithm());
        allocator.DeAllocate("B");
        allocator.Allocate("F", 140);
        allocator.ShowMemory();

        // Cambio a WorstFitAlgorithm
        System.out.println("Cambiando a Worst Fit Algorithm:");
        allocator.setAllocationStrategy(new WorstFitAlgorithm());
        allocator.Allocate("G", 100);
        allocator.ShowMemory();
    }
}
