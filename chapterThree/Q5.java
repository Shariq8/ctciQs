public class Q5{
    public static void main(String[] args){
      MyStack<Integer> stack = new MyStack<>();
      stack.push(5);
      stack.push(6);
      stack.push(75);
      stack.push(85);
      stack.push(14);
      stack.push(8);
      System.out.println(toString(sortStack(stack)));
    }

    // public static MyStack<Integer> sortStack(MyStack<Integer> stack){
    //   MyStack<Integer> s = new MyStack<>();
    //   MyStack<Integer> result = new MyStack<>();
    //   Integer largest;
    //   while(true){
    //     largest = -999;
    //     while(!stack.isEmpty()){ //While the stack is not empty
    //       if(stack.peek() > largest){
    //         largest = stack.peek();
    //       }
    //       s.push(stack.pop());
    //     }
    //     result.push(largest);
    //     while(!s.isEmpty()){
    //       if(s.peek() == result.peek()) s.pop();
    //       else stack.push(s.pop());
    //     }
    //     if(stack.isEmpty()) break;
    //   }
    //   return result;
    // }

    //Book solution:
    public static MyStack<Integer> sortStack(MyStack<Integer> stack){
      MyStack<Integer> s = new MyStack<>();
      while(!stack.isEmpty()){
        int tmp = stack.pop();
        while(!s.isEmpty() && s.peek() > tmp){
          stack.push(s.pop());
        }
        s.push(tmp);
      }

      while(!s.isEmpty()){
        stack.push(s.pop());
      }
      return stack;
    }


    public static String toString(MyStack<Integer> stack){
      MyStack<Integer> s = stack;
      StringBuilder res = new StringBuilder();
      while(!s.isEmpty()){
        res.append(s.pop() + " ");
      }
      return res.toString();
    }
}
