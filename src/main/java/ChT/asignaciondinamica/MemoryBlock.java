package ChT.asignaciondinamica;

import java.util.List;

public class MemoryBlock {
    private int size;
    private String object;

    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public boolean IsFree() {
        return object == null;
    }



}
