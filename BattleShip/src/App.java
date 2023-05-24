public class App {
    public static void main(String[] args) throws InterruptedException{
        Utilities.clrscrn();
        System.out.print("  ");
        border();
       grid(10,10);
        
    }

    
    
    

    
    public static void border() throws InterruptedException{
        for(int i = 0; i < 10; i++){
            System.out.print((i + 1) + " ");
        }
        for(int j = 0; j < 10; j++){
            if(j == 0){
                System.out.println("\nA");
            }
            else if(j == 1){
                System.out.println("B");
            }
            else if(j == 2){
                System.out.println("C");
            }
            else if(j == 3){
                System.out.println("D");
            }
            else if(j == 4){
                System.out.println("E");
            }
            else if(j == 5){
                System.out.println("F");
            }
            else if(j == 6){
                System.out.println("G");
            }
            else if(j == 7){
                System.out.println("H");
            }
            else if(j == 8){
                System.out.println("I");
            }
            else if(j == 9){
                System.out.println("J");
            }

        }

    
    }

    public static void grid(int row, int col){
        int[][] array = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}


