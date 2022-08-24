public class Q4{
    public static void main(String[] args){
      QueueViaStack q = new QueueViaStack();
      q.add(5);
      q.add(6);
      q.add(7);
      q.add(8);
    }

    public static class QueueViaStack{
      private MyStack<Integer> s1;
      private MyStack<Integer> s2;

      public QueueViaStack(){
        this.s1 = new MyStack<>();
        this.s2 = new MyStack<>();
      }

      public void add(int value){
        this.s1.push(value);
      }
    
      public Integer remove(){
        while(!s1.isEmpty()){
          s2.push(s1.pop());
        }
        int value = s2.pop();
        while(!s2.isEmpty()){
          s1.push(s2.pop());
        }
        return value;
      }

      public Integer peek(){
        while(!s1.isEmpty()){
          s2.push(s1.pop());
        }
        int value = s2.peek();
        while(!s2.isEmpty()){
          s1.push(s2.pop());
        }
        return value;
      }

      public boolean isEmpty(){
        return s1.isEmpty();
      }
    }
}
