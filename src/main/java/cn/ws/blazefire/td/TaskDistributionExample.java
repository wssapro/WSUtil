package cn.ws.blazefire.td;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskDistributionExample {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task B", 3));  // Weight: 3
        tasks.add(new Task("Task A", 5));  // Weight: 5
        tasks.add(new Task("Task C", 2));  // Weight: 2

        int totalWeight = tasks.stream().mapToInt(Task::getWeight).sum();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(totalWeight) + 1;
            int accumulatedWeight = 0;

            for (Task task : tasks) {
                accumulatedWeight += task.getWeight();
                if(task.getWeight() == 5){
                    continue;
                }
                if (randomNumber <= accumulatedWeight) {
                    System.out.println("Assigning task: " + task.getName());
                    break;
                }
            }
        }
    }

    static class Task {
        private String name;
        private int weight;

        public Task(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }
}
