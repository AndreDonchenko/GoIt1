package ua.goit.andre.lab10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import ua.goit.andre.lab9.*;

public class FileEncoder {

	public static void showHelp() {
		System.out.println("");
		System.out.println("Usage: FileEncoder [SrcFile] [DstFile] [Code]");
		System.out.println("[Code] is a value between 1-90 for encoding, and from (-1)-(-90) for decoding");
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("File encoder/decoder Program!");
		if (args.length!=3) {
			showHelp();
			System.exit(0);
		}
		String srcFileName=args[0];
		String dstFileName=args[1];
		int codeShift=0;
		try {
			codeShift=Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			showHelp();
			System.exit(0);
		}
	
		BufferedReader inputStream=null;
		BufferedWriter outputStream=null;
		try {
			inputStream = new BufferedReader(new FileReader(srcFileName));
			outputStream = new BufferedWriter(new FileWriter(dstFileName));
			int c;
			while((c=inputStream.read())!=-1) {
				outputStream.write(Caesar.encodeChar((char)c, codeShift));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!!! File " + srcFileName + " not found!");
		}
		finally {
			if (inputStream!=null) inputStream.close();
			if (outputStream!=null) outputStream.close();
			System.out.println("Done.");
		}	
	}
}
