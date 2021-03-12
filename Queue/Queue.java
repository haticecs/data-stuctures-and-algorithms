package Queue;

//FIFO -> First in First Out
public class Queue {

   private static class Node{
      int data;
      Node next;
      public Node(int data){
         this.data = data;
      }
   }

   public static Node head; //REMOVE THINGS HERE
   public static Node tail; //ADD THINGS HERE
   public static int size = 0;

   public static int peek(){
      return head.data;
   }

   public static boolean isEmpty(){
      return (head == null);
   }

   public static void add(int data){
      //Create new node
      Node newNode = new Node(data);

      //set tail's next to point to new node
      if(tail != null){
         tail.next = newNode;
      }
      //update tail
      tail = newNode;

      //handle the case of first element where head is null
      if(head == null){
         head = tail;
      }
      size++;
   }

   public static int remove()
   {
      //if the queue is empty...
      if(head == null){
         tail = null;
         return 0;
      }
      //store the data
      int data = head.data;
      //update head
      head = head.next;
      size --;
      return data;
   }

   public static void main(String[] args) {
      add(1);
      add(2);
      add(3);
      System.out.println(remove()); //1
      System.out.println(remove()); //2
      System.out.println(size); //1
   }
}