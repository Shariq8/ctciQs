import java.util.*;

public class Q2{
    public static void main(String[] args){
      Graph graph = new Graph();
      int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
      makeBST(graph, arr, 0);
      graph.inOrderBST(graph.getNodes().get(0));
      System.out.println();
      graph.preOrderBST(graph.getNodes().get(0));
      System.out.println();
      graph.postOrderBST(graph.getNodes().get(0));
      // System.out.println(graph.getNodes().get(0).getChildren().get(1).getName());
    }

    public static Graph buildGraph(String[] nodes, String[][] dependencies){
      Graph graph = new Graph();
      for(String node : nodes){
        graph.addNode(node);
      }

      for(String[] dependency : dependencies){
        String parent = dependency[0];
        String child = dependency[1];
        graph.addEdge(parent, child);
      }

      return graph;
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
}
