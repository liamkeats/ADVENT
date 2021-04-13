package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day4 
{
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File fileObject = new File("C:\\Users\\imaji\\Desktop\\z\\advent\\day 4.txt");
	    Scanner sc = new Scanner(fileObject);
	    
	    String byr="0";
	    String iyr="0";
	    String eyr="0";
	    String hgt="";
	    String hcl="";
	    String ecl="";
	    String pid="";
	    String cid="";
	    boolean nowBreak=false;
	    PassportCollection passports = new PassportCollection();
	    
	    while (true) {
	    	String line="";
	    	if (!nowBreak) {
	    		line = sc.nextLine();
	    	}
	    	if (line.contentEquals("") || nowBreak) {
	    		Passport passport = new Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid);
	    		passports.add(passport);
	    		byr="0";
	    	    iyr="0";
	    	    eyr="0";
	    	    hgt="";
	    	    hcl="";
	    	    ecl="";
	    	    pid="";
	    	    cid="";
	    	    if (nowBreak) {
	    	    	break;
	    	    }
	    	}
	    	String[] temp = line.split(" ");
	    	
	    	for (int i=0; i<temp.length; i++) {
	    		String[] temp2 = temp[i].split(":");
	    		switch (temp2[0]) {
	    			case "byr":
	    				byr=temp2[1];
	    				break;
	    			case "iyr":
	    				iyr=temp2[1];
	    				break;
	    			case "eyr":
	    				eyr=temp2[1];
	    				break;
	    			case "hgt":
	    				hgt=temp2[1];
	    				break;
	    			case "hcl":
	    				hcl=temp2[1];
	    				break;
	    			case "ecl":
	    				ecl=temp2[1];
	    				break;
	    			case "pid":
	    				pid=temp2[1];
	    				break;
	    			case "cid":
	    				cid=temp2[1];
	    				break;
	    		}
	    	}
	    	
	    	if (!sc.hasNext()) {
    	    	nowBreak=true;
    	    }
	    }
	    
	    sc.close();
	    hgt="180cm";
	    System.out.println("Valid simple check passports in database: " + passports.numOfvalidPassports1());
	    System.out.println("Valid real check passports in database: " + passports.numOfvalidPassports2());    
	}
}
