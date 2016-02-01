package ua.goit.andre.lab6;

public class DirectoryRunner {
	
	public static void main(String[] args) {
		Directory rootDirectory=new Directory("\\");
		rootDirectory.add(new File("ReadMe.txt"));
		rootDirectory.add(new File("config.sys"));			
		Directory winDir=new Directory("Windows");
		rootDirectory.add(winDir);
		winDir.add(new File("win.com"));
		winDir.add(new File("win.ini"));
		Directory sysDir=new Directory("System32");
		winDir.add(sysDir);
		sysDir.add(new File ("userinit.exe"));
		sysDir.add(new File ("arp.exe"));
		rootDirectory.showDirectory("");
		rootDirectory.add(new File("ReadMe.txt"));
		rootDirectory.del("ReadMe.txt");
		rootDirectory.del("Windows");
		rootDirectory.del("NotExist");

		/* For StackOverflow
		sysDir.add(winDir);
		rootDirectory.showDirectory("");
		*/
		
		/* For ClassCastException
		AudioFile audioFile=(AudioFile) new File("audio.mp3");
		audioFile.Play();
		*/

	}
}
