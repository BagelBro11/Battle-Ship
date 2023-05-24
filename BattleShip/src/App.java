public class App {
    public static void main(String[] args) throws InterruptedException{
        Utilities.clrscrn();
        for(int i = 0; i < 10; i++){
            prt(i + " ");
        }
    }

    
    
    public static void prt(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(50);
        } // this loop gives the typewriter effect for by printing each character and then
          // thread.sleep to show pause
        System.out.println("\n"); // new line
    }

    
    public static String[][] grid() throws InterruptedException{
        for(int i = 0; i < 10; i++){
            prt(i);
        }
        int row = 10;
        int col = 10;
        
    
    
    }
}
