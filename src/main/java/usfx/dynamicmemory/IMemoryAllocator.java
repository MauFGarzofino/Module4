package usfx.dynamicmemory;

public interface IMemoryAllocator {
    boolean Allocate(String objectName, int size);
    boolean DeAllocate(String objectName);

    boolean IsEmpty();

    boolean IsFull();

    void ShowMemory();
}
