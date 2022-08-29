import java.util.*;

public class Q1{
    public static void main(String[] args){
    
    }

    Node[] findBuildOrder(String[] nodes, String[][] dependencies){
      Graph graph = buildGraph(nodes, dependencies);
      return orderNodes(graph.getNodes());
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

    Node[] orderNodes(ArrayList<Node> nodes){
        Node[] order = new Node[nodes.size()];

        int endOfList = addNonDependent(order, nodes, 0);
        int toBeProcessed = 0;
        while(toBeProcessed < order.length){
          Node current = order[toBeProcessed];
          if(current == null){
            return null;
          }
          ArrayList<Node> children = current.getChildren();
          for(Node child: children){
            child.decrementDependencies();
          }

          endOfList = addNonDependent(order, children, endOfList);
          toBeProcessed++;
        }
        return order;
    }

    int addNonDependent(Node[] order, ArrayList<Node> nodes, int offset){
      for(Node node : nodes){
        if(node.getDependencies() == 0){
          order[offset] = node;
          offset++;
        }
      }
      return offset;
    }
}
