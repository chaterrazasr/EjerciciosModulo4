package ChT.asignaciondinamica;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        IMemoryAllocator memory = new MemoryAllocator(1000, new FirstFitAlgorithm());
        IMemoryAllocator memory2 = new MemoryAllocator(1000, new BestFitAlgorithm());
        IMemoryAllocator memory3 = new MemoryAllocator(1000, new WorstFitAlgorithm());

        allocateData(memory);
        allocateData(memory2);
        allocateData(memory3);

        display.showMemory(memory.getMemoryBlocks());
        display.showMemory(memory2.getMemoryBlocks());
        display.showMemory(memory3.getMemoryBlocks());
    }

    private static void deallocateData(IMemoryAllocator memory) {
        memory.deallocate("C");
        memory.deallocate("A");
    }

    private static void allocateData(IMemoryAllocator memory) {
        memory.allocate("A", 50);
        memory.allocate("B", 150);
        memory.allocate("C", 250);
        memory.allocate("D", 350);
        memory.allocate("E", 450);
        memory.allocate("F", 550);
    }
}
