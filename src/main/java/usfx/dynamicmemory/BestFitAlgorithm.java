package usfx.dynamicmemory;

import java.util.List;

public class BestFitAlgorithm implements IAllocationAlgorithm {
    @Override
    public MemoryBlock GetMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock bestBlock = null;
        int smallestDiff = Integer.MAX_VALUE;

        for (MemoryBlock block : blocks) {
            if (block.IsFree() && block.getSize() >= size) {
                int diff = block.getSize() - size;
                if (diff < smallestDiff) {
                    smallestDiff = diff;
                    bestBlock = block;
                }
            }
        }
        return bestBlock;
    }
}