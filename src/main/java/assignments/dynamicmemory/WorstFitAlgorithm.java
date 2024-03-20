package assignments.dynamicmemory;

import java.util.List;

public class WorstFitAlgorithm implements IAllocationAlgorithm {
    @Override
    public MemoryBlock GetMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock worstBlock = null;
        int largestSize = 0;

        for (MemoryBlock block : blocks) {
            if (block.IsFree() && block.getSize() >= size) {
                if (block.getSize() > largestSize) {
                    largestSize = block.getSize();
                    worstBlock = block;
                }
            }
        }

        return worstBlock;
    }
}