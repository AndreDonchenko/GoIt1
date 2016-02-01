package ua.goit.andre.lab9;


import java.util.LinkedList;

import ua.goit.andre.lab3.file.*;
import ua.goit.andre.lab3.flower.*;
import ua.goit.andre.lab3.music.*;
import ua.goit.andre.lab8.ObjectsList;

public class Runner {
	private static final int ENCODE_SHIFT = 20;

	public static void main(String[] args) {
		ObjectsList objectsList=new ObjectsList();
		objectsList.add(new TextFile());
		objectsList.add(new ImageFile());
		objectsList.add(new AudioFile());
		
		objectsList.add(new Rose());
		objectsList.add(new Aster());
		objectsList.add(new Tulip());
		objectsList.add(new Chamomile());
		
		objectsList.add(new Piano());
		objectsList.add(new Trumpet());
		objectsList.add(new Guitar());

		LinkedList<String> encodedList=new LinkedList<>();
		
		System.out.println("*** Source Objects list: ***");
		for (String s : objectsList.getList()) {
			System.out.println(s);
			encodedList.add(Caesar.encode(s.toUpperCase(), ENCODE_SHIFT));
		}
		System.out.println();
		
		System.out.println("*** Encoded Objects list: ***");
		encodedList.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*** Decoded Objects list: ***");
		for (String s : encodedList) {
			System.out.println(Caesar.decode(s.toUpperCase(),ENCODE_SHIFT));
		}
		

		
/*
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		String str2=Caesar.encode(str, ENCODE_SHIFT);
		String str3=Caesar.decode(str2, ENCODE_SHIFT);
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
*/
	}
}