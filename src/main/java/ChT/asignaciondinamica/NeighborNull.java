package ChT.asignaciondinamica;

import java.util.List;

public class NeighborNull implements INeighborNull {
    MemoryAllocator memoryAllocator = new MemoryAllocator();
    @Override
    public MemoryBlock nextBlock(List<MemoryBlock> blocks, MemoryBlock block) {
        int index = blocks.indexOf(block);
        if (index + 1 < blocks.size()) {
            MemoryBlock nextBlock = blocks.get(index + 1); // Esta línea es la misma que la de la clase FirstFitAlgorithm.
            if (nextBlock.getObject() == null) {
                return nextBlock;
            }
        }
        return null;
    }

    @Override
    public MemoryBlock previousBlock(List<MemoryBlock> blocks, MemoryBlock block) {
        int index = blocks.indexOf(block);
        if (index - 1 >= 0) {
            MemoryBlock previousBlock = blocks.get(index - 1);
            if (previousBlock.getObject() == null) {
                return previousBlock;
            }
        }
        return null;
    }
}
