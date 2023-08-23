import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    private Task getTask(int i) {
        if (i <= 0 || i > taskList.size()) {
            throw new IllegalArgumentException("this task does not exist, genius..");
        } else {
            return taskList.get(i - 1);
        }
    }

    public void doTask(String input) {
        try {
            int number = Integer.parseInt(input.substring(5));
            Task t = getTask(number);
            System.out.println("ALRIGHT NICE I'll mark this as completed :)");
            t.markDone();
            System.out.println(t);
        }
        catch (NumberFormatException n) {
            System.out.println("OI open ur eyes and give a proper input ITS \"mark\" AND A NUMBER");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void undoTask(String input) {
        try {
            int number = Integer.parseInt(input.substring(7));
            Task t = getTask(number);
            System.out.println("Oh nooo I will mark this undone then :(");
            t.markUndone();
            System.out.println(t);
        }
        catch (NumberFormatException n) {
            System.out.println("OI open ur eyes and give a proper input ITS \"unmark\" AND A NUMBER");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        System.out.println("Added:\n" + task.toString());
    }

    public void deleteTask(String input) {
        try {
            int number = Integer.parseInt(input.substring(7));
            Task t = getTask(number);
            System.out.println(String.format("Alright say bye bye to task %d!", number));
            System.out.println(t);
            this.taskList.remove(t);
        }
        catch (NumberFormatException n) {
            System.out.println("Ugh to delete stuff, you have to input \"delete\" and the number...");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printList(String input) {
        if (!input.equals("list")) {
            throw new IllegalArgumentException("Nice job did you mean \"list\" coz what you gave wasn't an accepted input");
        } else {
            if (taskList.isEmpty()) {
                System.out.println("You do know that to SHOW a list there has to be stuff INSIDE the (currently empty) list right?");
            } else {
                for (Task t : taskList) {
                    System.out.printf("%d.%s%n", taskList.indexOf(t) + 1, t.toString());
                }
            }
        }
    }
}
