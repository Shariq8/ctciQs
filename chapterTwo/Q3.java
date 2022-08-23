public class Q3{
    public static void main(String[] args){
      System.out.println("Hello World"); 
    }

    public boolean deleteNode(MyLinkedList<Integer> list){
      if(list.head == null || list.head.getNext() == null){
        return false;
      }
      Node<Integer> ptr = list.head;
      Node<Integer> next = ptr.getNext();
      ptr.setValue(next.getValue());
      ptr.setNext((next.getNext()));
      return true;
    }
}
