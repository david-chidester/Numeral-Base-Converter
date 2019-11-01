# Numeral-Base-Converter
A Java program to convert numerals to differnt bases such as binary, decimal, octal, and hexadecimal

# Dependancies
[Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
the most recent Java Development Kit (JDK)

# Installaton (Linux or Mac)
Download or clone the repo and cd into the directory
```
git clone https://github.com/dchid/Numeral-Base-Converter.git
cd Numeral-Base-Converter
javac NumeralBaseConverter.java
```

# Use
This program takes a numberal in bases 2 through 16 and converts it into a user specified number base.
Before the program is used, it must be compiled.
The syntax for using the program is "java NumeralBaseConverter numeral input_base output_base".
* Example 1:
 	 * Input: numeral="42" input_base=10, output_base=2
 	 * Output: "101010"
```java java NumeralBaseConverter 42 10 2```

* Example 2:
	* Input: numeral="11110" input_base=2, output_base=16
	* Output: 1E
```java java NumeralBaseConverter 2 10 16```

Base 16 input if case insensitive so 'f' and 'F' are both the same as far as the program's input is concerned
