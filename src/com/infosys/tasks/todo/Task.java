package com.infosys.tasks.todo;

import java.io.Serializable;
import java.util.Date;

 enum TaskPriority
{
	LOW,MEDIUM,HIGH
};
enum TaskStatus
{
	SCHEDULED,PENDING,COMPLETED
};
public class Task implements Serializable{
	
	private String taskDescription;
	private TaskPriority taskPriority;
	private Date taskCreationDate;
	private Date taskEndDate;
	private TaskStatus taskStatus;
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public TaskPriority getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}
	public Date getTaskCreationDate() {
		return taskCreationDate;
	}
	public void setTaskCreationDate(Date taskCreationDate) {
		this.taskCreationDate = taskCreationDate;
	}
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	
	
}
