
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import assignments.dynamicmemory.BestFitAlgorithm;
import assignments.dynamicmemory.FirstFitAlgorithm;
import assignments.dynamicmemory.IMemoryAllocator;
import assignments.dynamicmemory.MemoryAllocator;

public class MemoryAllocatorTest {
    @Test
    public void testAllocate() {
        IMemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());
        boolean result = allocator.Allocate("A", 50);

        Assertions.assertTrue(result); // Verifica que la asignación fue exitosa
        Assertions.assertFalse(allocator.IsEmpty()); // Verifica que la memoria ya no está vacía
    }

    @Test
    public void testDeallocate() {
        IMemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());
        allocator.Allocate("A", 50);
        boolean result = allocator.DeAllocate("A");

        Assertions.assertTrue(result);
        Assertions.assertTrue(allocator.IsEmpty());
    }

    @Test
    public void testChangeAllocationStrategy() {
        MemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());
        allocator.Allocate("A", 50);

        // Cambiar a BestFitAlgorithm y realizar otra asignación
        allocator.setAllocationStrategy(new BestFitAlgorithm());
        boolean result = allocator.Allocate("B", 100);

        Assertions.assertTrue(result); // Verifica que la asignación con el nuevo algoritmo fue exitosa

    }
}
