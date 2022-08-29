import java.util.*;

public class Q3{
    public static void main(String[] args){
      Graph graph = new Graph();
      int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16};
      makeBST(graph, arr, 0);
      // graph.inOrderBST(graph.getNodes().get(0));
      ArrayList<LinkedList<Node>> list = listOfDepths(graph, graph.getNodes().get(0));
      for(int i = 0; i < list.size(); i++){
        for(int j = 0; j<list.get(i).size();j++){
          System.out.print(list.get(i).get(j).getName() + " ");
        }
        System.out.println();
      }
    }

    public static Node makeBST(Graph graph, int[] arr, int i){
      Node root = null;
      if(i < arr.length){
        root = new Node(String.valueOf(arr[i]));
        graph.addNode(root);
        
        graph.addEdge(root, makeBST(graph, arr, 2*i+1));
        graph.addEdge(root, makeBST(graph, arr, 2*i+2));
      }
      return root;
    }

    public static ArrayList<LinkedList<Node>> listOfDepths(Graph graph, Node root){
      ArrayList<LinkedList<Node>> arr = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      LinkedList<Node> list = new LinkedList<>();
      list.add(root);
      arr.add(list);
      list = new LinkedList<>();
      queue.add(root);
      int offset = 1, expNum = 0;

      while(!queue.isEmpty()){
        if(expNum == offset){
          arr.add(list);
          list = new LinkedList<>();
          expNum = 0;
          offset*=2;
        }
        Node r = queue.remove();
        for(Node node : r.getChildren()){
          queue.add(node);
          list.add(node);
        }
        expNum++;
      }
      return arr;
    }
}
