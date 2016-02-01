package ua.goit.andre.lab8;

import java.util.ArrayList;
import java.util.LinkedList;

import ua.goit.andre.lab3.file.File;
import ua.goit.andre.lab3.flower.Flower;
import ua.goit.andre.lab3.music.MusicInstrument;

public class ObjectsList {
	private ArrayList <File> fileList;
	private ArrayList <Flower> flowerList;
	private ArrayList <MusicInstrument> musicList;
	
	public ObjectsList() {
		super();
		fileList=new ArrayList<>();
		flowerList=new ArrayList<>();
		musicList=new ArrayList<>();
	}

	public void add(Object addedObject) {
		if (addedObject instanceof File) {
			fileList.add((File)addedObject);
		}
		if (addedObject instanceof Flower) {
			flowerList.add((Flower)addedObject);
		}
		if (addedObject instanceof MusicInstrument) {
			musicList.add((MusicInstrument)addedObject);
		}
	}
	
	private int getIndex(Object addedObject, ArrayList list) {
		if (list.isEmpty()) return 0; else {
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).toString().compareTo(addedObject.toString()) > 0) return i;
			}
			return list.size();
		}
	}

	public void addSorted(Object addedObject) {
		if (addedObject instanceof File) {
			fileList.add(getIndex(addedObject, fileList), (File) addedObject);
		}
		if (addedObject instanceof Flower) {
			flowerList.add(getIndex(addedObject, flowerList), (Flower)addedObject);
		}
		if (addedObject instanceof MusicInstrument) {
			musicList.add(getIndex(addedObject, musicList), (MusicInstrument)addedObject);
		}
	}

	public LinkedList<String> getList() {
		 
		LinkedList<String> resultList = new LinkedList<>();
		
		final String OUT_FORMAT = "| %-12s ";
		
		StringBuilder str = new StringBuilder().append("| FileList              ");
		for (File f : fileList) {
			str.append(String.format(OUT_FORMAT, f.toString()));
		}
		str.append("|");
		resultList.add(str.toString());
		
		str = new StringBuilder().append("| Flower List           ");
		for (Flower f : flowerList) {
			str.append(String.format(OUT_FORMAT, f.toString()));
		}
		str.append("|");
		resultList.add(str.toString());
		
		str = new StringBuilder().append("| Music Instrument List ");
		for (MusicInstrument m : musicList) {
			str.append(String.format(OUT_FORMAT, m.toString()));
		}
		str.append("|");
		resultList.add(str.toString());
		
		return resultList;
	}

}
