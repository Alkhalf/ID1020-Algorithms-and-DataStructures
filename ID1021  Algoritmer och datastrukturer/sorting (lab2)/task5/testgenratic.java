package task5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class testgenratic {
public static void main (String []args) throws IOException {
	
	Random rand = new Random();
	File test = new File("/Users/ahmed/Desktop/Eclipse/Labb2/data.txt");
	int [] array = new int [10000];

	FileWriter file = new FileWriter("/Users/ahmed/Desktop/Eclipse/Labb2/data.txt");
	for (int i=0; i<array.length; i++)
		file.write(" "+ rand.nextInt(1000));
	file.close();
	
	
	/*int a=0;
	Scanner reader = new Scanner (test);
	while (reader.hasNextLine()) {
		array[a]=reader.nextInt();
		a++;	
	}
	reader.close();
	
	for (int s=0; s<array.length; s++)
		System.out.print("["+ array[s]+ "]");*/
	
	
}
}
