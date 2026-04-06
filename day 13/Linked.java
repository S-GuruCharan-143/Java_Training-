class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node head;
    public void insertAtStart(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void display(){
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println(temp.data+"->"+"null");
    }

    
}

public class Linked{
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertAtStart(6);
        list.insertAtStart(5);
        list.insertAtEnd(2);
        list.display();
    }   
}
