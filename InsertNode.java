package linkedlist;

import java.util.Scanner;

public class InsertNode {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Node<Integer> head1 = insertNode(head,80,0);
        print(head1);
    }
    public static Node<Integer> insertNode(Node<Integer> head, int data,int pos){
        Node<Integer> newNode  = new Node<>(data);
        //inserting at the staring of the node
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        int i=0;
        Node<Integer> temp = head;
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
