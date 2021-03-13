package LinkedList;
public class LinkedList{
   
   class Node{
      int data;
      Node next;

      public Node(int data){
         this.data = data;
      }
  }      

   Node head;
   int size;

   public void addFront(int data){
      //Add new node
      Node newNode = new Node(data);

      //if head is null
      if(head == null){
         head = newNode;
         size++;
         return;
      }

      //Set it's next pointer to the current head
      newNode.next = head;

      //Update the head
      head = newNode;

      size++;
   }

   public int getFirst(){
      //if list is empty
      if(head == null){
         throw new IllegalStateException("List is empty");
      }
      return head.data;
   }

   public int getLast(){
      //if list is empty
      if(head == null){
         throw new IllegalStateException("List is empty");
      }
      //traverse the list, find the node which points to the NULL.
      Node current = head;
      while(current.next != null){
         current = current.next; // O(n)
      }
      //we found TAIL.
      return current.data;
   }

   public void addBack(int data){
       //create newNode
      Node newNode = new Node(data);

      //if list is empty, it will became head.
      if(head == null){
         head = newNode;
         size++;
         return;
      }

      //start at the head 
      Node current = head;

      //traverse the list until TAIL
      while(current.next != null){     //O(n)
         current = current.next;
      }

      //we found tail.
      //let tail points to the newNode.
      current.next = newNode;

      size++;
   }

   public int getSize(){
      //if linked list is empty
      if(head == null) return 0;

      //initialize size as 1
      int size = 1;
      Node current = head;

      //traverse list and increase size
      while(current.next != null)
      {
         current = current.next;
         size ++;
      }
      return size;
   }

   public void clear(){
      head = null;
      size = 0;
   }

   public void deleteValue(int value){
      //if head
      if(head == null){
         return;
      }
      if(head.data == value){
         head = head.next;
         return;
      }

      //else walk the list
      //check from PREVIOUS NODE
      //if the data of the next node is equals to the value

      Node current = head;
      while(current.next != null){
         if(current.next.data == value){
            current.next = current.next.next;   //pass the node
            size --;
            return;
         }
         current = current.next;
      }
   }

  public static void main(String[] args) {
   LinkedList linkedList = new LinkedList();
   linkedList.addFront(1);
   linkedList.addFront(0);
   linkedList.addBack(2);
   linkedList.addBack(3);
   System.out.println(linkedList.getFirst()); // 0
   System.out.println(linkedList.getLast());  //3

   System.out.println(linkedList.getSize());  //4
   System.out.println(linkedList.size);  //4

   linkedList.clear();
   System.out.println(linkedList.getSize());  //0
   System.out.println(linkedList.size);  //0

   linkedList.addBack(1);
   linkedList.addBack(2);
   linkedList.addBack(3);

   linkedList.deleteValue(2);

   System.out.println(linkedList.getSize());  //2
   System.out.println(linkedList.size);  //2

   System.out.println(linkedList.getFirst());  //1
   System.out.println(linkedList.getLast());  //3

  }
}