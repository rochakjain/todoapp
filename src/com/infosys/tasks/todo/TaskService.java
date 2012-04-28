package com.infosys.tasks.todo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class TaskService {
	
	public void storeTasks(List<Task> taskList)
	{
		try {
			
			FileOutputStream fOutStream = new FileOutputStream("taskList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fOutStream); 
			if(taskList!=null)
			oos.writeObject(taskList);
			oos.close();
			} 
		catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public List<Task> readAllTasks()
	{
		System.out.println("showing all tasks");
		try{
			 
			   FileInputStream fInStream = new FileInputStream("taskList.ser");
			   ObjectInputStream objInStream = new ObjectInputStream(fInStream);
			   List<Task> taskList = (List<Task>) objInStream.readObject();
			   objInStream.close();
	 
			   return taskList;
	 
		   }catch(FileNotFoundException ex){
			   System.out.println("file not found, Please add tasks first \n");
			   System.exit(0);
			   //ex.printStackTrace();
			   return null;
		   }
			catch(Exception ex){
			   ex.printStackTrace();
			   return null;
			   //git gui demo
		   }
			
	}

}
