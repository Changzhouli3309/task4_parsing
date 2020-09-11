package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) {
		String path = "sample.csv";

		List<List<String>> records = CSV_reader.getData(path);

		System.out.println("Records laod:");
		for (List<String> line : records) {
			System.out.println(line);
		}

		System.out.println("\n-----------------------------------------------\n");

		int member1 = 1;
		int member2 = 2;
		String searchWord = "a";
		List<String> nameWithA = new ArrayList<String>();

		for (List<String> line : records) {
			if(line.get(member1).length() < 15) {
			//skip first line
				if (line.get(member1).toLowerCase().contains(searchWord)) {
					nameWithA.add(line.get(member1));
				}
				if (line.get(member2).toLowerCase().contains(searchWord)) {
					nameWithA.add(line.get(member2));
				}
			}
		}

		System.out.println("There are " + nameWithA.size() 
							+ " people whos name contains " 
							+ searchWord + ":");
		System.out.println(nameWithA);

		System.out.println("\n-----------------------------------------------\n");

		int timeStamp = 0;
		List<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < records.size(); i++) {
			List<String> checkline = records.get(i);
			for (List<String> line : records) {
				if ((!line.equals(checkline)) && 
						(line.get(timeStamp).equals(checkline.get(timeStamp)))) {
					//skip the same line and match time stamp with others
					indexes.add(i);
				}
			}
		}

		System.out.println("Thers are " + indexes.size() 
							+ " grupps has same timestamp with other(s):");
		for (Integer i : indexes) {
			System.out.println(records.get(i));
		}

		System.out.println("\n-----------------------------------------------\n");

		int workWith = 6;
		String andriod = "Android App";
		List<String> workWithA = new ArrayList<String>();

		for (List<String> line : records) {
			if (line.get(workWith).equals(andriod)) {
				workWithA.add(line.get(member1));
				workWithA.add(line.get(member2));
			}
		}

		System.out.println("There are " + workWithA.size() 
							+ " people who wants to work with Android App:");
		System.out.println(workWithA);

		System.out.println("\n-----------------------------------------------\n");

		int email1 = 3;
		int email2 = 4;

		Map<String, String> accounts = new TreeMap<String, String>();

		for (List<String> line : records) {
			if ((!line.get(member1).equals("")) && (line.get(member1).length() < 15)) {
			//skip first line and empty lines
				accounts.put(line.get(member1), line.get(email1));
				accounts.put(line.get(member2), line.get(email2));
			}
		}

		Set<String> errorKeys = new TreeSet<String>();

		for (String key : accounts.keySet()) {
			System.out.println("Name: " + key + " Email: " + accounts.get(key));
			for (String testKey : accounts.keySet()) {
				if (!key.equals(testKey) && 
						accounts.get(key).equals(accounts.get(testKey))) {
					errorKeys.add(key);
				}
			}
		}

		System.out.println("\nThere are " + errorKeys.size() 
							+ " people has error with email:");

		for (String s : errorKeys) {
			System.out.println("Name: " + s + " Email: " + accounts.get(s));
		}

	}

}
