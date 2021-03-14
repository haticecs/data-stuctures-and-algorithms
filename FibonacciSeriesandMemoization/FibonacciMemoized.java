package FibonacciSeriesandMemoization;

// Memoization is optimization technique.
// It basically stores the elements and returns when they are asked for. 
// O(n) runtime
public class FibonacciMemoized {
   long[] Memo = new long[1001];
   public long fib (int n){
      if(n <= 1){
      return n;
      }
      else if(Memo[n] == 0){
         Memo[n] = fib(n-1) +fib(n-2);
      }
      return Memo[n];
   }  

   public static void main(String[] args) {

      FibonacciMemoized memoized = new FibonacciMemoized();

      System.out.println(memoized.fib(1));
      System.out.println(memoized.fib(2));
      System.out.println(memoized.fib(3));
      System.out.println(memoized.fib(4));
      System.out.println(memoized.fib(5));
      System.out.println(memoized.fib(6));
      System.out.println(memoized.fib(7));

      long startTime = System.currentTimeMillis();
      long fib = memoized.fib(50);
      System.out.println("50th fib: " + fib);
      long endTime = System.currentTimeMillis();
      long elapsedTime = (endTime - startTime);
      System.out.println("elapsedTime(ms) = " + elapsedTime);
   }
}
