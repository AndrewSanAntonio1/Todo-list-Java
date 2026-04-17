package TodoList;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Task {
    private String title;
    private boolean done;
    
    Task (String title) {
        this.title = title;
        this.done = false;
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    
    @Override
    public String toString() {
        return (done ? "[✓]" : "[ ]") + title;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many you want to save task? : ");
		int limit = Integer.parseInt(scanner.nextLine());
		List<Task> tasks = new ArrayList<>();
		
		for (int i = 0; i < limit; i++) {
		    System.out.print("Enter your task: ");
		    String title = scanner.nextLine();
		    tasks.add(new Task(title));
		}
		tasks.forEach(task -> {
		    if (task.getTitle().equals(tasks.get(0).getTitle())) {
		        task.setDone(true);
		    }
		});
		
		System.out.println("--- All Tasks ---");
		tasks.forEach(System.out::println);
		
		System.out.println("\n--- PENDING TASKS ---");
        tasks.stream()
                .filter(task -> !task.isDone())
                .forEach(System.out::println);

        tasks.sort((t1, t2) -> t1.getTitle().compareTo(t2.getTitle()));

        System.out.println("\n--- SORTED TASKS ---");
        tasks.forEach(System.out::println);
	}
}