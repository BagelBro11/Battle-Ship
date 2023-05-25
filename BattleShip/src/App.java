import java.util.Scanner;
public class App {
    public static void main(String[] args) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        int row = 10;
        int col = 10;
        int[][] grid = new int[row][col];
        boolean done = false;
        while(!done){
        grid(grid, 10,10);
        Utilities.prt("Please input cooridinate you'd like to flip, starting with the letter, space, and then the number.");
        Utilities.prt("If you hit a boat it is a 1, if it is a miss it is a 3!");
        System.out.print("Enter: ");
        String input = in.nextLine();
        String[] string = input.split(" ");
        string[0] = string[0].toLowerCase();
        
        change(grid, string[0], Integer.parseInt(string[1]));

        }
    }

    public static void grid(int[][]array, int row, int col){
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

    public static void change(int[][] array, String letter, int number){
        int row = letter.charAt(0) - 97;
        if(letter.equals("a")){
            if(number == 5){
                array[row][4] = 1;
            }
            else if(number == 9){
                array[row][8] = 1;
            }
            else if(number == 1){
                array[row][9] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else if(letter.equals("b")){
            if(number == 1){
                array[row][0] = 1;
            }
            else if(number == 5){
                array[row][4] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else if(letter.equals("c")){
            if(number == 1){
                array[row][0] = 1;
            }
            else if(number == 5){
                array[row][4] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else if(letter.equals("d")){
            if(number == 1){
                array[row][0] = 1;
            }
            else if(number == 5){
                array[row][4] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else if(letter.equals("f")){
            if(number == 8){
                array[row][7] = 1;
            }
            else if(number == 9){
                array[row][8] = 1;
            }
            else if(number == 10){
                array[row][9] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else if(letter.equals("i")){
            if(number == 4){
                array[row][3] = 1;
            }
            else if(number == 5){
                array[row][4] = 1;
            }
            else if(number == 6){
                array[row][5] = 1;
            }
            else if(number == 7){
                array[row][6] = 1;
            }
            else if(number == 8){
                array[row][7] = 1;
            }
            else{
                array[row][number] = 3;
            }
        }
        else{
            array[row][number] = 3;
        }
    }

    public static boolean win()
}


