package usfx.dynamicmemory;

import java.util.List;

public class FirstFitAlgorithm implements IAllocationAlgorithm
{
    @Override
    public MemoryBlock GetMemoryBlock(List<MemoryBlock> blocks, int size) {
        for (MemoryBlock b : blocks) {
            if (b.IsFree() && b.getSize() >= size) {
                return b;
            }
        }

        return null;
    }
}