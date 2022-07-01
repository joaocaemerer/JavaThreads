public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("---Testing Lock Using Threads---\n");
        int bufferSize = 3;
        String productor = "Productor";
        String costumer = "Customer";

        MyBuffer myBuffer = new MyBuffer(bufferSize);

        new SimpleThread(costumer, myBuffer).start();
        new SimpleThread(productor, myBuffer).start();
    }
}
