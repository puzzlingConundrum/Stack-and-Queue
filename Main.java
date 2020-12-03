import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String action = "";
        Scanner input = new Scanner(System.in);
        int elem;

        Stack<Integer> s1 = new NodeStack<>();
        System.out.println("===== Stack =====");
        while (!action.equals("finish")) {
            System.out.print("Command (pop/push [E]/print/finish) :: ");
            action = input.nextLine();
            if (action.equals("pop")) {
                elem = s1.pop();
                System.out.println(elem + " is popped.");
            } else if (action.startsWith("push")) {
                if (action.trim().length() == 4) {
                    System.out.println("Invalid Action. Type another command.");
                } else {
                    elem = Integer.parseInt(action.substring(5));
                    s1.push(elem);
                    System.out.println(elem + " is pushed.");
                }
            } else if (action.equals("print")) {
                System.out.println(s1);
            } else if (!action.equals("finish")) {
                System.out.println("Invalid Action. Type another command.");
            }
        }

        Queue<Integer> q1 = new NodeQueue<>();
        System.out.println("===== Queue =====");
        action = "";
        while (!action.equals("finish")) {
            System.out.print("Command (dequeue/enqueue [E]/print/finish) :: ");
            action = input.nextLine();
            if (action.equals("dequeue")) {
                elem = q1.dequeue();
                System.out.println(elem + " is dequeued.");
            } else if (action.startsWith("enqueue")) {
                if (action.trim().length() == 7) {
                    System.out.println("Invalid Action. Type another command.");
                } else {
                    elem = Integer.parseInt(action.substring(8));
                    q1.enqueue(elem);
                    System.out.println(elem + " is enqueued.");
                }
            } else if (action.equals("print")) {
                System.out.println(q1);
            } else if (!action.equals("finish")) {
                System.out.println("Invalid Action. Type another command.");
            }
        }
    }
}
