package Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Tree.Tree;

/**
 * Driver class for red black tree implementation. Defaults to Integers but any Comparable class can be used.
 * @author Jeffrey Tran
 *
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Tree<Integer> t = new Tree<Integer>();
		
		Scanner scan = new Scanner(new BufferedReader(new FileReader("nodes.txt")));
		
		while(scan.hasNext()) {
			t.add(scan.nextInt());
		}
		
		System.out.println("Finished");
		System.out.println(t);
	}
}
