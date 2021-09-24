package com.jiangls.interview;

import java.util.Arrays;
import java.util.List;

public class Task {

    public static void main(String[] args) {
        // 预期sum: 16
        List<Task> tasks1 = Arrays.asList(new Task[]{new Task(1L, 5L), new Task(3L, 8L), new Task(3L, 8L), new Task(6L, 17L)});
        sum(tasks1);

        // 预取sum: 948
        List<Task> task2 = Arrays.asList(new Task[]{new Task(1L, 5L), new Task(50L, 80L), new Task(50L, 80L), new Task(85L, 999L)});
        sum(task2);

        // 预期sum: 26
        List<Task> tasks3 = Arrays.asList(new Task[]{new Task(1L, 9L), new Task(8L, 15L), new Task(18L, 25L), new Task(22L, 30L)});
        sum(tasks3);

        // 预期sum: 98
        List<Task> tasks4 = Arrays.asList(new Task[]{new Task(1L, 99L), new Task(8L, 18L), new Task(29L, 56L), new Task(57L, 90L)});
        sum(tasks4);
    }

    public static void sum(List<Task> tasks) {
        Task task0 = tasks.get(0);
        Long maxEnd = task0.getEnd();
        Long sum = task0.getEnd() - task0.getStart();
        for (int i = 1; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            Task preTask = tasks.get(i-1);

            if (currentTask.getStart() >= maxEnd) {
                sum += currentTask.getEnd() - currentTask.getStart();
                maxEnd = currentTask.getEnd();
            } else if (currentTask.getEnd() > maxEnd) {
                sum += currentTask.getEnd() - maxEnd;
                maxEnd = currentTask.getEnd();
            }

        }
        System.out.println("实际sum: " + sum);
    }

    private Long start;
    private Long end;

    public Task(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public Long getStart() {
        return start;
    }


    public Long getEnd() {
        return end;
    }

}
