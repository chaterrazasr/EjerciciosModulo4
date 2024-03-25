package ChT.asignaciondinamica;

import java.util.List;

public interface IMemoryAllocator {
    boolean allocate(String ObjectName, int size);
    boolean deallocate(String ObjectName);
    boolean isEmpty();
    boolean isFull();
    void showMemory();

    List<MemoryBlock> getMemoryBlocks();
}
