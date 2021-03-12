package Stack;

import java.util.EmptyStackException;

//LIFO->Last In First Out
public class Stack{

   private static class Node{
      int data;
      Node next;

      public Node(int data){
         this.data = data;
      }
   }

   private static Node head;   //ADD and REMOVE THINGS HERE
   private static int size = 0;

   public static int peek(){
      return head.data;
   }

   public static boolean isEmpty(){
      return (head == null);
   }

   private static void push (int data){ //O(1)
      //create newNode
      Node newNode = new Node(data);
      //set its next to be head.
      newNode.next = head;
      //update head
      head = newNode;
      size ++;
   }

   private static int pop (){ //O(1)
      //If the stack is empty
      if(head == null){
         throw new EmptyStackException();
      }
      //return value
      int data = head.data;
      //update the head
      head = head.next;
      size--;
      return data;
   }


   public static void main(String[] args) {
      push(1);
      push(2);
      push(3);
      System.out.println(pop()); //3
      System.out.println(size); //2
      System.out.println(pop()); //2
      System.out.println(pop()); //1
   }
   
}