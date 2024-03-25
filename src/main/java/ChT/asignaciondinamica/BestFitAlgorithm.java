package ChT.asignaciondinamica;

import java.util.List;

public class BestFitAlgorithm implements IAllocationAlgorithm{

    @Override
    public MemoryBlock getMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock bestBlock = null;
        for (MemoryBlock block : blocks){
            if(block.IsFree() && block.getSize() >= size){
                if(bestBlock == null || block.getSize() < bestBlock.getSize()){
                    bestBlock = block;
                }
            }
        }
        return bestBlock;
    }
}
