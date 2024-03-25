package ChT.asignaciondinamica;

import java.util.List;

public class MemoryFusion {
    MemoryAllocator memoryAllocator = new MemoryAllocator();
    NeighborNull allocator = new NeighborNull();
    public void mergeEmptyNeighbors(List<MemoryBlock> blocks, MemoryBlock block) {
        MemoryBlock nextBlock = allocator.nextBlock(blocks, block);
        if (nextBlock != null) {
            merge(blocks.indexOf(block), block, blocks);
        }
        MemoryBlock previousBlock = allocator.previousBlock(blocks, block);
        if (previousBlock != null) {
            merge(blocks.indexOf(previousBlock), previousBlock, blocks);
        }
    }
    private void merge(int index, MemoryBlock block, List<MemoryBlock> blocks) {
        MemoryBlock nullNeighborBlock = blocks.get(index + 1);
        block.setSize(block.getSize() + nullNeighborBlock.getSize());
        blocks.remove(nullNeighborBlock);
    }
}
