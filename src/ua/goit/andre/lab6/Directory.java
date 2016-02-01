package ua.goit.andre.lab6;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Directory extends DirectoryItem{
	HashMap <String, DirectoryItem> entries;

	public Directory (String name) {
		super(name);
		entries=new HashMap <>();
	}
	
	public void  add(DirectoryItem name){
		if (entries.containsKey(name.getName())) {
			try {
				throw new FileAlreadyExistException(name.getName());
			} catch (FileAlreadyExistException e) {
				System.out.println("Error!!! File or Directory " + e.getFileName() + " already exists");
			}
		} else {
			entries.put(name.getName(), name);			
		}
	}
	
	
	public void  del(String name) {
		DirectoryItem toDel=entries.get(name);
		if (null==toDel) try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			System.out.println("File or directory not Found!!!");
			
			/* For  NullPointerException
			System.out.println(toDel.getName());
			*/
			
		} else {
			if (Directory.class.equals(toDel.getClass())) {
				Directory toDelDir=(Directory)toDel;
				if (toDelDir.entries.isEmpty()) {
					entries.remove(name);
				}
				else {
					try {
						throw new DirectoryNotEmptyException(toDelDir.getName());
					} catch (DirectoryNotEmptyException e) {
						System.out.println("Error!!! Directory " + e.getFileName() + " not empty");
					}
				}
			} else entries.remove(name);
		}
	}
	
	public void showDirectory(String prefix) {
		for (Entry<String, DirectoryItem> entry: entries.entrySet() ) {
			DirectoryItem value = entry.getValue();

			System.out.println(prefix + value.getName());
			
			if (Directory.class.equals(value.getClass())) { 
				Directory dir = (Directory)value;
				dir.showDirectory(prefix + "\\----");
			}
		}		
	}

}
