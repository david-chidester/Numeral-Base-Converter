/*  <Numeral Base Converter>
*   Copyright (C) <2019>>  <David N. Tishkoff Chidester>
*
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*   
*	This program takes a numberal in bases 2 through 16 and converts it into a user specified number base
*
*  	Example:
*		Input: numeral="42" input_base=10, output_base=2
*		Output: "101010"
*
*		Input: numeral="11110" input_base=2, output_base=16
*		Output: 1E
*
*  	License:
*  		This program and its source code may be freely used by anyone for any purpose,
*		but you MUST sight David Chidester as its original author.
*       	You may NOT plagiarize this program and claim it as your own work.
*	  	You may NOT sell this program or charge users for use or possession of it.
*		You May use it for commercial purposes so long as it is part of a larger commercial product
*       	and you are not selling just this program with minor changes and no added work of your own.
*  		See the GPL https://www.gnu.org/licenses/
*
*	TLDR:
*		It converts numeral bases. It's free but don't plagiarize it. Have Fun! ;)
*/

public class NumeralBaseConverter {

	public static void main(String args[]) throws java.io.IOException {
		if (args.length < 3)
			System.out.println("error: too few arguements given");
		else if (args.length > 3)
			System.out.println("error: too many arguements given");
		// testing for bad numeral input beginning with 0s such as 005
		else if (args[0].charAt(0) == '0'){
			if (args[0].length() > 1)
				System.out.println("error: numeral cannot begin with 0");
			else System.out.println("0");
		}

		else {
			boolean validArgs = true;
			int inputBase = 0;
			int outputBase = 0;
			// maing sure bases are numeric values
			try {
				inputBase = Integer.parseInt(args[1]);
				outputBase = Integer.parseInt(args[2]);
			} catch (Exception e) {
				System.out.println("error: base must be an integer");
				validArgs = false;
			}

			// converting bases from strings to ints
			if ((inputBase < 2 || inputBase > 16 || outputBase < 2 || outputBase > 16) && validArgs) {
				System.out.println("error: base must be between 2 and 16 inclusive");
				validArgs = false;
			}

			// making sure that numeral input is valid
			try {
				Integer.parseInt(args[0], inputBase);
			} catch (Exception e) {
				if (validArgs) {
					System.out.println("error: \"" + args[0] + "\" is an invalid numeral format for base " + inputBase);
				}
				validArgs = false;
			}

			// printing result
			if (validArgs)
				System.out.println(convertNumBase(args[0], inputBase, outputBase));
		}
	}

	// only use with bases x such that 2 <= x <= 16
	protected static String convertNumBase(String numeral, int inputBase, int outputBase) {
		int total = 0;
		numeral = numeral.toUpperCase(); // don't have to worry about lower case chars
		char numeralArray[] = numeral.toCharArray();
		int asciiArray[] = new int[numeralArray.length];
		// converting ascii chars to ints
		for (int i = 0; i < numeralArray.length; i++)
			asciiArray[i] = asciiToInteger(numeralArray[i]);
		// converting to input base using horner's method
		for (int i = asciiArray.length - 1; i >= 0; i--)
			total = (total * inputBase) + asciiArray[i];
		// for bug when numeral ends in a 0
		int isZero = numeralArray.length - 1;
		while (numeralArray[isZero] == '0' && isZero > 0) {
			total *= inputBase;
			isZero--;
		}
		StringBuilder outputString = new StringBuilder();
		// convert to output base
		while (total > 0) {
			outputString.append(integerToAscii(total % outputBase));
			total /= outputBase;
		}
		return outputString.reverse().toString();
	}

	// Converts an ascii char to an integer
	// Works with bases 2-16
	private static int asciiToInteger(char asciiChar) {
		int asciiInt = (int) asciiChar;
		if (asciiInt > 47 && asciiInt < 58) // 48 == '0' in ascii
			asciiInt -= 48;
		else if (asciiInt > 64 && asciiInt < 71)
			asciiInt -= 55;
		else
			System.out.println("error: bad input");
		return asciiInt;
	}

	// Converts an ascii integer to an ascii char
	// Works with bases 2-16
	private static char integerToAscii(int asciiInt) {
		char asciiChar;
		if (asciiInt < 10)
			asciiChar = (char) (asciiInt + 48); // 48 == '0' in ascii
		else
			asciiChar = (char) (asciiInt + 55); // 10 + 55 = 65 == A in ascii
		return asciiChar;
	}
}
