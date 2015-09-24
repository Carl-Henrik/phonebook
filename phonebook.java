package com.example.main;

import java.util.ArrayList;
import java.util.Scanner;

public class phonebook {
	
	static Scanner in = new Scanner(System.in);

	float temp1;
	float temp2;
	String input;
	String empName = "";
	int empNumber;
	
	
	ArrayList<employee> phoneBook = new ArrayList<employee>();
	
	public phonebook(){
	
	
	Boolean exit = false;
	while (exit == false){
		
		System.out.println("\n1: lägg til en ny anställd \n2: sök efter en anställd \n3: sortera telefonboken \n4: skriv ut hela telefonboken \n5: avsluta");
		input = in.nextLine();
		
		if (input.equals("1")){addEmp();}
		else if (input.equals("2")){findEmp();}
		else if (input.equals("3")){sortBook();}
		else if (input.equals("4")){printBook();}
		else if  (input.equals("5")){exit = true;}
	 
		

		
		}
	
}
	
	public void addEmp(){
		
		String empName = "";
		
		System.out.println("Vad har den anställde för förkortning? (4 tecken)");
		empName = in.nextLine();
		
		empName = empName.substring(0, Math.min(empName.length(), 4));


		String empNumber;
		
		System.out.println("Vad har den anställde för nummer? (4 siffror)");
		empNumber = in.nextLine();
		empNumber = empNumber.substring(0, Math.min(empName.length(), 4));
		
		int empPhone = Integer.parseInt(empNumber);
		
		
		employee newEmployee = new employee(empPhone, empName);
		
		
		phoneBook.add(newEmployee);
			
	}
	
	
	
	public void findEmp(){
		
		System.out.println("Vad har den anställde för förkortning? (4 tecken)");
		empName = in.nextLine();
		
		empName = empName.substring(0, Math.min(empName.length(), 4));
		
		
		for (int i = 0; i < phoneBook.size(); i++){
			
			if (empName.equals(phoneBook.get(i).empID)){
								System.out.println("Anstäld med förkorting " + empName + " har kortnummer " + phoneBook.get(i).empPhone);
								return;
							}
		}
		System.out.println("Anstäld med förkorting " + empName + " kunde inte hittas");
		
	}
	
	
	
	public void sortBook(){
		
		System.out.println("\n1: Insertion sort \n2: Bubble sort \n3: Selection sort \n4: Quick sort");
		input = in.nextLine();
		
		if (input.equals("1")){insertionSort();}
		else if (input.equals("2")){bubbleSort();}
		else if (input.equals("3")){selectionSort();}
		else if (input.equals("4")){quickSort(0, phoneBook.size()-1);}
		
		
	};
	
	public void printBook(){
		
		for (int i = 0; i < phoneBook.size(); i++){
		
		System.out.println((i +1) + ". " + phoneBook.get(i).empID + " : " + phoneBook.get(i).empPhone);
		}
	};
	
	
	public void insertionSort(){
		int i, j; 
		employee temp;
		
		for (i = 1; i < phoneBook.size(); i++){
		
			temp = phoneBook.get(i);
			j = i;
			
			while(j>0 && phoneBook.get(j-1).empID.compareTo(temp.empID) > 0) {
				phoneBook.set(j, phoneBook.get(j-1));
				j--;
			}
			phoneBook.set(j, temp);
			
		}
		
	}
	
	public void bubbleSort(){
		int i;
		boolean unsorted = true;
		employee temp;
		
		while (unsorted){
			unsorted = false;
			for(i=0; i<phoneBook.size()-1; i++){
				
				if ( phoneBook.get(i).empID.compareTo(phoneBook.get(i+1).empID) > 0){
					
					temp = phoneBook.get(i);
					phoneBook.set(i, phoneBook.get(i+1));
					phoneBook.set(i+1, temp);
					unsorted = true;
				}
				
			}
			
		}
		
		
		
	}
	
	
	public void selectionSort(){
		
		int i, j, first;
		employee temp;
		
		for (i=phoneBook.size() -1; i>0; i--){
			first = 0;
			for (j=1; j<=i; j++){
				if ( phoneBook.get(j).empID.compareTo(phoneBook.get(first).empID) > 0){
					first = j;
				}
				temp = phoneBook.get(first);
				phoneBook.set(first, phoneBook.get(i));
				phoneBook.set(i, temp);
			}
		}
		
		
		
	}
	
	public void quickSort(int low, int high){
		
		if (phoneBook.size()==0){return;}
		int i = low;
		int j = high;
		employee pivot = phoneBook.get(low + (high-low)/2);
		
		
		
		while (i<=j) {
			while (phoneBook.get(i).empID.compareTo(pivot.empID) < 0){
			i++;
			}
			
			while (phoneBook.get(j).empID.compareTo(pivot.empID) > 0){
				j--;
				}
			
			if (i<=j){
				employee temp = phoneBook.get(i);
				phoneBook.set(i, phoneBook.get(j));
				phoneBook.set(j, temp);
				i++;
				j--;
				
				
			}
			
		}
		
		if (low<j){quickSort(low, j);}
		if (i<high){quickSort(i, high);}
		
	}
}
