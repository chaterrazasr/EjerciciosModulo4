package ChT.asignaciondinamica;

import java.util.List;

public class WorstFitAlgorithm implements IAllocationAlgorithm{

    @Override
    public MemoryBlock getMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock worstBlock = null;
        for (MemoryBlock block : blocks){
            if(block.IsFree() && block.getSize() >= size){
                if(worstBlock == null || block.getSize() > worstBlock.getSize()){
                    worstBlock = block;
                }
            }
        }
        return worstBlock;
    }
}
