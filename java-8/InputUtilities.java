package com.act3;
import org.apache.commons.lang3.RandomUtils;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class InputUtilities{

	Scanner scan = new Scanner(System.in);

	public String getStringInput(){
		String textToReturn;
		boolean hasSpace = false;
		boolean isEmpty = false;

		do {
			textToReturn = scan.nextLine();
			isEmpty = textToReturn.isEmpty();

			if (isEmpty) {
				printLine(" No value entered");
			}

		} while (isEmpty);

		return textToReturn;
	}

	public String getHorseInput(String message){
		printLine(message);

		String textToReturn;
		textToReturn = scan.nextLine();
		if (textToReturn.isEmpty()) {
			textToReturn = null;
		}

		return textToReturn;
	}

	public String getStringInput(String message){
		String textToReturn;
		boolean hasSpace=false;
		boolean isEmpty=false;

		printLine(message);

		do{
			textToReturn = scan.nextLine();
			isEmpty = textToReturn.isEmpty();

			if (isEmpty) {
				printLine(" No value entered");
			}

		} while (isEmpty);

		return textToReturn;
	}

	public int getIntegerInput(String message) throws NumberFormatException{
        boolean valid = true;
        int input = 0;

		do {
            printLine(message);

			try {
				input = Integer.valueOf(scan.nextLine());
				valid = true;
			} catch (NumberFormatException e) {
				printLine("Invalid Input");
				valid = false;
			}
            if (input < 2) {
                valid = false;
                printLine("Input cannot be less than 2");
            }


        } while (!valid);
        return input;
    }

	public int getIntegerInputWithoutZeroes(String message) throws NumberFormatException{
        boolean valid = true;
        int input = 0;
        do {
            printLine(message);

			try {
				input = Integer.valueOf(scan.nextLine());
				valid = true;
			} catch (NumberFormatException e){
				printLine("Invalid Input");
				valid = false;
			}

            if (input <= 0) {
                valid = false;
                printLine("Input cannot be negative value or zero");
            }

        } while (!valid);
        return input;
    }

	public int getIntegerInput(int maximum) throws NumberFormatException{
        boolean valid = true;
        int input = 0;

        do {
			try {
				input = Integer.valueOf(scan.nextLine());
	            valid = true;
			} catch (NumberFormatException e){
				printLine("Invalid Input");
				valid = false;
			}

            if(input <= 0 || input > maximum) {
                valid = false;
                printLine("Only accepts values 1-" + String.valueOf(maximum));
            }

        } while (!valid);

        return input;
    }

	public int randomNumber(int min, int max){
		return RandomUtils.nextInt(min, max + 1);
	}

	public void printLine(String message){
		System.out.println(String.valueOf(message));
	}

	public void printLine(int message){
		System.out.println(String.valueOf(message));
	}

	public void printText(String message){
		System.out.print(String.valueOf(message));
	}

	public void printText(int message){
		System.out.print(String.valueOf(message));
	}

	public int toInt(String input){
		return Integer.valueOf(input);
	}

	public String toString(int number){
		return String.valueOf(number);
	}


}
