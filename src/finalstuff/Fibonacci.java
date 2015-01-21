package finalstuff;

import TerminalIO.*;

public class Fibonacci {

	public static void main(String[] args) {
		
		KeyboardReader read = new KeyboardReader();
		int result;
		System.out.println("Enter a number to calculate fibonacci to: ");
		int value = read.readInt();
		while(true){
			if (value > 0 && value < 16){
				result = fibonacci(value);
				break;
			}
			else {
				System.out.println("Value incorrect please enter a number between 1 and 15");
				value = read.readInt();
			}
		}
		System.out.println("Value of fibonaci " + result);
	}
	public static int fibonacci(int value){
		if (value <= 2) return 1;
		else return fibonacci(value - 1) + fibonacci(value - 2);
	}

}
