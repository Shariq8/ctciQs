import java.util.ArrayList;

public class Q3{

    public static class SetOfStacks extends MyStack<Integer>{
        private int capacity;
        private ArrayList<Integer> sizes;
        private ArrayList<MyStack<Integer>> list;
    
        public SetOfStacks(int capacity){
            this.capacity = capacity;
            this.sizes = new ArrayList<>();
            this.list = new ArrayList<>();
            list.add(new MyStack<>());
            sizes.add(0);
        }
    
        public void push(int value){
            if(sizes.get(sizes.size()-1)< capacity){
                list.get(list.size()-1).push(value);
                sizes.set(sizes.size()-1, sizes.get(sizes.size()-1)+1);
            }else{
                list.add(new MyStack<>()); 
                list.get(list.size()-1).push(value);
                sizes.add(1); 
            }  
        }
    
        public Integer pop(){
            int value;
            int index = sizes.get(sizes.size()-1);
            if(index-1 == 0){
                value = list.get(list.size()-1).pop();
                list.remove(list.size()-1);
                sizes.remove(sizes.size()-1); 
            }else{
                value = list.get(list.size()-1).pop();
                sizes.set(sizes.size()-1, sizes.get(sizes.size()-1)-1);
            }
            return value; 
        }
    
        public String toString(){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < sizes.get(i); j++){
                    System.out.print(list.get(i).pop() + " ");
                }
                System.out.println();
            }
            return str.toString();
        }
    }   
}


