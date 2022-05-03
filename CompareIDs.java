//This will serve as an automatically sorted list of all the patient IDs present in the Control_Cohort_Dates.txt
TreeSet<String> datesID = new TreeSet<String>();
//Opens file to read
FileReader fr = new FileReader(new File("D:\\John\\JavaCode\\Control\\Control_Cohort_Dates.txt")); BufferedReader br = new BufferedReader(fr);
//Reads first line
String line = br.readLine();
while(line != null) {
  //adds the patient ID (which happens to be the first 40 characters of the line in this specific file)
  datesID.add(line.substring(0, 40));
  //moves on to the next line
  line = br.readLine();
}
br.close(); fr.close();

//This will serve as an automatically sorted list of all the patient IDs present in the ControlPatient.csv.
//I have tested the same code with the raw original patient.csv present in the control cohort folder on the seagate drive as well.
TreeSet<String> originalID = new TreeSet<String>();
//Opens file to read
fr = new FileReader(new File("D:\\John\\JavaCode\\Control\\ControlPatient.csv")); br = new BufferedReader(fr);
//Skips the header (there is no header in the Control_Cohort_Dates.txt, but there is a header in both ControlPatient.csv and raw original patient.csv )
br.readLine();
//Reads first line
line = br.readLine();
while(line != null) {
  //adds the patient ID (which happens to be the first 40 characters (after the first character) of the line in this specific file).
  //The first character in both ControlPatient.csv and raw original patient.csv is a quotation mark
  originalID.add(line.substring(1, 41));
  line = br.readLine();
}
br.close(); fr.close();

//Prints size of both lists
System.out.println(datesID.size() + "\t" + originalID.size());
//Prints the first element of each list, and the word length of that first element in each list.
System.out.println(datesID.first() + "\t" + datesID.first().length());
System.out.println(originalID.first() + "\t" + originalID.first().length());

while(datesID.size() > 0) {
  //if the first element of each list aren't the same ID
  if(!datesID.first().equals(originalID.first())) {
    //Prints the different IDs and terminates the program.
    System.out.println(datesID.first());
    System.out.println(originalID.first());
    System.exit(0);
  }
  //removes the first element from each list, which have content equal to each other's content
  datesID.remove(datesID.first());
  originalID.remove(originalID.first());
}
//If nothing gets printed after the while loop starts, then the program never encountered two different IDs with matching line positions

//Code ends here-------------------------------------------------------------------------------------------------------------------------------------------
//Output from console:
//18000000	18000000
//0000000c44ccd86a4e9693d2da2504b63eeed2cd	40
//0000000c44ccd86a4e9693d2da2504b63eeed2cd	40
//This code coudn't find any differences in IDs between the patient IDs in the (raw original patient.csv/ControlPatient.csv) and the Control_Cohort_Dates.csv
