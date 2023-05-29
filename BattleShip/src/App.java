import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        // creating the array in main
        int row = 10;
        int col = 10;
        int[][] grid = new int[row][col];

        // done to check weather to still run while loop
        boolean done = false;
        Utilities.clrscrn();

        // instruction for user
        Utilities.prt("----------BATTLESHIP----------");
        music("intro");//example of calling music method
        Utilities.prt(
                "Please input cooridinate you'd like to choose, starting with the letter, space, and then the number.");
        Utilities.prt("If you hit a boat it is a 2 and a sound will play, if you miss it is a 1!");
        Utilities.prt("Be careful...you only have 40 guesses to fully destroy all 5 boats!");
        Utilities.prt("The boats vary in length, 5, 4, 3, 3, and 2 units long!");

        // counter for how many tries user has taken
        int i = 0;

        // game loop that is checked with done boolean
        while (!done) {
            // uses grid method to print the map
            grid(grid, 10, 10);

            // gets user input and splits it into an array, a letter and a number in one
            // line
            System.out.print("Enter: ");
            String input = in.nextLine();
            String[] string = input.split(" ");
            string[0] = string[0].toLowerCase();

            // adds the input to the change method
            change(grid, string[0], Integer.parseInt(string[1]));

            // uses win method to check if won and ends game, if not adds a try
            if (win(grid)) {
                // major C chord plays for a win
                music("major");
                Utilities.prt("Congratulations! You have won!");
                done = true;
            } else {
                i++;
                Utilities.prt("You have used " + i + " attemps!");
            }

            // if the tries surpass 50 they lose and game is over
            if (i > 39) {
                // D minor chord plays for loss
                music("minor");
                Utilities.prt("You have lost and used too many tries. Better luck next time!");
                done = true;
            }
        }
    }

    /**
     * grid method is for printing the original grid with numbers and letters
     * @param array is the array that will be printed by the method initialized in
     *              main
     * @param row   the "y" value of the array used in the for loop
     * @param col   the "x" value of the array used in the inner "j" for loop
     */
    public static void grid(int[][] array, int row, int col) {
        System.out.print("   ");
        // prints numbers above the array for x cooridinate tracking
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "  ");
        }

        // prints letters on the y axis of array for y cooridinate tracking
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                System.out.print("\nA  ");
            } else if (i == 1) {
                System.out.print("B  ");
            } else if (i == 2) {
                System.out.print("C  ");
            } else if (i == 3) {
                System.out.print("D  ");
            } else if (i == 4) {
                System.out.print("E  ");
            } else if (i == 5) {
                System.out.print("F  ");
            } else if (i == 6) {
                System.out.print("G  ");
            } else if (i == 7) {
                System.out.print("H  ");
            } else if (i == 8) {
                System.out.print("I  ");
            } else if (i == 9) {
                System.out.print("J  ");
            }
            // after letters are printed the rest of numbered array is printed
            for (int j = 0; j < col; j++) {

                System.out.print(array[i][j] + "  ");

            }
            System.out.println();
        }
    }

    /**
     * change method modifies the array to user specification
     * @param array  array being modified from main
     * @param letter the letter or "y" coordinate specified
     * @param number the number or "x" coordinate specified
     */
    public static void change(int[][] array, String letter, int number) {
        // able to convert letters into numbers using ASCII table
        int row = letter.charAt(0) - 97;

        // depending on the "hit" coordinates they will change to 2 if number and letter
        // are correct
        if (letter.equals("a")) {
            if (number == 5) {
                array[row][4] = 2;
                // if a boat was hit it will play a sound
                MusicNotes.playNote("A4", 0.5);
            } else if (number == 9) {
                array[row][8] = 2;
                MusicNotes.playNote("A4", 0.5);
            } else if (number == 10) {
                array[row][9] = 2;
                MusicNotes.playNote("A4", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else if (letter.equals("b")) {
            if (number == 1) {
                array[row][0] = 2;
                MusicNotes.playNote("B4", 0.5);
            } else if (number == 5) {
                array[row][4] = 2;
                MusicNotes.playNote("B4", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else if (letter.equals("c")) {
            if (number == 1) {
                array[row][0] = 2;
                MusicNotes.playNote("C5", 0.5);
            } else if (number == 5) {
                array[row][4] = 2;
                MusicNotes.playNote("C5", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else if (letter.equals("d")) {
            if (number == 1) {
                array[row][0] = 2;
                MusicNotes.playNote("D5", 0.5);
            } else if (number == 5) {
                array[row][4] = 2;
                MusicNotes.playNote("D5", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else if (letter.equals("f")) {
            if (number == 8) {
                array[row][7] = 2;
                MusicNotes.playNote("F5", 0.5);
            } else if (number == 9) {
                array[row][8] = 2;
                MusicNotes.playNote("F5", 0.5);
            } else if (number == 7) {
                array[row][6] = 2;
                MusicNotes.playNote("F5", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else if (letter.equals("i")) {
            if (number == 4) {
                array[row][3] = 2;
                MusicNotes.playNote("G5", 0.5);
            } else if (number == 5) {
                array[row][4] = 2;
                MusicNotes.playNote("G5", 0.5);
            } else if (number == 6) {
                array[row][5] = 2;
                MusicNotes.playNote("G5", 0.5);
            } else if (number == 7) {
                array[row][6] = 2;
                MusicNotes.playNote("G5", 0.5);
            } else if (number == 8) {
                array[row][7] = 2;
                MusicNotes.playNote("G5", 0.5);
            } else {
                array[row][number - 1] = 1;
            }
        } else { // if it is not a hit it turns into a one ("else miss" also found above for the
                 // specified letters )
            array[row][number - 1] = 1;
        }
    }

    /**
     * win method checks if the user has hit all of the boats
     * @param array the array checked for all the hits
     * @return //a true of false if all conditions satisfied
     */
    public static boolean win(int[][] array) {
        // one boolean for each boat
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        // if coordinates of each boat are hit it satisfies it's paralell boolean
        if (array[0][8] == 2 && array[0][9] == 2) {
            one = true;
        }
        if (array[0][4] == 2 && array[1][4] == 2 && array[2][4] == 2 && array[3][4] == 2) {
            two = true;
        }
        if (array[1][0] == 2 && array[2][0] == 2 && array[3][0] == 2) {
            three = true;
        }
        if (array[5][7] == 2 && array[5][8] == 2 && array[5][6] == 2) {
            four = true;
        }
        if (array[8][3] == 2 && array[8][4] == 2 && array[8][5] == 2 && array[8][6] == 2 && array[8][7] == 2) {
            five = true;
        }
        // all boats are satisfies returns true for win
        if (one && two && three && four && five) {
            return true;
        } else {// if not then return false
            return false;
        }
    }

    /**
     * this method de-clutters code and plays music depending on input
     * @param key indicates what tune will be played(major, minor, intro)
     */
    public static void music(String key) {
        if (key == "minor") {
            MusicNotes.playNote("D4", 0.33);
            MusicNotes.playNote("F4", 0.33);
            MusicNotes.playNote("A4", 0.33);
            MusicNotes.playNote("F4", 0.33);
            MusicNotes.playNote("D4", 1);
            MusicNotes.playNote("D4", 0.33);
        } else if (key == "major") {
            MusicNotes.playNote("C4", 0.33);
            MusicNotes.playNote("E4", 0.33);
            MusicNotes.playNote("G4", 0.33);
            MusicNotes.playNote("E4", 0.33);
            MusicNotes.playNote("C4", 1);
            MusicNotes.playNote("C4", 0.33);
        } else if (key == "intro") {
            MusicNotes.playNote("C5", 0.5);
            MusicNotes.playNote("C5", 0.25);
            MusicNotes.playNote("C5", 0.25);
            MusicNotes.playNote("G5", 0.75);
            MusicNotes.playNote("G5", 0.25);
        }
    }
}
