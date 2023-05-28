
import java.io.File;
import java.util.TreeSet;

public class CustomCSV {
	
	public CustomReader cr;
	public String csvFilePathRead;
	public File [] csvFilePathsRead;
	public CustomWriter cw;
	public String csvFilePathWrite;

	public CustomCSV() {
		
	}
	
	public void loadCSVToRead(String csvFilePath) {
		csvFilePathRead = csvFilePath;
		cr = new CustomReader(new File(csvFilePath));
	}
	public void loadCSVToRead(File csvFilePath) {
		csvFilePathRead = csvFilePath.getAbsolutePath();
		cr = new CustomReader(csvFilePath);
	}
	public void loadCSVToWrite(String csvFilePath) {
		csvFilePathWrite = csvFilePath;
		cw = new CustomWriter(new File(csvFilePath));
	}
	public void loadCSVMultipleFilesToRead(File[] multipleCSVFilePaths) {
		csvFilePathsRead = multipleCSVFilePaths;
	}
	
	public int 		nextChar() {			return cr.nextChar();	}
	public String 	nextLine() {			return cr.nextLine();	}
	public void 	print(String str) {		cw.print(str);			}
	public void 	println(String str) {	cw.println(str);		}
	public void 	close() {				cr.close(); cw.close();	}
	public void 	closeReader() {			cr.close();				}
	public void 	closeWriter() {			cw.close();				}
	
	public String [] csvLineToArray(String s, String delim, int numOfColInCSV, boolean removeFirstAndLastCh) {
		try {
			if(removeFirstAndLastCh) { 
				s = s.substring(1,s.length()-1);
			}
			String [] t = new String[numOfColInCSV];
			for(int i = 0; i < t.length-1; i++) {
				int p = s.indexOf(delim);
				t[i] = s.substring(0, p);
				s = s.substring(p+delim.length());
			}
			t[t.length-1] = s;
			return t;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void filterCSV(String subSearch) throws Exception {
		println(headerCSV());
		String line = nextLine();
		while(line != null) {
			if(line.contains(subSearch))
				println(line);
			line = nextLine();
		}
		close();
	}
	
	public void filterCSVMultipleFiles(String subSearch) throws Exception {
		println(headerCSV());
		close();
		for(int i = 0; i < csvFilePathsRead.length; i++) {
			loadCSVToRead(csvFilePathsRead[i]);
			String line = nextLine();
			while(line != null) {
				if(line.contains(subSearch))
					println(line);
				line = nextLine();
			}
			closeReader();
		}
		closeWriter();
	}
		
	public String headerCSV() {
		CustomReader temp = new CustomReader(new File(csvFilePathRead));
		return headerHelper(temp);
	}
	
	public String headerCSVMulipleFiles() {
		CustomReader temp = new CustomReader(csvFilePathsRead[0]);
		return headerHelper(temp);
	}
	
	private String headerHelper(CustomReader temp) {
		String header = temp.nextLine();
		temp.close();
		return header;		
	}

	public String uniqueValues(String delim, int numOfColInCSV, boolean removeFirstAndLastCh ) throws Exception {
		System.out.println(nextLine());
		String line = nextLine();
		TreeSet<String> [] trees = (TreeSet<String>[]) new TreeSet [numOfColInCSV];
		for(int i = 0; i < trees.length; i++) {
			trees[i] = new TreeSet<String>();
		}
		while(line != null) {
			String [] fields = csvLineToArray(line, delim, numOfColInCSV, removeFirstAndLastCh);
			for(int i = 0; i < fields.length; i++) {
				trees[i].add(fields[i]);
			}
			line = nextLine();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < trees.length - 1; i++) {
			sb.append(trees[i] + "\n");
		}
		sb.append(trees[trees.length-1]);
		return sb.toString();
	}
	
	public int countColumns(String line, String delimiter) {
		return ((line.length() - line.replace(delimiter, "").length())/delimiter.length() + 1);
	}
}

