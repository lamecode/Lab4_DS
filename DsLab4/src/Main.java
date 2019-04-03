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
            other_tree.postOrder();
            FormingFirstSection(m, some_new, other_tree, section_indeed);
            System.out.println();
            section_indeed.postOrder();
            /*for (int i = 0; i < 10; i++) {
                System.out.println();
            }*/
        } catch (NullPointerException abc) {
            System.out.println("Tree is empty!");
        }
        /*System.out.println("САБАКА. Access denied.");
        Thread.sleep(4000);
        System.out.println("З першим квітня! =)");*/

        /* Creating object of AVL_Tree
        AVL_tree avlt = new AVL_tree();

        System.out.println("AVL_Tree Tree Test\n");
        char ch;
        *//*  Perform tree operations
        do
        {
            System.out.println("\nAVLTree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    avlt.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ avlt.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Nodes = "+ avlt.countNodes());
                    break;
                case 4 :
                    System.out.println("Empty status = "+ avlt.isEmpty());
                    break;
                case 5 :
                    System.out.println("\nTree Cleared");
                    avlt.clear();
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            *//*  Display tree  *//*
            System.out.print("\nPost order : ");
            avlt.postorder();
            System.out.print("\nPre order : ");
            avlt.preorder();
            System.out.print("\nIn order : ");
            avlt.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');*/
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
                c.insert(a.delete(n), n);
                a.preOrder();
                System.out.println();
            }
        }
    }
}
