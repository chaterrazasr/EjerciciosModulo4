package ChT.asignaciondinamica;

import java.util.List;

public interface INeighborNull {
    MemoryBlock nextBlock(List<MemoryBlock> blocks, MemoryBlock block);
    MemoryBlock previousBlock(List<MemoryBlock> blocks, MemoryBlock block);
}
