package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9 
{
	public static void main(String[] args) throws FileNotFoundException {

		long startTime = System.currentTimeMillis();

		final int PREAMBLE_SIZE = 25;

		Scanner reader = new Scanner(new File("C:\\Users\\imaji\\Desktop\\z\\advent\\day 9.txt"));
		ArrayList<Long> input = new ArrayList<Long>();

		while (reader.hasNextLine())
			input.add(Long.parseLong(reader.nextLine()));

		// part1
		ArrayList<Long> preamble = new ArrayList<Long>();
		Queue<Long> restOfNums = new LinkedList<Long>();

		for (int i = 0; i < input.size(); i++) 
		{
			if (i < PREAMBLE_SIZE)
				preamble.add(input.get(i));
			else
				restOfNums.add(input.get(i));
		}

		long firstError = 0;
		boolean invalidFound = false;
		while (!invalidFound) {
			long n = restOfNums.poll();
			if (!isValid(preamble, n)) 
			{
				firstError = n;
				invalidFound = true;
			} else {
				preamble.remove(0);
				preamble.add(n);
			}
		}

		System.out.println("First invalid #: " + firstError);

		// part 2
		final long INVALID_NUM = firstError;
		int min = 0, max = 0;
		int i = 0;
		boolean setFound = false;

		while (!setFound) {
			int sum = 0;
			int j = i;
			min = Integer.MAX_VALUE;
			max = 0;
			while (sum < INVALID_NUM) 
			{
				sum += input.get(j);
				min = (int) Math.min(min, input.get(j));
				max = (int) Math.max(max, input.get(j));
				j++;
			}
			if (sum == INVALID_NUM) 
			{
				setFound = true;
			} else 
			{
				i++;
			}
		}

		System.out.println("Sum of smallest + largest: " + (min + max));

		long endTime = System.currentTimeMillis();
		System.out.println("Run time: " + (endTime - startTime) / 1000.0 + " seconds");

	}

	private static boolean isValid(ArrayList<Long> pre, long n) {
		for (int i = 0; i < pre.size() - 1; i++) 
		{
			for (int j = i + 1; j < pre.size(); j++) 
			{
				if (pre.get(i) + pre.get(j) == n) 
				{
					return true;
				}
			}
		}
		return false;
	}
}
