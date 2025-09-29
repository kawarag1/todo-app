package org.example;

import java.util.List;
import java.util.Scanner;


public class TodoApp {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Todo CLI. Commands: add <task>, remove <index>, list, exit");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();
            switch (cmd) {
                case "add":
                    if (parts.length > 1) {
                        list.add(parts[1]);
                        System.out.println("Added.");
                    } else {
                        System.out.println("Usage: add <task>");
                    }
                    break;
                case "remove":
                    if (parts.length > 1) {
                        try {
                            int idx = Integer.parseInt(parts[1]);
                            if (list.remove(idx)) System.out.println("Removed.");
                            else System.out.println("Index out of range.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("Usage: remove <index>");
                    }
                    break;
                case "clear":
                    list.clear();
                    System.out.println("All tasks cleared.");
                    break;
                case "done":
                    if (parts.length > 1) {
                        try {
                            int idx = Integer.parseInt(parts[1]);
                            if (list.markDone(idx)) System.out.println("Marked as done.");
                            else System.out.println("Index out of range.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("Usage: done <index>");
                    }
                    break;
                case "search":
                    if (parts.length > 1) {
                        List<String> found = list.search(parts[1]);
                        if (found.isEmpty()) {
                            System.out.println("No tasks found.");
                        } else {
                            for (int i = 0; i < found.size(); i++) {
                                System.out.printf("%d: %s%n", i, found.get(i));
                            }
                        }
                    } else {
                        System.out.println("Usage: search <string>");
                    }
                    break;
                case "list":
                    List<String> all = list.getAll();
                    for (int i = 0; i < all.size(); i++) {
                        System.out.printf("%d: %s%n", i, all.get(i));
                    }
                    if (all.isEmpty()) System.out.println("(empty)");
                    break;
                case "exit":
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Commands: add, remove, list, exit");
            }
        }
    }
}
