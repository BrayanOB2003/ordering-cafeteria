package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public final static String SEPARATOR = " ";
	
	public static double[] transforLine(String separator, String line) {
		
		String[] arrayString = line.split(separator);
		double[] arrayInteger = new double[arrayString.length];
		
		for(int i = 0; i < arrayString.length; i++) {
			arrayInteger[i] = Double.parseDouble(arrayString[i]);
		}
		
		return arrayInteger;
	}
	
	
	public static String sortAndPrint(double[] tests){
		
		String tidy = "";
		double past = 0;
		double exchanges = 0;
		double average = 0;
		
		for(int i= 1; i < tests.length; i++) {
			past++;
			for(int j = 0; j < tests.length - i; j++) {
				if(tests[j] > tests[j+1]) {
					double temp = tests[j];
					tests[j] = tests[j+1];
					tests[j+1] = temp;
					exchanges++;
				}
			}
		}
		
		average = (double) Math.round((past/exchanges)*100d)/100d;
		tidy += average + " - ";
		
		for(int i = 0; i < tests.length; i++) {
			tidy += tests[i] + " ";
		}
		tidy += "\n";
		
		return tidy;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cases = Integer.parseInt(br.readLine());  
		String tidy ="";
		String line = "";
		double[] tests;
		
		int cont = 0;
		
		while(cont < cases) {
			
			line = br.readLine();
			
			tests = transforLine(SEPARATOR, line);
			tidy += sortAndPrint(tests);
			
			cont++;
		}
		
		bw.write(tidy);
		
		br.close();
		bw.close();
	}

}
