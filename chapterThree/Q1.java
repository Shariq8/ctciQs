import java.util.EmptyStackException;

public class Q1{
    class FixedMultiStack{
      private int numberOfStacks = 3;
      private int stackCapacity;
      private int[] values;
      private int[] sizes;

      public FixedMultiStack(int stacksize){
        stackCapacity = stacksize;
        values = new int[stacksize * numberOfStacks];
      }

      public void push(int stackNum, int value){
        if(isFull(stackNum)){
          throw new EmptyStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
      }

      public int pop(int stackNum){
        if(isEmpty(stackNum)){
          throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
      }

      public int peek(int stackNum){
        if(isEmpty(stackNum)){
          throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
      }

      public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
      }

      public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
      }

      private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size-1;
      }
    }
}
