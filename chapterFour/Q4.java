import java.util.*;

public class Q4{
    public static void main(String[] args){
      String[] nodes = new String[]{"1","2","3","4","5","6"};
      String[][] dependencies = new String[][]
      {
        {"1","2"},
        {"1","3"},
        {"2","4"},
        {"2","5"}
        // {"5","6"}
      };
      Graph graph = buildGraph(nodes, dependencies);
      graph.inOrderBST(graph.getNodes().get(0));
      System.out.println();
      System.out.println(heightBalanced(graph.getNodes().get(0),new Height()));
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

    //To check for self balancing tree
    public static boolean heightBalanced(Node root, Height height){
        // Check for emptiness
        if (root == null) {
          height.height = 0;
          return true;
        }
    
        Height leftHeighteight = new Height();
        Height rightHeighteight = new Height();

        boolean l = true, r = true;
        if(root.getChildren().size() > 0){
          l = heightBalanced(root.getChildren().get(0), leftHeighteight);
        }
        if(root.getChildren().size() > 1){
          r = heightBalanced(root.getChildren().get(1), rightHeighteight);
        }
        int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;
        
        height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
          return false;
    
        else
          return l && r;
    }

    static class Height {
      int height = 0;
    }
    
}
