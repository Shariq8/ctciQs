public class Q2{
    public static void main(String[] args){
      MyLinkedList<Integer> list = new MyLinkedList<>();
      list.add(2);
      list.add(4);
      list.add(6);
      list.add(4);
      list.add(5);
      list.add(9);
      System.out.println(list.toString());
      System.out.println(kThNode(list, 3));
    }


    public static Integer kThNode(MyLinkedList<Integer> list, int k){
      if(list.head == null){
        return 0;
      }

      int index = list.size() - k, count = 0;
      while(count != index){
        list.head = list.head.getNext();
        count++;
      }
      return list.head.getValue();
    }
}
