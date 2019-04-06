import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try {
            Scanner Lab = new Scanner(System.in);
            System.out.println("Введіть к-сть елементів дерева:");
            AVL_tree some_new = new AVL_tree();
            AVL_tree other_tree = new AVL_tree();
            AVL_tree section_indeed = new AVL_tree();
            int m = Lab.nextInt();
            while (m < 0) {
                System.out.println("Введіть невід'ємне значення m.");
            }
            System.out.println("Введіть к-сть дерев:");
            int n = Lab.nextInt();
            while (n < 1) {
                System.out.println("Введіть значення m, ");
            }
            Filling_Tree (m, some_new);
            Filling_Tree (m, other_tree);
            some_new.preOrder();
            System.out.println();
            other_tree.preOrder();
            System.out.println();
            FormingFirstSection(m, some_new, other_tree, section_indeed);
            System.out.println();
            section_indeed.postOrder();
        } catch (NullPointerException abc) {
            System.out.println("Tree is empty!");
        }

    }

    public static void Filling_Tree (int n, AVL_tree a) {
        for (int i = 0; i < n; i++) {
            a.insert(new Random().nextInt(10), i + 1);
        }
    }

    public static void FormingFirstSection (int n, AVL_tree a, AVL_tree b, AVL_tree c) {
        if (a.isEmpty() || b.isEmpty()) {
            System.out.println("Перерізом є пуста множина.");
        } else {
            while (!a.isEmpty()) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (a.search(i) == b.search(j)) {
                            c.insert(a.search(i), i);
                            break;
                        }
                    }
                    a.delete(i);
                }
            }
        }
    }

}
