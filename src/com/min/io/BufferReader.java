package com.min.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BufferReader {

	public static void main(String[] args) {

		BufferedReader br = null;
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void test2() throws IOException {
		int bufferSize = 512;

		BufferedReader reader = new BufferedReader(new FileReader("C:\\testing.txt"));
		try {
			char[] charBuffer = new char[bufferSize];
			int numberOfChars;
			do {
				numberOfChars = reader.read(charBuffer, 0, bufferSize);
			} while (numberOfChars >= 0);
		} finally {
			reader.close();
		}
	}

}
