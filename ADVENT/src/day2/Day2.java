package day2;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Day2 
{
	public static void main(String [] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try
		{
			Scanner boi = new Scanner(new File("C:\\Users\\imaji\\Desktop\\z\\advent\\day 2.txt"));
			while(boi.hasNext())
			{
				list.add(boi.nextLine());
			}
		}
			
		catch(Exception e)
		{
		}
		
		partOne(list);
		
		
		new Day2();
	}
	
	public Day2()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try
		{
			Scanner boi = new Scanner(new File("C:\\Users\\imaji\\Desktop\\z\\advent\\day 2.txt"));
			while(boi.hasNext())
			{
				list.add(boi.nextLine());
			}
		}
			
		catch(Exception e)
		{
		}
		System.out.println("PART TWO \n ===========================");
		partTwo(list);
	}
	
	public static int partOne(ArrayList<String> myArray)
	{
		System.out.println("PART ONE \n =================================");
		ArrayList<String> list = myArray;
		
		int low = 0;
		int high = 0;
		String letter = "";
		String password = "";
		int count = 0;
		
	    for(int i = 0; i < list.size(); i++)
	    {
	    	String line = list.get(i);
	    	low = Integer.parseInt(line.substring(0,line.indexOf("-")));
	    	line = line.substring(line.indexOf("-")+1);
	    	high = Integer.parseInt(line.substring(0,line.indexOf(" ")));
	    	line = line.substring(line.indexOf(" ")+1);
	    	letter = line.substring(0,1);
	    	line = line.substring(line.indexOf(" ")+1);
	    	password = line;
	    	
	    	int number = 0;
	    	for(int a = 0; a<password.length();a++)
	    	{
	    		if(password.substring(a,a+1).equals(letter) )
	    			number++;
	    		
	    	}
	    	
	    	if(number >= low && number <= high)
	    		count++;	
	    }
	    System.out.println("You have " + count + " valid passwords!");
	    System.out.println("You have " + (list.size() - count) + " invalid passwords!");
	    return count;
	}
    public int partTwo(final List<String> inputs)
    {
    	List<String> list = inputs;
    	
        int validPasswords = 0;

        for(String input : inputs)
        {
            ParsedInput parsedInput = parseInput(input);

            if(parsedInput.isValidForTask2())
            {
                validPasswords++;
            }
        }
        System.out.println("You have " + validPasswords + " valid passwords!");
        System.out.println("You have " + (list.size() - validPasswords) + " invalid passwords!");
        
        return validPasswords;

        
    }

    /**
     * Parses the Input to a ParsedInput Object
     *
     * @param input String that should be parsed
     * @return ParsedInput
     */
    private ParsedInput parseInput(final String input)
    {
        //Using Split as I do not need to worry about the Letter Counts with this
        String[] informationPasswordSplit = input.split(":");
        String[] rangeLetterSplit = informationPasswordSplit[0].split(" ");
        String[] rangeSplit = rangeLetterSplit[0].split("-");

        String password = informationPasswordSplit[1].trim();
        char requiredCharacter = rangeLetterSplit[1].charAt(0);
        int lowerRangeEnd = Integer.parseInt(rangeSplit[0]);
        int upperRangeEnd = Integer.parseInt(rangeSplit[1]);

        return new ParsedInput(password, requiredCharacter, lowerRangeEnd, upperRangeEnd);
    }

	
			
			
			
			
			
			
			/*for(int a = 0; a < 2; a++)
			{
				low = Integer.parseInt(line.substring(0,line.indexOf("-")));
				System.out.println(low);
				high = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" ")));
				System.out.println(high);
				letter = line.substring(line.indexOf(":") - 1, line.indexOf(":"));
				System.out.println(letter); //these are right
				int first = 0;
				int second = 0;
			
				String word = line.substring(line.indexOf(":") + 2);
				String posOne = word.substring(low - 1, low + 2);
				String posTwo = word.substring(high - 1, high);
				System.out.println(posOne);
				System.out.println(posTwo);
				System.out.println(word); //this prints the word right
				System.out.println(line);
				
				if(posOne.equals(letter))
				{
					first++;
				}
				if(posTwo.equals(letter))
				{
					second++;
				}
				if((first + second) == 1)
				{
					count++;
				}

			}*/
		
	}

