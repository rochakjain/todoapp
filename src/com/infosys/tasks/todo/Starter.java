package com.infosys.tasks.todo;


import java.text.ParseException;
import java.util.Scanner;

import com.infosys.tasks.todo.TaskManager;

//this is the starter class of the application
public class Starter {

	public void starterMethod() throws ParseException{
		
		String input;
	do {
		System.out.println("enter your choice for To Do application");
		System.out.println("1. Show All Tasks \n 2. Add Tasks \n 3. Delete Tasks \n 4. Modify Task Description \n 5. Change priority for tasks \n 6. Extend Task Duration \n 7. Modify Task Status \n" +
				"8. Show Pending Tasks \n 9. Show Upcoming Tasks \n 10. Exit Application");
		
		
			
		
		Scanner abc= new Scanner(System.in);
		input=abc.next();
		TaskManager toDo = new TaskManager();
		
		switch (input) {
		case "1":
			toDo.showTasks();
			break;
		case "2":
			toDo.addTasks();
			break;
		case "3":
			toDo.deleteTasks();
			break;
		case "4":
			toDo.modifyTasks();
			break;
		case "5":
			toDo.priotizeTasks();
			break;
		case "6":
			toDo.upgradeTasks();
			break;
		case "7":
			toDo.modifyTaskStatus();
			break;
		case "8":
			toDo.pendingTasks();
			break;
		case "9":
			toDo.upcomingTasks();
			break;
		case "10":
			System.exit(0);
		default:
			System.out.println("not a valid option, please select a valid option");
			//break;
		}
	}
		while (input != "10");		
}
}

