package ChT.asignaciondinamica;

import java.util.List;

public class Display {
    public void showMemory(List<MemoryBlock> blocks) {
        for (MemoryBlock block : blocks) {
            System.out.println("Block: " + block.getObject() + " Size: " + block.getSize());
        }
        System.out.println("______________________________________________");
    }

}
