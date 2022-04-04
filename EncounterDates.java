import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TreeSet;

public class EncounterDates {
	public static void main(String[]args) throws Exception{
		//Opens encounter csv for reading line by line
		BufferedReader br = new BufferedReader(new FileReader(new File("/run/media/mm/Easystore/Research/Original/encounter.csv")));
		//skips header
		System.out.println(br.readLine());
		String line = br.readLine();
		//The thing in between the values
		String delim = "\",\"";
		TreeSet<Integer> tree = new TreeSet<Integer>();
		while(line != null) {
			//gets rid of the first and last quotation marks
			line = line.substring(1,line.length()-1);
			
			//Splits the string into array: [encounter id, patient id, start date, end date, etc...]
			String [] t = new String[9];
			String z = line;
			for(int i = 0; i < t.length-1; i++) {
				t[i] = z.substring(0, z.indexOf(delim));
				z = z.substring(z.indexOf(delim)+delim.length());
			}
			t[t.length-1] = z;
			
			//checks if either end or start date are empty, skips if either are empty
			if(!t[3].isEmpty() && !t[2].isEmpty()) {
				LocalDate d1 = LocalDate.parse(t[2], DateTimeFormatter.BASIC_ISO_DATE);
				LocalDate d2 = LocalDate.parse(t[3], DateTimeFormatter.BASIC_ISO_DATE);
				Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
				long diffDays = diff.toDays();
				if(diffDays > 0) {
					tree.add((int)diffDays);
					if((int)diffDays == 26959) {System.out.println("Longest encounter: " + Arrays.toString(t));}
				}
			}
			
			//Moves onto next line to be processed
			line = br.readLine();
		}
		System.out.print("Number of unique durations: " + tree.size() + "\t");
		System.out.print("Shortest duration (days): " + tree.first() + "\t");
		System.out.print("Longest duration (days): " + tree.last());
	}
}
