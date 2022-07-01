
public class MyBuffer {
    private int bufferFreeSlots;
    private int bufferSize;
    private int[] buffer = new int[bufferSize];

    public int[] getBuffer(){
        return this.buffer;
    }

    public MyBuffer(int bufferSize){
        this.bufferSize = bufferSize;
        this.bufferFreeSlots = bufferSize;
        this.buffer = new int[bufferSize];
    }

    public synchronized int storesProduct(int value) {
        if (bufferFreeSlots > 0) {
            /* Product gets added to this.buffer */
            buffer[bufferSize-bufferFreeSlots] = value;
            bufferFreeSlots--;
            System.out.println("Synchronized store: " + value);
            return value;
        } else{
            System.out.println("Synchronized store: full buffer");
            return -1;
        }
    }

    public synchronized int consumesProduct() {
        if (bufferFreeSlots < bufferSize && bufferFreeSlots >= 0) {
            /* Product gets consumed from this.buffer */
            bufferFreeSlots++;
            System.out.println("Synchronized consume: " + buffer[bufferSize-bufferFreeSlots]);
            return buffer[bufferSize-bufferFreeSlots];
        }else{
            System.out.println("Synchronized consume: empty buffer");
            return -1;
        }
    }

}
