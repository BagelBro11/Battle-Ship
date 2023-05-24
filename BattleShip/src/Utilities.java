import java.net.InterfaceAddress;
import java.util.concurrent.atomic.DoubleAdder;

public class Utilities {

	public static void main(String[] args) {
		// Testing the Utility methods
		clrscrn();

		// randomInt(1, 10);

		// String cardNumber = nameOfCard(12);
		// prn(cardNumber);

		// prn("It was fun on " + nameOfWeekday(6) + "!");

		// boolean number = isEven(98);
		// prn(number);

		// prn(celsiusToFarenheit(32));

		// prn(power(3.0, 3));

		prn(dieRoll(5));

		prn("You have " + quadraticDiscriminant(2.5, -4 / 3, -5) + " x-intercepts.");

		prn("You hypotenuse length is " + hypotenuse(15, 6) + " units");

		String fancyHello = fancify("Hello");
		prn(fancyHello);

		String red = redHello("Hello");
		prn(red);

		String colourString = colour(5, "What's up");
		prn(colourString);

		prn(max(2.5, 252.2, 8.33, 8.32));

		prn(isLeapYear(2020));

		printRightTri("*", 4);

		printBalancedTri("*", 4);
	}

	// random integer
	public static int randomInt(int low, int high) {
		return (int) ((high - low + 1) * Math.random() + low);
	}

	// print method
	public static <T> void prn(Object object) {
		System.out.println(object);
	}

	// clear screen
	public static void clrscrn() {
		System.out.print("\033[H\033[2J");
	}

	// name of card method
	public static String nameOfCard(int cardNumber) {
		String cardName;
		if (cardNumber >= 2 && cardNumber <= 10) {
			cardName = "" + cardNumber;
		} else if (cardNumber == 1) {
			cardName = "Ace";
		} else if (cardNumber == 11) {
			cardName = "Jack";
		} else if (cardNumber == 12) {
			cardName = "Queen";
		} else if (cardNumber == 13) {
			cardName = "King";
		} else {
			cardName = "Invalid Card";
		}
		return cardName;
	}

	// name of weekday
	public static String nameOfWeekday(int weekDayNum) {
		String dayName;
		if (weekDayNum == 0) {
			dayName = "Sunday";
		} else if (weekDayNum == 1) {
			dayName = "Monday";
		} else if (weekDayNum == 2) {
			dayName = "Tuesday";
		} else if (weekDayNum == 3) {
			dayName = "Wednesday";
		} else if (weekDayNum == 4) {
			dayName = "Thursday";
		} else if (weekDayNum == 5) {
			dayName = "Friday";
		} else if (weekDayNum == 6) {
			dayName = "Saturday";
		} else {
			dayName = "Invalid Day";
		}
		return dayName;
	}

	// is the number even
	public static boolean isEven(int evenTest) {
		if (evenTest % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// celsius to farenheit conversion
	public static double celsiusToFarenheit(double celsius) {
		double farenheit = (celsius * 1.8 + 32);
		return farenheit;
	}

	// dice roll return sum
	public static int dieRoll(int numRolls) {
		int rollSum = 0;
		for (int i = 0; i < numRolls; i++) {

			int roll = randomInt(1, 6);
			rollSum = rollSum + roll;
		}
		return rollSum;

	}

	// base to the power of method
	public static double power(double base, int exponent) {
		for (int i = 1; i < exponent; i++) {
			base = base * base;
		}
		return base;
	}

	// quadratic discriminant number of 0's method
	public static int quadraticDiscriminant(double a, double b, double c) {
		int discriminant = (int) ((b * b) - 4 * a * c);
		if (discriminant == 0) {
			return 1;
		} else if (discriminant > 0) {
			return 2;
		} else {
			return 0;
		}
	}

	// find the hypotenuse of a right angle triangle
	public static double hypotenuse(double a, double b) {
		double hypotenuse = (a * a) + (b * b);
		hypotenuse = Math.sqrt(hypotenuse);
		return hypotenuse;

	}

	public static String fancify(String string) {
		return "3>" + string + "<3";
	}

	public static String redHello(String input) {
		return "\u001B[31m" + input + "\u001B[0m";
	}

	public static String colour(int colourCode, String input) {
		if (colourCode == 0) {
			return "\u001B[31m" + input + "\u001B[37m";
		} else if (colourCode == 1) {
			return "\u001B[36m" + input + "\u001B[37m";
		} else if (colourCode == 2) {
			return "\u001B[35m" + input + "\u001B[37m";
		} else if (colourCode == 3) {
			return "\u001B[34m" + input + "\u001B[37m";
		} else if (colourCode == 4) {
			return "\u001B[33m" + input + "\u001B[37m";
		} else if (colourCode == 5) {
			return "\u001B[32m" + input + "\u001B[37m";
		} else if (colourCode == 6) {
			return "\u001B[30m" + input + "\u001B[37m";
		} else {
			return input;
		}
	}

	public static String colour(int colourCode, double input) {
		if (colourCode == 0) {
			return "\u001B[31m" + input + "\u001B[37m";
		} else if (colourCode == 1) {
			return "\u001B[36m" + input + "\u001B[37m";
		} else if (colourCode == 2) {
			return "\u001B[35m" + input + "\u001B[37m";
		} else if (colourCode == 3) {
			return "\u001B[34m" + input + "\u001B[37m";
		} else if (colourCode == 4) {
			return "\u001B[33m" + input + "\u001B[37m";
		} else if (colourCode == 5) {
			return "\u001B[32m" + input + "\u001B[37m";
		} else if (colourCode == 6) {
			return "\u001B[30m" + input + "\u001B[37m";
		} else {
			return "" + input;
		}
	}

	public static double max(double a, double b, double c, double d) {
		double largest = a;

		if (b > largest) {
			largest = b;
		}

		if (c > largest) {
			largest = c;
		}

		if (d > largest) {
			largest = d;
		}
		return largest;
	}

	public static boolean isLeapYear(int year) {

		if (year > 2020) {
			while (year > 2020) {
				year = year - 4;
			}
			if (year == 2020) {
				return true;
			} else {
				return false;
			}
		} else {
			while (year < 2020) {
				year = year + 4;
			}
			if (year == 2020) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static void repeatPrint(String string, int times) {
		for (int i = 0; i < times; i++) {
			System.out.print(string);
		}
	}

	public static void printRightTri(String icon, int lines) {
		for (int i = 0; i < lines; i++) {
			repeatPrint(icon, i + 1);
			System.out.println();
		}

	}

	public static void printBalancedTri(String icon, int lines) {
		for (int i = 1; i <= lines; i++) {
			// Print the spaces before the symbol
			for (int j = lines - i; j >= 1; j--) {
				System.out.print(" ");
			}
			// Print the symbol
			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print(icon);
			}
			// Move to the next line
			System.out.println();
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

	
	

	
}
