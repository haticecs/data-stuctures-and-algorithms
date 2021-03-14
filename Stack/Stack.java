package Stack;

import java.util.EmptyStackException;

// LIFO->Last In First Out
public class Stack{

   class Node{
      int data;
      Node next;

      public Node(int data){
         this.data = data;
      }
   }

   Node head;   //ADD and REMOVE THINGS HERE
   int size = 0;

   public int peek(){
      return head.data;
   }

   public boolean isEmpty(){
      return (head == null);
   }

   public void push (int data){ //O(1)
      //create newNode
      Node newNode = new Node(data);
      //set its next to be head.
      newNode.next = head;
      //update head
      head = newNode;
      size ++;
   }

   public int pop (){ //O(1)
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
      Stack stack = new Stack();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println(stack.pop()); //3
      System.out.println(stack.size); //2
      System.out.println(stack.pop()); //2
      System.out.println(stack.pop()); //1
   }
}