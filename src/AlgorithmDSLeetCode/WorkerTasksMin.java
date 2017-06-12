package AlgorithmDSLeetCode;

import java.util.Arrays;
import java.lang.*;

public class WorkerTasksMin {
	
	public int getMiniSolution(int[] tasks, int k) {
	    if(tasks == null || tasks.length == 0 || k <= 0) {
	      return 0; // error condition
	    }

	    int[] workers = new int[k];
	    // NlogN time
	    Arrays.sort(tasks);

	    // Takes n*k time, we are going in desc order so we know the i task will always take less than i+1 task
	    for(int i = tasks.length - 1; i >= 0 ; i--) {
	      int index = getCurrentMinWorker(workers);
	      workers[index] += tasks[i];
	    }

	    int minWorker = getCurrentMinWorker(workers);
	    return workers[minWorker];
	  }

	  public int getCurrentMinWorker(int[] workers) {
	    int index = 0;
	    for(int i = 0; i <= workers.length - 1; i++) {
	      if(workers[index] <= workers[i]) {
	        index = i;
	      }
	    }
	    return index;
	  }

	public int getMini(int[] tasks, int k) {
		System.out.println("Before Sorting : " + Arrays.toString(tasks));

		Arrays.sort(tasks);
		double totalTaskValue = 0;
		int tempPartitionValue = 0,maxPartitionValue = 0;
		double maxTaskValue=0;
		for (int i = 0; i < tasks.length; i++){
			totalTaskValue = totalTaskValue + tasks[i];
			maxTaskValue = Math.max(maxTaskValue, tasks[i]);
		}
		if(maxTaskValue >= Math.ceil((totalTaskValue) / k)){
			return (int) maxTaskValue;
		}
		else{
		System.out.println("After Sorting : " + Arrays.toString(tasks) + " Value of totalTaskValue is "+totalTaskValue+" Min Value of partitions :"
				+ Math.ceil((totalTaskValue) / k)+" Another ceiling "+ totalTaskValue / k+" maxTaskValue "+maxTaskValue);
		int i=0;
		while(i < tasks.length) {
			tempPartitionValue = 0;
			while (tempPartitionValue < Math.ceil((totalTaskValue) / k) && i < tasks.length) {
				tempPartitionValue = tempPartitionValue + tasks[i];
				i++;
				System.out.println("tempPartitionValue: " +tempPartitionValue + " i is "+i);
				
				}
			System.out.println("tempPartitionValue outside while: " +tempPartitionValue + " i is "+i);
			maxPartitionValue = Math.max(tempPartitionValue, maxPartitionValue);
//			System.out.println(maxPartitionValue);
		}
		
		return maxPartitionValue;
		}
	}

	public static void main(String[] args) {

		int[] tasks = { 2,2,36,3,5,2,4,46,76,4,23,12,41,63,34,1,13,7,3,21,4,7,1 };
		int worker = 5;
		System.out.println("Current Solution : "+new WorkerTasksMin().getMini(tasks, worker));
		System.out.println("Online Solution : "+new WorkerTasksMin().getMiniSolution(tasks, worker));

	}

}
