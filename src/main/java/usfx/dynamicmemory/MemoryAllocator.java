package usfx.dynamicmemory;

import java.util.ArrayList;
import java.util.List;

public class MemoryAllocator implements IMemoryAllocator
{
    private int totalSize;
    private IAllocationAlgorithm algorithm;

    private List<MemoryBlock> blocks;

    public MemoryAllocator(int totalSize, IAllocationAlgorithm algorithm) {
        this.totalSize = totalSize;
        this.algorithm = algorithm;
        blocks=new ArrayList<MemoryBlock>();

        MemoryBlock block = new MemoryBlock();
        block.setSize(totalSize);
        blocks.add(block);
    }

    @Override
    public boolean Allocate(String objectName, int size) {
        MemoryBlock block = algorithm.GetMemoryBlock(blocks, size);

        if(size > totalSize) {
            System.out.println("Solicitud de memoria excede el tamaño total dispo");
            return false;
        }

        if (block == null) {
            return false;
        }

        MemoryBlock newBlock = new MemoryBlock();
        newBlock.setSize(size);
        newBlock.setObject(objectName);
        int idxBlock = blocks.indexOf(block);
        blocks.add(idxBlock, newBlock);

        block.setSize(block.getSize() - size);

        if (block.getSize() == 0) {
            blocks.remove(block);
        }

        return true;
    }

    @Override
    public boolean DeAllocate(String objectName) {
        MemoryBlock block = SearchByName(objectName);

        if (block == null) {
            System.out.println("No se encontró el objeto para desasignar.");
            return false;
        }

        block.setObject(null);

        return true;
    }

    private MemoryBlock SearchByName(String objectName) {
        for (MemoryBlock b : blocks) {
            if (objectName.equals(b.getObject())) {
                return b;
            }
        }

        return null;
    }

    @Override
    public boolean IsEmpty() {
        for (MemoryBlock block : blocks) {
            if (!block.IsFree()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean IsFull() {
        for (MemoryBlock block : blocks) {
            if (block.IsFree()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void ShowMemory() {
        for (MemoryBlock m : blocks) {
            System.out.println(m.getObject() + " " + m.getSize());
        }

        System.out.println("-----------------------");
    }
    
}