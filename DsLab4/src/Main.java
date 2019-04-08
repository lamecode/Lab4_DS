import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Lab = new Scanner(System.in);
        System.out.println("Введіть к-сть елементів дерева:");
        int m = Lab.nextInt();
        while (m < 0) {
            System.out.println("Введіть невід'ємне значення m.");
        }
        System.out.println("Введіть к-сть дерев:");
        int n = Lab.nextInt();
        while (n < 1) {
            System.out.println("Введіть значення m, не менше за 1. ");
        }
        AVL_tree some_new = new AVL_tree();
        AVL_tree other_tree = new AVL_tree();
        switch (n) {
            case 1: Filling_Tree (m, some_new);
                System.out.println("Шуканий переріз - ");
                some_new.preOrder();
                System.out.println(" (обхід в прямому порядку)");
                some_new.postOrder();
                System.out.println(" (обхід в оберненому порядку)");
                some_new.InOrder();
                System.out.println(" (обхід у центральному порядку)");
                break;
            case 2: Filling_Tree (m, some_new);
                Filling_Tree (m, other_tree);
                System.out.println("Дерево 1");
                some_new.preOrder();
                System.out.println("\n" + "Дерево 2");
                other_tree.preOrder();
                AVL_tree cross_section = FormingFirstSection(m, some_new, other_tree);
                if (cross_section.isEmpty()) {
                    System.out.println("Перерізом є пуста множина.");
                    break;
                }
                System.out.println("\n" + "Шуканий переріз - ");
                cross_section.preOrder();
                System.out.println(" (обхід в прямому порядку)");
                cross_section.postOrder();
                System.out.println(" (обхід в оберненому порядку)");
                cross_section.InOrder();
                System.out.println(" (обхід у центральному порядку)");
                break;
            default: Filling_Tree (m, some_new);
                Filling_Tree (m, other_tree);
                System.out.println("Дерево 1");
                some_new.preOrder();
                System.out.println("\n" + "Дерево 2");
                other_tree.preOrder();
                cross_section = FormingFirstSection(m, some_new, other_tree);
                for (int i = 1; i < n - 1; i++) {
                    other_tree.clear();
                    Filling_Tree(m, other_tree);
                    System.out.println("\n" + "Дерево " + (i + 2));
                    other_tree.preOrder();
                    cross_section = FormingFirstSection(m, other_tree, cross_section);
                    if (cross_section.isEmpty()) {
                        System.out.println("\n" + "Перерізом є пуста множина.");
                        break;
                    }
                }
                if (cross_section.isEmpty()) {
                    break;
                }
                System.out.println("\n" + "Шуканий переріз - ");
                cross_section.preOrder();
                System.out.println(" (обхід в прямому порядку)");
                cross_section.postOrder();
                System.out.println(" (обхід в оберненому порядку)");
                cross_section.InOrder();
                System.out.println(" (обхід у центральному порядку)");
                break;

        }

    }

    public static void Filling_Tree (int n, AVL_tree a) {
        for (int i = 0; i < n; i++) {
            a.insert(new Random().nextInt(10), i + 1);
        }
    }

    public static AVL_tree FormingFirstSection (int n, AVL_tree a, AVL_tree b) {
        AVL_tree c = new AVL_tree();
        int m;
        if (a.isEmpty() || b.isEmpty()) {
            System.out.println("Перерізом є пуста множина.");
        } else {
            m = 1;
            while (!a.isEmpty()) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (a.search(i) == b.search(j) && a.bool_search(i) && b.bool_search(j)) {
                            c.insert(a.search(i), m);
                            b.delete(j);
                            m++;
                            break;
                        }
                    }
                    if (a.bool_search(i))
                        a.delete(i);
                }
            }
        }
        return c;
    }

    public static void FinalSection(int m, int n, AVL_tree b, AVL_tree c, AVL_tree d) {
        int p = 1;
        boolean found = false;
        if (c.isEmpty()) {
            System.out.println("\n" + "Перерізом є пуста множина.");
        } else {
            for (int i = 1; i <= n - 2 && !c.isEmpty(); i++) {
                if (!b.isEmpty()) {
                    b.clear();
                }
                Filling_Tree(m, b);
                System.out.println("\n" + "Дерево " + (i + 2));
                b.preOrder();
                for (int k = 1; k <= m; k++) {
                    for (int j = 1; j <= m; j++) {
                        if (c.bool_search(k) && b.bool_search(j) && c.search(k) == b.search(j)) {
                            found = true;
                            b.delete(j);
                            break;
                        }
                    }
                    if (!found && c.bool_search(k)) {
                        c.delete(k);
                    }
                }
            }

        }
    }

}
