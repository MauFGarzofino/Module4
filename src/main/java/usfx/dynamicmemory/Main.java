package usfx.dynamicmemory;

public class Main {
    public static void main(String[] args) {

        IMemoryAllocator allocator=new MemoryAllocator(1000,new FirstFitAlgorithm());


        System.out.println("La memoria está vacía? :" +  allocator.IsEmpty());

        allocator.Allocate("A",50);
        allocator.Allocate("B",150);
        allocator.Allocate("C",250);
        allocator.Allocate("D",350);


        allocator.IsFull();
        allocator.ShowMemory();

        allocator.DeAllocate("C");
        allocator.Allocate("E",60);

        allocator.ShowMemory();

        allocator.DeAllocate("D");
        allocator.ShowMemory();

        // Cambiar a BestFitAlgorithm
        allocator = new MemoryAllocator(1000, new BestFitAlgorithm());
        // ...

        // Cambiar a WorstFitAlgorithm
        allocator = new MemoryAllocator(1000, new WorstFitAlgorithm());
        // ...
    }
}