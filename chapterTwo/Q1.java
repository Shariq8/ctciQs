import java.util.HashSet;

public class Q1{
    public static void main(String[] args){
      MyLinkedList<Integer> list = new MyLinkedList<>();
      list.add(3);
      list.add(2);
      list.add(5);
      list.add(6);
      list.add(2);
      list.add(4);
      list.add(4);
      list.add(8);
      System.out.println(list.toString());
      deleteDups(list);
    }

    public static MyLinkedList<Integer> deleteDups(MyLinkedList<Integer> list){
      //Idea - iterate through the list, see if the hashset already contains the value, if so, remove it. Otherwise continue
      HashSet<Integer> set = new HashSet<Integer>();
      Node<Integer> previous = new Node<>(null);
      Node<Integer> ptr = list.head;
      while(ptr != null){
        if(set.contains(ptr.getValue())){
          previous.setNext(ptr.getNext()); 
        }else{
          set.add(ptr.getValue());
          previous = ptr;
        }
        ptr = ptr.getNext();
      }

      System.out.println(list.toString());
      return list;
    }
}
