package day7;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day7 {

	public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(new File(("C:\\Users\\imaji\\Desktop\\z\\advent\\day 7.txt")));
	    Map<String, List<String>> bagTypes = new HashMap<>();
	    Map<String, List<String>> bagTypesPart2 = new HashMap<>();
	    while (sc.hasNext()) 
	    {
	        String[] parts = sc.nextLine().split(" bags contain | bags, | bag, | bags\\.| bag\\.");
	        bagTypes.putIfAbsent(parts[0], new ArrayList<>());
	        bagTypesPart2.putIfAbsent(parts[0], new ArrayList<>());
	        for (int i = 1; i < parts.length; ++i) 
	        {
	            if (!parts[i].equals("no other")) 
	            {
	                bagTypes.get(parts[0]).add(parts[i].replaceAll("\\d ", ""));
	                int n = Integer.parseInt(parts[i].split(" ")[0]);
	                for (int j = 0; j < n; ++j) {
	                    bagTypesPart2.get(parts[0]).add(parts[i].replaceAll("\\d ", ""));
	                }
	            }
	        }
	    }


	    int part1 = 0;
	    for (String start : bagTypes.keySet()) {
	        Queue<String> queue = new LinkedList<String>();
	        Set<String> seen = new HashSet<>();
	        queue.add(start);
	        while (!queue.isEmpty()) {
	            String current = queue.remove();
	            if (bagTypes.get(current).contains("shiny gold")) {
	                ++part1;
	                break;
	            }
	            for (String s : bagTypes.get(current)) {
	                if (!seen.contains(s)) {
	                    queue.add(s);
	                    seen.add(s);
	                }
	            }
	        }
	    }
	    System.out.println(part1);

	    int part2 = 0;
	    Queue<String> queue = new LinkedList<String>();
	    queue.add("shiny gold");
	    while (!queue.isEmpty()) {
	        String current = queue.remove();
	        ++part2;
	        queue.addAll(bagTypesPart2.get(current));
	    }

	    System.out.println(part2 - 1);
	    sc.close();
	}
}
