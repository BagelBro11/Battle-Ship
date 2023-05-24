public class App {
    public static void main(String[] args) throws InterruptedException{
        
        grid(10,10);
        
    }

    public static void grid(int row, int col){
        int[][] array = new int[row][col];
        Utilities.clrscrn();
        System.out.print("   ");
        for(int i = 0; i < 10; i++){
            System.out.print((i + 1) + "  ");
        }
        for(int i = 0; i < row; i++) {
            if(i == 0){
                System.out.print("\nA  ");
            }
            else if(i == 1){
                System.out.print("B  ");
            }
            else if(i == 2){
                System.out.print("C  ");
            }
            else if(i == 3){
                System.out.print("D  ");
            }
            else if(i == 4){
                System.out.print("E  ");
            }
            else if(i == 5){
                System.out.print("F  ");
            }
            else if(i == 6){
                System.out.print("G  ");
            }
            else if(i == 7){
                System.out.print("H  ");
            }
            else if(i == 8){
                System.out.print("I  ");
            }
            else if(i == 9){
                System.out.print("J  ");
            }
            for(int j = 0; j < col; j++){
                
                System.out.print(array[i][j] + "  ");

            }
            System.out.println();
        }
    }
}


