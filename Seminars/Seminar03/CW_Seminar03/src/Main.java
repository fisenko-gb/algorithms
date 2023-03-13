/*
  Задание 1 (тайминг 5 минут)
1.Реализуем простой односвязный список.
2.Пишем только структуру, никаких методов не требуется
-----------------------------------------------------------------------
  Задание 2 (тайминг 10 минут)
1.Реализуем метод добавления новых элементов в начало списка и удаление
первого элемента связного списка.
2.Односвязный список всегда имеет ссылку на первый элемент
последовательности, потому именно с реализации методов для первого
элемента последовательности стоит начать
-----------------------------------------------------------------------
  Задание 3 (тайминг 10 минут)
1.Реализуем метод поиска элемента в односвязном списке для проверки
наличия элемента внутри списка.
2.Для корректной работы со связным список необходимо понимать, как именно
можно обходить все значения внутри связного списка.
3.Для нашего примера проще всего будет написать метод поиска значения в
связном списке и возвращения из метода информации о наличии искомого
внутри списка.

public Node FindEl(int key) {

}
-----------------------------------------------------------------------
   Задание 4 (тайминг 10 минут)
1.Реализуем метод добавления новых элементов в конец списка и удаление
последнего элемента связного списка.
2.Теперь, когда мы понимаем, как можно искать значения внутри связного
списка, мы можем сделать методы добавления и удаления элементов в конец
нашего односвязного списка.

------------------------------------------------
    Задание 5
1. Расширяем структуру связного списка до двухсвязанного

--------------------------------------------------
    Задание 6
1. Обновить методы исходя из задания 5
*/


import java.util.Random;

// Связанный список
 class LinkedList{
    private Node head;
    private Node tail;

    class Node{
        private int value;
        private Node nextNode;
        // Задание 5 (превращаем односвязанный список в двухсвязанный)
        private Node previousNode; // хранит предыдущий элемент
    }

    // Задание 2
    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        node.nextNode = head;
        head = node;
    }

    public void dellFirst(){
        head = head.nextNode;
    }

    // Задание 3
    public Node FindEl(int key) {
        Node node = head;
        while (node != null){
            if (node.value == key)
                return node;
            node = node.nextNode;
        }
        return new Node();
    }

    // Задание 4
    public void addEnd(int value){
        Node node = new Node();
        node.value = value;
        tail.nextNode = node;
        tail = node;
    }

    public void deleteEnd(){
        Node node = head;
        while (node.nextNode != tail)
            node = node.nextNode;

        tail = node;
        tail.nextNode = new Node();
    }

    // Домашнее задание "Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор)."
    public void reverseList() {
        Node prev = null;
        Node current = this.head;
        Node next;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }

    public void printList() {
        Node node = head;
        while (node != null){
            System.out.print(node.value + ", ");
            node = node.nextNode;
        }
        System.out.println();
    }

    public void generateRandomList(int size) {

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            this.addFirst(random.nextInt(size)); // генерируем случайное число от 0 до size
        }

    }

}

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.generateRandomList(10);
        System.out.println("Исходный список: ");
        list.printList();
        list.reverseList();
        System.out.println("Перевернутый список: ");
        list.printList();

    }
}



