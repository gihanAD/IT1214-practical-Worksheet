//write a java programe using array list to mange a list of Student name
//1.Accept 5 Student names from the user and stroe them in an ArrayList<String>
//2.Display all the Student names.
//3.Ask the user to enter a name to search.it found,display the position if not found display the massage"Student not found".
//4.Ask the user to enter a name to remove the List.after remove display the updated list.

//get the user input and storing names - 3
//display the list - 2
//searching and display index -2
//removing name and updating list - 3
//total - 10

import java.util.ArrayList;
import java.util.Scanner;

public class Student{
	public static void main(String [] args){
		ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("please Enter 5 Students Name :");
		for (int i=0; i<5; i++){
			System.out.println("Enter name :"+(i+1)+ ":");
			String name = scanner.nextLine();
			studentNames.add(name);	
		}
		
		System.out.println("List of all Students name :");
		for(String name : studentNames){
			System.out.println(name);
		}
		
		System.out.println("Enter name to find :");
		String findName = scanner.nextLine();
		int position = studentNames.indexOf(findName);
        if (position != -1) {
            System.out.println("Student found at position: " + position);
        } else {
            System.out.println("Student not found.");
        }
		System.out.println("remove Name :");
		String removeName = scanner.nextLine();
		if(studentNames.remove(removeName)){
            System.out.println(removeName + " has been removed from the list.");
        } else {
            System.0out.println("Student not found");
        }
		
		 System.out.println("\nUpdated List of Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        //scanner.close();
		
		
	}
	
}


