package com.company;
import java.io.*;//импорт класса для работы с файлами
import java.util.Scanner; // импорт класса Scanner
import java.io.IOException;// импорт класса исключений ввода/вывода (I/O)

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int w = 0;
        while (w != 4) {
            System.out.println(" Выберите:");
            System.out.println("1 - Двунаправленный список");
            System.out.println("2 - Двунаправленный кольцевой список");
            System.out.println("3 - Дек");
            System.out.println("4- выход из программы");
            System.out.print(" Ваш выбор ? ");
            w = in.nextInt();
            switch (w) {
                case 1:
                    twolist(1); //вызов метода twolist для работы с двунаправленным списком
                    break;
                case 2:
                    twolist(2); //вызов метода twolist для работы с кольцевым списком
                    break;
                case 3:
                    deklist(); //вызов метода deklist для работы с деком
                    break;
            }
        }
    }
    //********** метод для работы с деком *********
    static void deklist () throws Exception {
        Scanner in = new Scanner(System.in);
        ILink link = new LinkImpl();
        String elem;
        int index;
        int W = 0;
        while (W != 12) {
            System.out.println(" Вы можете:");
            System.out.println("1 - создать список из файла");
            System.out.println("2 - записать список в файл");
            System.out.println("3 - напечатать список");
            System.out.println("4 - удалить элемент c конца списка");
            System.out.println("5 - удалить элемент c начала списка");
            System.out.println("6 - добавить элемент в конец списка");
            System.out.println("7 - добавить элемент в начало списка");
            System.out.println("8 - поиск элемента в списке");
            System.out.println("9 - вывод длины списка");
            System.out.println("10 - изменить содержимое узла");
            System.out.println("11- очистка списка");
            System.out.println("12- вернуться в предыдущее меню");
            System.out.print(" Ваш выбор ? ");
            W = in.nextInt();
            switch (W) {
                case 1:
                    try {
                        FileReader fr = new FileReader("file1.txt");
                        Scanner scan = new Scanner(fr);
                        while (scan.hasNextLine()) {
                            link.add(scan.nextLine());
                        }
                        fr.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    FileWriter nFile = new FileWriter("file2.txt");
                    Object[] data = link.toArray();
                    for (Object temp : data) {
                        nFile.write(temp + "\n");
                    }
                    nFile.close();
                    break;

                case 3:
                    if (link.size() != 0) {
                        System.out.println(" Элементы списка: ");
                        link.printLink();
                    } else System.out.println(" Cписок пуст ");
                    break;
                case 4:
                    if (link.removenext())
                        System.out.println(" Элемент успешно удален из списка ");
                    else System.out.println(" Список пуст ");
                    break;
                case 5:
                    if (link.removehead())
                        System.out.println(" Элемент успешно удален из списка ");
                    else System.out.println(" Список пуст ");
                    break;
                case 6:
                    System.out.print(" Введите текст, который нужно добавить в список: ");
                    in.nextLine();
                    elem = in.nextLine();
                    link.add(elem);
                    System.out.println(" Текст успешно добавлен в конец списка");
                    break;
                case 7:
                    System.out.print(" Введите текст, который нужно добавить в список: ");
                    in.nextLine();
                    elem = in.nextLine();
                    link.addhead(elem);
                    System.out.println(" Текст успешно добавлен в начало списка");
                    break;
                case 8:
                    System.out.print(" Введите текст, который нужно найти в списке: ");
                    in.nextLine();
                    elem = in.nextLine();
                    index = link.contains(elem);
                    if (index >= 0 && index < link.size()) {
                        index++;
                        System.out.println(" Данный элемент имеется в списке. Он находится в позиции " + index);
                    } else System.out.println(" Данный элемент не найден в списке.");
                    break;
                case 9:
                    System.out.println(" В списке " + link.size() + " элементов");
                    break;
                case 10:
                    System.out.print(" Введите индекс элемента: ");
                    index = in.nextInt();
                    if (index >= 0 && index < link.size()) {
                        System.out.println(" Введите текст, который нужно записать в позицию " + index);
                        in.nextLine();
                        elem = in.nextLine();
                        link.set(index - 1, elem);
                    } else System.out.println(" Данный элемент не найден в списке");
                    break;
                case 11:
                    link.clear();
                    break;
            }
        }
    }
    //********** метод для работы с двунаправленным списком и кольцом *********
    static void twolist (int w) throws Exception {
        Scanner in = new Scanner(System.in);
        ILink link;
        if (w==1)  //если выбрали двунаправленный список
        { link = new LinkImpl();} //создание объекта класса LinkImpl
        else {link=new Linkring();} //создание объекта класса Linkring

        String elem;
        int index;
        int W = 0;
        while (W != 10) {
            System.out.println(" Вы можете:");
            System.out.println("1 - создать список из файла");
            System.out.println("2 - записать список в файл");
            System.out.println("3 - напечатать список");
            System.out.println("4 - удалить элемент из списка");
            System.out.println("5 - добавить элемент в список");
            System.out.println("6 - поиск элемента в списке");
            System.out.println("7 - вывод длины списка");
            System.out.println("8 - изменить содержимое узла");
            System.out.println("9- очистка списка");
            System.out.println("10- вернуться в предыдущее меню");
            System.out.print(" Ваш выбор ? ");
            W = in.nextInt();
            switch (W) {
                case 1:
                    try {
                        FileReader fr = new FileReader("file1.txt");
                        Scanner scan = new Scanner(fr);
                        while (scan.hasNextLine()) {
                            link.add(scan.nextLine());
                        }
                        fr.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    FileWriter nFile = new FileWriter("file2.txt");
                    Object[] data = link.toArray();
                    for (Object temp : data) {
                        nFile.write(temp + "\n");
                    }
                    nFile.close();
                    break;

                case 3:
                    if (link.size() != 0) {
                        System.out.println(" Элементы списка: ");
                        link.printLink();
                    } else System.out.println(" Cписок пуст ");
                    break;
                case 4:
                    System.out.print(" Введите текст, который нужно удалить из списка: ");
                    in.nextLine();
                    elem = in.nextLine();
                    if (link.remove(elem))
                        System.out.println(" Элемент успешно удален из списка ");
                    else System.out.println(" Данного элемента нет в списке ");
                    break;
                case 5:
                    System.out.print(" Введите текст, который нужно добавить в список: ");
                    in.nextLine();
                    elem = in.nextLine();
                    link.add(elem);
                    System.out.println(" Текст успешно добавлен в список");
                    break;
                case 6:
                    System.out.print(" Введите текст, который нужно найти в списке: ");
                    in.nextLine();
                    elem = in.nextLine();
                    index = link.contains(elem);
                    if (index >= 0 && index < link.size()) {
                        index++;
                        System.out.println(" Данный элемент имеется в списке. Он находится в позиции " + index);
                    } else System.out.println(" Данный элемент не найден в списке.");
                    break;
                case 7:
                    System.out.println(" В списке " + link.size() + " элементов");
                    break;
                case 8:
                    System.out.print(" Введите индекс элемента: ");
                    index = in.nextInt();
                    if (index >= 0 && index < link.size()) {
                        System.out.println(" Введите текст, который нужно записать в позицию " + index);
                        in.nextLine();
                        elem = in.nextLine();
                        link.set(index - 1, elem);
                    } else System.out.println(" Данный элемент не найден в списке");
                    break;
                case 9:
                    link.clear();
                    break;
            }
        }
    }
}

interface  ILink {
    boolean add(Object data);//Добавить узел в связанный список
    int contains(Object data);//Поиск указанного узела в связанном списке. Возвращает индекс найденного узла
    boolean remove(Object data);//Удалить указанный узел. Возвращает true, если узел найден и удален
    Object set(int index,Object newData);//Изменить содержимое узла в соответствии с указанным индексом
    Object get(int index);//Возвращает содержимое узла в соответствии с указанным индексом
    void clear();//Очистка списка
    Object[] toArray();//Преобразовать связанный список в массив
    int size();//Длина списка
    void printLink();//Обход связанного списка. Вывод на экран
    boolean removehead();//Удалить первый узел
    boolean removenext();  //Удалить последний узел
    boolean addhead(Object data); //Добавить узел в начало списка
}

class LinkImpl implements ILink{
    protected Node head;
    private Node last;
    protected int size;
    protected class Node {// Внутренние и внешние классы могут получить доступ к частному домену друг друга
        protected Node prev;
        protected Object data;
        protected Node next;
        public Node(Node prev,Object data,Node next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    public boolean add(Object data){ //Добавить узел в связанный список
        Node temp = this.last;
        Node newNode = new Node(temp,data,null);
        this.last = newNode;
        if(head == null){
            this.head = newNode;
        }else{
            temp.next = newNode;
        }
        this.size++;
        return true;
    }
    public boolean addhead(Object data){ //Добавить узел в начало списка
        Node temp = this.head;
        Node newNode = new Node(null,data,temp);
        this.head = newNode;
        if(last == null){
            this.last = newNode;
        }else{
            temp.prev = newNode;
        }
        this.size++;
        return true;
    }

    public int contains(Object data){//Определить, существует ли указанный узел содержимого в связанном списке
        if(data == null){
            int i = 0;
            for(Node temp = head;temp!=null;temp = temp.next){
                if(temp.data == null){
                    return i;
                }
                i++;
            }
        }else{
            int i = 0;
            for(Node temp = head;temp!=null;temp = temp.next){
                if(temp.data.equals(data)){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
    public boolean removehead() { //Удалить первый узел
        Node temp = head;
        unLike(temp); //Удалить содержимое узла
        return true;
    }
    public boolean removenext() { //Удалить последний узел
        Node temp = last;
        unLike(temp); //Удалить содержимое узла
        return true;
    }
    public boolean remove(Object data){ //Удалить указанный узел
        if(data == null) {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    unLike(temp);//Удалить содержимое узла
                    return true;
                }
            }
        }
        else{
            for(Node temp = head;temp!=null;temp = temp.next){
                if(temp.data.equals(data)){
                    unLike(temp); //Удалить содержимое узла
                    return true;
                }
            }
        }
        return false;
    }

    private Object unLike(Node x){//Удалить содержимое узла
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        if(prev == null){
            this.head = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        if(next == null){
            this.last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        this.size--;
        return elementData;
    }

    public Object set(int index,Object newData){//Изменить содержимое узла в соответствии с указанным индексом
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        Object element = node.data;
        node.data = newData;
        return element;
    }

    public Object get(int index){//Возвращает содержимое узла в соответствии с указанным индексом
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        return node.data;
    }

    private Node node(int index){ //Получить конкретные узлы в соответствии с указанным индексом
        if(index < (size>>1)){
            Node temp = this.head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }
        Node temp = this.last;
        for(int i=size-1;i>index;i--){
            temp = temp.prev;
        }
        return temp;
    }

    private boolean isLinkIndex(int index) //Определить, является ли индекс действительным
    {
        return index>=0 && index<size;
    }

    public void clear() //Очистка списка
    {
        for(Node temp = head;temp!=null;){
            temp.data = null;
            Node node = temp.next;
            temp = temp.next = temp.prev = null;
            temp = node;
            this.size --;
        }

    }

    public Object[] toArray() //Преобразовать связанный список в массив
    {
        Object[]result = new Object[size];
        int i = 0;
        for(Node temp = head;temp!=null;temp = temp.next){
            result[i++] = temp.data;
        }
        return result;
    }

    public int size() //Длина списка
    {
        return this.size;
    }

    public void printLink(){//Обход связанного списка вывод содержимого элементов списка на экран
        Object []data = this.toArray();
        for(Object temp:data){
            System.out.println(temp);
        }
    }
}

//********   кольцо   *******************
class Linkring  extends LinkImpl{
    public boolean add(Object data){ //Добавить узел в связанный список
        // Node temp = this.last;
        Node newNode = new Node(null,data,null);
        // this.last = newNode;
        if(head == null){
            head=newNode;
            head.next = head;
            head.prev = head;
        }else{
            // temp.next = newNode;
            head.prev.next = new Node(head.prev,data, head);
            head.prev = head.prev.next;
        }
        this.size++;
        return true;
    }

    public int contains(Object data){//Определить, существует ли указанный узел содержимого в связанном списке
        if(data == null){
            int i = 0;
            Node temp = head;
            for(int j = 0;j<size;j++,temp = temp.next){
                if(temp.data == null){
                    return i;
                }
                i++;
            }
        }else{
            int i = 0;
            Node temp = head;
            for(int j = 0;j<size;j++,temp = temp.next){
                if(temp.data.equals(data)){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public boolean remove(Object data){ //Удалить указанный узел
        if(data == null) {Node temp = head;
            for ( int j = 0;j<size;j++, temp = temp.next) {
                if (temp.data == null) {
                    unLike(temp);//Удалить содержимое узла
                    return true;
                }
            }
        }
        else{
            Node temp = head;
            for(int j = 0;j<size;j++,temp = temp.next){
                if(temp.data.equals(data)){
                    unLike(temp); //Удалить содержимое узла
                    return true;
                }
            }
        }
        return false;
    }

    private Object unLike(Node x){//Удалить содержимое узла
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        if(prev == head){
            this.head = next;
        }else{
            prev.next = next;
            x.prev = head;
        }
        if(next == head){
            this.head = prev;
        }else{
            next.prev = prev;
            x.next = head;
        }
        x.data = null;
        this.size--;
        return elementData;
    }


    public Object set(int index,Object newData){//Изменить содержимое узла в соответствии с указанным индексом
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        Object element = node.data;
        node.data = newData;
        return element;
    }


    public Object get(int index){//Возвращает содержимое узла в соответствии с указанным индексом
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        return node.data;
    }

    private Node node(int index){ //Получить конкретные узлы в соответствии с указанным индексом
        if(index < (size>>1)){
            Node temp = this.head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }
        Node temp = this.head;
        for(int i=size-1;i>index;i--){
            temp = temp.prev;
        }
        return temp;
    }

    private boolean isLinkIndex(int index) //Определить, является ли индекс действительным
    {
        return index>=0 && index<size;
    }

    public void clear() //Очистка списка
    {Node temp = head;
        for(int j = 0;j<size;j++){
            temp.data = null;
            Node node = temp.next;
            temp = temp.next = temp.prev = null;
            temp = node;
            this.size --;
        }

    }

    public Object[] toArray() //Преобразовать связанный список в массив
    {
        Object[]result = new Object[size];
        int i = 0;Node temp = head;
        for(int j = 0;j<size;j++,temp = temp.next){
            result[i++] = temp.data;
        }
        return result;
    }

    public int size() //Длина списка
    {
        return this.size;
    }

    public void printLink(){//Обход связанного списка вывод содержимого элементов списка на экран
        Object []data = this.toArray();
        for(Object temp:data){
            System.out.println(temp);
        }
    }
}
