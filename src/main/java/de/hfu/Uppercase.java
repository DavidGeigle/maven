/**
 * A Programm that changes all characters to Uppercase
 *
 * @autor David Geigle
 * @version 1.0
 */

package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Uppercase {
	/**
	 * Main
	 * Reads Lines via BufferReader and changes them to Uppercase
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		System.out.println(s.toUpperCase());
	}

}
