import java.util.Iterator;
import java.util.LinkedList;

public class Q6{
    public static void main(String[] args){
      AnimalShelter a = new AnimalShelter();
      a.enqueue("cat");
      a.enqueue("cat");
      a.enqueue("dog");
      a.enqueue("cat");
      a.enqueue("dog");
      a.enqueue("dog");
      a.enqueue("dog");

      System.out.println(a.dequeueAny());
      System.out.println(a.dequeueDog());
      System.out.println(a.dequeueCat());
      System.out.println(a.toString());
      System.out.println(a.dequeueDog());
      System.out.println(a.toString());

    }

    static class AnimalShelter{
      private MyQueue<String> dogQueue;
      private MyQueue<String> catQueue;
      LinkedList<String> list;

      public AnimalShelter(){
        this.dogQueue = new MyQueue<>();
        this.catQueue = new MyQueue<>();
        this.list = new LinkedList<>();
      }

      public void enqueue(String type){
        if(type=="cat"){
          catQueue.add("cat");
        }else if(type=="dog"){
          dogQueue.add("dog");
        }else{
          return;
        }
        list.add(type);
      }

      public String dequeueAny(){
        String type = list.remove();
        if(type=="cat"){
          catQueue.remove();
        }else if(type=="dog"){
          dogQueue.remove();
        }
        return type;
      }

      public String dequeueDog(){
        int index = list.indexOf("dog");
        dogQueue.remove();
        String r = list.remove(index);
        return r;
      }

      public String dequeueCat(){
        int index = list.indexOf("cat");
        catQueue.remove();
        String r = list.remove(index);
        return r;
      }

      public String toString(){
        StringBuilder s = new StringBuilder();
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
          String e = it.next();
          s.append(e + " ");
        }
        return s.toString();
      }
    }
}
