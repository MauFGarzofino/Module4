package assignments.dynamicmemory;

public interface IMemoryAllocator {
    boolean Allocate(String objectName, int size);
    boolean DeAllocate(String objectName);

    void setAllocationStrategy(IAllocationAlgorithm newAlgorithm);
    boolean IsEmpty();

    boolean IsFull();

    void ShowMemory();
}
