package ChT.asignaciondinamica;

import java.util.ArrayList;
import java.util.List;

public class MemoryAllocator implements IMemoryAllocator {
    private int totalSize;
    private IAllocationAlgorithm algorithm;
    private List<MemoryBlock> blocks;

    public MemoryAllocator(int totalSize, IAllocationAlgorithm algorithm) {
        this.totalSize = totalSize;
        this.algorithm = algorithm;

        blocks = new ArrayList<MemoryBlock>();
        MemoryBlock block = new MemoryBlock();
        block.setSize(totalSize);
        blocks.add(block);
    }

    public MemoryAllocator() {

    }

    public List<MemoryBlock> getBlocks() {
        return blocks;
    }

    @Override
    public boolean allocate(String ObjectName, int size) {
        MemoryBlock block = algorithm.getMemoryBlock(blocks, size);

        if (block == null) {
            return false;
        }

        MemoryBlock newBlock = new MemoryBlock();
        newBlock.setSize(size);
        newBlock.setObject(ObjectName);

        int index = blocks.indexOf(block); // idxBlock -> index, get the index of the block
        blocks.add(index, newBlock);

        block.setSize(block.getSize() - size);
        if (block.getSize() == 0) {
            blocks.remove(block);
        }
        return true;
    }

    @Override
    public boolean deallocate(String ObjectName) {
        MemoryFusion memoryFusion = new MemoryFusion();
        MemoryBlock block = SearchMemoryBlock(ObjectName);
        if (block == null) {
            return false;
        }
        block.setObject(null);
        memoryFusion.mergeEmptyNeighbors(blocks, block);
        return true;
    }


    private MemoryBlock SearchMemoryBlock(String ObjectName) {
        for (MemoryBlock block : blocks) {
            if (ObjectName.equals(block.getObject())) {
                return block;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return blocks.size() == 1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void showMemory() {
        for (MemoryBlock block : blocks) {
            System.out.println("Block: " + block.getObject() + " Size: " + block.getSize());
        }
        System.out.println("______________________________________________");

    }

    @Override
    public List<MemoryBlock> getMemoryBlocks() {
        return blocks;
    }
}
