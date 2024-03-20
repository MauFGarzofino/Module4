package assignments.dynamicmemory;

public class MemoryBlock {
    private int size;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    private String object;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean IsFree()
    {
        return object==null;
    }
}