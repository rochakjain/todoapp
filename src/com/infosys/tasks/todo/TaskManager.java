package com.infosys.tasks.todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
			System.out.println("this is a To Do demo application");
			Starter starter = new Starter();
			starter.starterMethod();
		}
	
	
	public void showTasks() {
		// TODO Auto-generated method stub
		//this method is used to show the tasks
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		}
		else
			System.out.println("Task List is empty, Please add tasks to list");
		
	}

	public void upgradeTasks() throws ParseException {
		// TODO Auto-generated method stub
		//this method is used to change the end date of the tasks
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		   System.out.println("enter the serial no of task for which u want to change the end date");
		   Scanner scan=new Scanner(System.in);
		   int count=0;
		   int temp=0;
		   do {
			   try {
				   	temp=0;
				   	count = Integer.parseInt(scan.next());
				   	if(count>taskList.size()){
				   		System.out.println("Please enter correct serial number");
				   		
				   	}
			   } 
			   catch (Exception e) {
					System.out.println("Please enter correct serial number");
					temp=1;
			   }
		   } while (temp==1 || count>taskList.size());
		   
		   int flag;
		   do {
			   try {
				   System.out.println("enter the new end date for selected task");
				   String newDeadline= scan.next();
				   SimpleDateFormat sdForm = new SimpleDateFormat("dd-MM-yyyy");
				   taskList.get(count-1).setTaskEndDate(new Date(sdForm.parse(newDeadline).getTime()));
				   TaskService taskService = new TaskService();
				   taskService.storeTasks(taskList);
				   System.out.println("Deadline has been changed for task");
				   flag=0;
			   } 
			   catch (ParseException e) {
				   System.out.println("the date you provided is in an invalid date, enter date in correct format i.e. dd-MM-yyyy");
					flag=1;
			   }
		} while (flag==1);
		  
		}
		else
			System.out.println("Tasklist is empty, Please add tasks to the list");
	}
		

	public void deleteTasks() {
		// TODO Auto-generated method stub
		//this method is used to delete the tasks
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
			System.out.println(taskList.size());
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		   System.out.println("enter the serial no of task which u want to delete");
		   Scanner scan=new Scanner(System.in);
		   int count= 0;
		   int temp=0;
		   do {
			   try {
				   	temp=0;
				   	count = Integer.parseInt(scan.next());
				   	if(count>taskList.size()){
				   		System.out.println("Please enter correct serial number");
				   		
				   	}
			   } 
			   catch (Exception e) {
					System.out.println("Please enter correct serial number");
					temp=1;
			   }
		   } while (temp==1 || count>taskList.size());
		   taskList.remove(count-1);
		   TaskService taskService = new TaskService();
		   taskService.storeTasks(taskList);
		}
		   else
			   System.out.println("Tasklist is empty, first add tasks to list");
		
	}
		

	public void priotizeTasks() {
		// TODO Auto-generated method stub
		//this method sets priority for tasks
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		
		   System.out.println("enter the serial no of task for which u want to change the priority");
		   Scanner scan=new Scanner(System.in);
		   int count= 0;
		   int temp=0;
		   do {
			   try {
				   	temp=0;
				   	count = Integer.parseInt(scan.next());
				   	if(count>taskList.size()){
				   		System.out.println("Please enter correct serial number");
				   		
				   	}
			   } 
			   catch (Exception e) {
					System.out.println("Please enter correct serial number");
					temp=1;
			   }
		   } while (temp==1 || count>taskList.size());
		   System.out.println("enter the new priority for selected task");
		   String newPriority;
		   do	
			{
			   newPriority= scan.next();
			   if(newPriority.equalsIgnoreCase((TaskPriority.HIGH).toString()) || newPriority.equalsIgnoreCase((TaskPriority.MEDIUM).toString()) || newPriority.equalsIgnoreCase((TaskPriority.LOW).toString()))
					taskList.get(count-1).setTaskPriority(TaskPriority.valueOf(newPriority.toUpperCase()));
				else
				{
					System.out.println("Please enter appropriate value i.e. High or medium or low ");
					//newPriority = scan.next();
					//taskList.get(count-1).setTaskPriority(TaskPriority.valueOf(newPriority.toUpperCase()));
				}
			}
			while(!(newPriority.equalsIgnoreCase((TaskPriority.HIGH).toString()) || newPriority.equalsIgnoreCase((TaskPriority.MEDIUM).toString()) || newPriority.equalsIgnoreCase((TaskPriority.LOW).toString())));
			
		   TaskService taskService = new TaskService();
		   taskService.storeTasks(taskList);
		}
		else
			System.out.println("Tasklist is empty, Please add tasks to the list");
	}

	public void addTasks(){
		// TODO Auto-generated method stub
		//this method is used to add tasks to the list
		List<Task> taskList = new ArrayList<Task>();
		System.out.println("enter the number of tasks to be added");
		Scanner abc= new Scanner(System.in);
		int noOfTasks=0;
		int flag;
		do {
			try {
				noOfTasks=Integer.parseInt(abc.next());
				flag=0;
			} 
			catch (NumberFormatException e) {
				System.out.println("invalid input, please enter integer value");
				flag=1;
			}
		} while (flag==1);
		int count=1;
		String priority;
		String tempDate;
		String status;
		//String []task = new String[noOfTasks];
		//String []priority = new String[noOfTasks];
		//Date []dateOfTask = new Date[noOfTasks];
		//String []taskStatus= new String[noOfTasks];
		for (int i = 0; i < noOfTasks; i++) 
		{
			Task task = new Task();
			System.out.println("enter the name of task no"+ count);
			task.setTaskDescription(abc.next());
			System.out.println("enter the priority of task no"+ count+ " as only High or Medium or Low");
				
			do	
			{
				priority = abc.next();
				if(!(priority.equalsIgnoreCase((TaskPriority.HIGH).toString()) || priority.equalsIgnoreCase((TaskPriority.MEDIUM).toString()) || priority.equalsIgnoreCase((TaskPriority.LOW).toString())))
				{	
					System.out.println("Please enter appropriate value i.e. High or medium or low ");
					//priority = abc.next();
					//task.setTaskPriority(TaskPriority.valueOf(priority.toUpperCase()));
				}
				else
				{
					
					task.setTaskPriority(TaskPriority.valueOf(priority.toUpperCase()));
				}
			}
			while(!(priority.equalsIgnoreCase((TaskPriority.HIGH).toString()) || priority.equalsIgnoreCase((TaskPriority.MEDIUM).toString()) || priority.equalsIgnoreCase((TaskPriority.LOW).toString())));
			int flag1;
			int flag2;
			do
			{
				try
				{
					System.out.println("enter the creationDate of task no"+ count + "in the dd-MM-yyyy format");
					tempDate = abc.next();
					SimpleDateFormat sdForm = new SimpleDateFormat("dd-MM-yyyy");
					task.setTaskCreationDate(new Date(sdForm.parse(tempDate).getTime()));
					flag1=0;
				}
				catch (ParseException e) {
					System.out.println("the date you provided is in an invalid date, enter date in correct format i.e. dd-MM-yyyy");
					flag1=1;
				}
			}
			while(flag1==1);
			
			do
			{
				try
				{
					System.out.println("enter the end Date of task no"+ count + "in the dd-MM-yyyy format");
					tempDate = abc.next();
					SimpleDateFormat sdForm = new SimpleDateFormat("dd-MM-yyyy");
					task.setTaskEndDate(new Date(sdForm.parse(tempDate).getTime()));
					flag2=0;
				}
				catch (ParseException e) {
					System.out.println("the date you provided is in an invalid date, enter date in correct format i.e. dd-MM-yyyy");
					flag2=1;
				}
			}
			while(flag2==1);
			
			System.out.println("enter the status of task no"+ count+ " as only Scheduled or Pending or Completed");
			
			do	
			{
				status = abc.next();	
				if(status.equalsIgnoreCase((TaskStatus.COMPLETED).toString()) || status.equalsIgnoreCase((TaskStatus.SCHEDULED).toString()) || status.equalsIgnoreCase((TaskStatus.PENDING).toString()))
					task.setTaskStatus(TaskStatus.valueOf(status.toUpperCase()));
				else
				{
					System.out.println("Please enter appropriate value i.e. COMPLETED or SCHEDULED or PENDING ");
					//status = abc.next();
					//task.setTaskStatus(TaskStatus.valueOf(status.toUpperCase()));
				}
			}
			while(!(status.equalsIgnoreCase((TaskStatus.COMPLETED).toString()) || status.equalsIgnoreCase((TaskStatus.SCHEDULED).toString()) || status.equalsIgnoreCase((TaskStatus.PENDING).toString())));
			taskList.add(task);
			//taskList.add(i, task);
			count++;
		}
			TaskService taskService = new TaskService();
			taskService.storeTasks(taskList);
	}
	
	public void modifyTasks() {
		// TODO Auto-generated method stub
		//this method is used to modify task's name
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		
		   System.out.println("enter the serial no of task for which u want to change the name");
		   Scanner scan=new Scanner(System.in);
		   int count= 0;
		   int temp=0;
		   do {
			   try {
				   	temp=0;
				   	count = Integer.parseInt(scan.next());
				   	if(count>taskList.size()){
				   		System.out.println("Please enter correct serial number");
				   		
				   	}
			   } 
			   catch (Exception e) {
					System.out.println("Please enter correct serial number");
					temp=1;
			   }
		   } while (temp==1 || count>taskList.size());
		   System.out.println("enter the new name for selected task");
		   String newName= scan.next();
		   taskList.get(count-1).setTaskDescription(newName);
		   TaskService taskService = new TaskService();
		   taskService.storeTasks(taskList);
		   System.out.println("name has been changed for task");
		}
		else
			System.out.println("Tasklist is empty, Please add tasks to the list");
	}
	public void pendingTasks() {
		// TODO Auto-generated method stub
		//this method is used to show pending tasks
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getTaskStatus().toString().equalsIgnoreCase("pending"))
			   System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
			else
				continue;
		   }
		}
		else
			System.out.println("Tasklist is empty, Please add tasks to the list");
	}
	public void upcomingTasks() {
		// TODO Auto-generated method stub
		//this method is used to show upcoming tasks
		System.out.println("Enter ur choice ");
		System.out.println("1. All Upcoming Tasks \n 2. Upcoming Tasks for this week \n 3. upcoming tasks for next week \n 4. upcoming tasks for next month");
		String choice;
		Scanner scan=new Scanner(System.in);
		
		//Date sysDate= Calendar.getInstance().getTime();
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
			do {
				choice= scan.next();
				Date sysDate= new Date(System.currentTimeMillis());
				 switch (choice) {
				 case "1":
						System.out.println("showing All Upcoming Tasks");
						   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
						   for (int i = 0; i < taskList.size(); i++) {
							if(taskList.get(i).getTaskStatus().toString().equalsIgnoreCase("pending") && (taskList.get(i).getTaskEndDate().compareTo(sysDate)>0))
								System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
							else
								continue;
						   }
					break; 
				case "2":
					System.out.println("showing upcoming tasks for this week");
					   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
					   for (int i = 0; i < taskList.size(); i++) {
						if(taskList.get(i).getTaskStatus().toString().equalsIgnoreCase("pending") && (taskList.get(i).getTaskEndDate().getTime()-sysDate.getTime())<=7)
							System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
						else
							continue;
					   }
				break;
				case "3":
					System.out.println("showing upcoming tasks for next week");
					   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
					   for (int i = 0; i < taskList.size(); i++) {
						if(taskList.get(i).getTaskStatus().toString().equalsIgnoreCase("pending") && (((taskList.get(i).getTaskEndDate().getTime()-sysDate.getTime())>7) && (taskList.get(i).getTaskEndDate().getTime()-sysDate.getTime())<=14))
							System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
						else
							continue;
					   }
					break;
				case "4":
					System.out.println("showing upcoming tasks for next month");
					System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
						   for (int i = 0; i < taskList.size(); i++) {
								if(taskList.get(i).getTaskStatus().toString().equalsIgnoreCase("pending") && (taskList.get(i).getTaskEndDate().getTime()-sysDate.getTime())>30)	
									System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
								else
									continue;
					   }
					break;
					default:
					 System.out.println(" not a valid choice, please enter a valid choice");
					}
			} while (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3") || choice.equalsIgnoreCase("4")));
		 
		}
			else
				   System.out.println("Tasklist is empty, Please add tasks to the list");
			//break;
		//default:
			//break;
		//}
	}

	public void modifyTaskStatus() {
		// TODO Auto-generated method stub
		//this method is used for modifying task's status
		List<Task> taskList= new TaskService().readAllTasks();
		if(taskList.size()!=0)
		{
		   System.out.println("Task Name \t Task Priority \t Creation Date \t End Date \t Task Status");
		   for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getTaskDescription()+"\t \t  "+taskList.get(i).getTaskPriority()+" \t \t "+taskList.get(i).getTaskCreationDate()+" \t \t "+taskList.get(i).getTaskEndDate()+ " \t \t "+ taskList.get(i).getTaskStatus());
		   }
		
		   System.out.println("enter the serial no of task for which u want to change the status");
		   Scanner scan=new Scanner(System.in);
		   int count= 0;
		   int temp=0;
		   do {
			   try {
				   	temp=0;
				   	count = Integer.parseInt(scan.next());
				   	if(count>taskList.size()){
				   		System.out.println("Please enter correct serial number");
				   		
				   	}
			   } 
			   catch (Exception e) {
					System.out.println("Please enter correct serial number");
					temp=1;
			   }
		   } while (temp==1 || count>taskList.size());
		   System.out.println("enter the new status for selected task");
		   String newStatus;
		   do	
			{
			   newStatus= scan.next();
			   if(newStatus.equalsIgnoreCase((TaskStatus.COMPLETED).toString()) || newStatus.equalsIgnoreCase((TaskStatus.PENDING).toString()) || newStatus.equalsIgnoreCase((TaskStatus.SCHEDULED).toString()))
					taskList.get(count-1).setTaskStatus(TaskStatus.valueOf(newStatus.toUpperCase()));
				else
				{
					System.out.println("Please enter appropriate value i.e. COMPLETED or PENDING or SCHEDULED ");
					//newStatus = scan.next();
					//taskList.get(count-1).setTaskStatus(TaskStatus.valueOf(newStatus.toUpperCase()));
				}
			}
			while(!(newStatus.equalsIgnoreCase((TaskStatus.COMPLETED).toString()) || newStatus.equalsIgnoreCase((TaskStatus.PENDING).toString()) || newStatus.equalsIgnoreCase((TaskStatus.SCHEDULED).toString())));
			
		   TaskService taskService = new TaskService();
		   taskService.storeTasks(taskList);
		   System.out.println("Status has been changed for task");
	}
	
	   else
		   System.out.println("Tasklist is empty, Please add tasks to the list");
	}
}
