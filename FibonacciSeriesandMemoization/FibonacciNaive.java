package FibonacciSeriesandMemoization;

// Naive approach 
// O(2^n) runtime
public class FibonacciNaive {

   public long fib (int n){
      if(n <= 1){
      return n;
      }
      else{
         return fib(n-1) +fib(n-2);
      }
   }  

   public static void main(String[] args) {

      FibonacciNaive naive = new FibonacciNaive();

      System.out.println(naive.fib(1));
      System.out.println(naive.fib(2));
      System.out.println(naive.fib(3));
      System.out.println(naive.fib(4));
      System.out.println(naive.fib(5));
      System.out.println(naive.fib(6));
      System.out.println(naive.fib(7));

      long startTime = System.currentTimeMillis();
      long fib = naive.fib(50);
      System.out.println("50th fib: " + fib);
      long endTime = System.currentTimeMillis();
      long elapsedTime = (endTime - startTime) ;
      System.out.println("elapsedTime(ms) = " + elapsedTime); 
   }
}
