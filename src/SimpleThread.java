
public class SimpleThread extends Thread {
    protected MyBuffer myBuffer;

    public SimpleThread(String str, MyBuffer myBuffer) {
        super(str);
        this.myBuffer = myBuffer;
    }

    public void run() {
        if (getName() == "Customer") {
            for (int i = 0; i < 10; i++) {
                int result = myBuffer.consumesProduct();
                if(result == -1) System.out.println(getName() + "=> Round " + i + " --- consumed: empty" );
                else System.out.println(getName() + "=> Round " + i + " --- consumed: " + result);

                try {
                    sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {}
            }
            System.out.println("DONE! " + getName());
        } 
        else if (getName() == "Productor") {
            for (int i = 0; i < 10; i++) {
                int result = myBuffer.storesProduct((int) (Math.random() * 10));
                if(result == -1) System.out.println(getName() + "=> Round " + i + " --- produzed: full" );
                else System.out.println(getName() + "=> Round " + i + " --- produzed: " + result);
                try {
                    sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {}
            }
            System.out.println("DONE! " + getName());
        }
    }
}
