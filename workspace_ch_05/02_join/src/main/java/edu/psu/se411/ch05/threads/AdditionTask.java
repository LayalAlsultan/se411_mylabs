package edu.psu.se411.ch05.threads;

public class AdditionTask implements Runnable {

	private int counter;
	private String taskId;

	public AdditionTask(String id_p) {
		this.taskId = id_p;
	}

	@Override
	public void run() {
		Thread threadC = new Thread(new CountingTask(this.taskId + "_#_task_C", 100));
		threadC.start();
		try {
			 // without waiting for thread C, the outputs would be interleaved
			// but with the join, this thread will wait until threadC finishes before proceeding
			while(counter < 100) {
				counter++;
				System.out.printf("Task %s Added 1 and now count is %d%n", getTaskId(), getCounter());
				//Thread.sleep(100);
			}
			threadC.join();
			System.out.printf("Task %s Terminated%n", getTaskId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public int getCounter() {
		return counter;
	}

	public String getTaskId() {
		return this.taskId;
	}
}
