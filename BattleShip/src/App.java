public class App {
    public static void main(String[] args) throws Exception {
        prn("Hello, World!");
    }

    
    
    public static void prn(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(50);
        } // this loop gives the typewriter effect for by printing each character and then
          // thread.sleep to show pause
        System.out.println("\n"); // new line
    }


}
