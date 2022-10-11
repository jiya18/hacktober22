package linkedlist;

import java.util.Scanner;

public class AddStart {
    public static void main(String[] args) {
            Node<Integer> head = takeInput();
            Node<Integer> newHead = addStart(head,10);
            print(newHead);
    }
    public static Node<Integer> addStart(Node<Integer> head,int data){
        Node<Integer> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static Node<Integer> takeInput(){
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
//                Node<Integer> temp = head;
//                while(temp.next!=null){
//                    temp = temp.next;
//                }
//                temp.next = newNode;
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        return  head;
    }
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
