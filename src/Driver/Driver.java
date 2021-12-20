package Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Tree.Tree;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Tree<Integer> t = new Tree<Integer>();
		
		Scanner scan = new Scanner(new BufferedReader(new FileReader("nodes.txt")));
		
		while(scan.hasNext()) {
			t.add(scan.nextInt());
		}
		
		System.out.println();
	}
}
