package ua.goit.andre.lab6;

public class DirectoryNotEmptyException extends Exception{
	private static final long serialVersionUID = -2320958814998640349L;

	private String fileName;

	public DirectoryNotEmptyException(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}	
}
