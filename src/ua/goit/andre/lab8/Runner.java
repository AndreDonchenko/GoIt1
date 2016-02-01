package ua.goit.andre.lab8;

import ua.goit.andre.lab3.file.*;
import ua.goit.andre.lab3.flower.*;
import ua.goit.andre.lab3.music.*;

public class Runner {
	static ObjectsList objectsList;
	
	
	public static void showList() {
		objectsList.getList().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		System.out.println("*** Objects list: ***");
		objectsList=new ObjectsList();
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

		showList();
		
		System.out.println();
		System.out.println("*** Soted Objects list: ***");
		objectsList=new ObjectsList();
		
		objectsList.addSorted(new TextFile());
		objectsList.addSorted(new AudioFile());
		objectsList.addSorted(new ImageFile());
		
		objectsList.addSorted(new Rose());
		objectsList.addSorted(new Aster());
		objectsList.addSorted(new Chamomile());
		objectsList.addSorted(new Tulip());
		
		objectsList.addSorted(new Piano());
		objectsList.addSorted(new Guitar());
		objectsList.addSorted(new Trumpet());

		showList();
	}
}
