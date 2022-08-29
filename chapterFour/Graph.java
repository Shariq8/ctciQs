import java.util.*;

public class Graph{
   public HashMap<String, Node> nodes;
   public ArrayList<Node> nodeList = new ArrayList<>();

    public Graph(){
        this.nodes = new HashMap<>();
    }

    public Node addNode(String name){
        if(!nodes.containsKey(name)){
            Node node = new Node(name);
            nodeList.add(node);
            nodes.put(name,node);
        }
        return nodes.get(name);
    }

    public Node addNode(Node node){
        if(!nodes.containsKey(node.getName())){
            nodeList.add(node);
            nodes.put(node.getName(), node);
        }
        return nodes.get(node.getName());
    }

    public void addEdge(String src, String dest){
        Node start = addNode(src);
        Node end = addNode(dest);
        start.addNeighbour(end);
    }

    public void addEdge(Node src, Node dest){
        src.addNeighbour(dest);
    }

    public ArrayList<Node> getNodes() { return nodeList; }

    void inOrderBST(Node node){
        if(node != null){
            if(node.getChildren().size() > 0) inOrderBST(node.getChildren().get(0));
            System.out.print(node.getName() + " ");
            if(node.getChildren().size() > 1) inOrderBST(node.getChildren().get(1));
        }
    }

    void preOrderBST(Node node){
        if(node != null){
            System.out.print(node.getName() + " ");
            if(node.getChildren().size() > 0) preOrderBST(node.getChildren().get(0));
            if(node.getChildren().size() > 1) preOrderBST(node.getChildren().get(1));
        }
    }

    void postOrderBST(Node node){
        if(node != null){
            if(node.getChildren().size() > 0) postOrderBST(node.getChildren().get(0));
            if(node.getChildren().size() > 1) postOrderBST(node.getChildren().get(1));
            System.out.print(node.getName() + " ");
        }
    }
    
    public String toString(){//Demonstrates proof of concept
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String,Node> entry : nodes.entrySet()){
            str.append(entry.getKey() + ": ");
            Node child = entry.getValue();
            for(int i = 0;i < child.getChildren().size(); i++){
                str.append(child.getChildren().get(i).getName() + " ");
            }
            str.append('\n');
        }
        return str.toString();
    }
}

class Node{
    private String name;
    private ArrayList<Node> children = new ArrayList<>();
    private HashMap<String, Node> map = new HashMap<>();
    private int dependencies = 0;

    public Node(String name){
        this.name = name;
    }

    public void addNeighbour(Node node){
        if(node == null) return;
        if(!map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() { dependencies++; }
    public void decrementDependencies() { dependencies--; }

    public String getName() { return this.name; }
    public ArrayList<Node> getChildren() { return this.children; }
    public int getDependencies() { return dependencies; }

}


// public Node addNode(String node){
    //     if(nodes.containsKey(node)) return false; //Does not allow for duplicate nodes
    //     Node n = new Node(node);
    //     if(size == 0) root = n;
    //     size++;
    //     nodes.put(node, n);
    //     return true;
    // }
    
    //Can only add an edge if it exists
    // public boolean addEdge(String src, String dest){
    //     if(nodes.containsKey(src) && nodes.containsKey(dest)){
    //         Node srcN = nodes.get(src);
    //         Node destN = nodes.get(dest);
    //         srcN.children.add(destN);
    //     }else if(nodes.containsKey(src)){
    //         Node srcN = nodes.get(src);
    //         Node destN = new Node(dest);
    //         srcN.children.add(destN);
    //         nodes.put(dest, destN);
    //     }else if(nodes.containsKey(dest)){
    //         Node destN = nodes.get(dest);
    //         Node srcN = new Node(src);
    //         srcN.children.add(destN);
    //         nodes.put(src, srcN);
    //     }else return false;
    //     return true;
    // }

    // public void DFS(Node root){
    //     //Have an array of all the nodes, which denotes if they are visited or not
    //     if(root == null) return;
    //     root.visited = true;
    //     System.out.println(root.name + " ");
    //     for(Node child : root.children){
    //         if(!child.visited){
    //             DFS(child);
    //         }
    //     }
    // }

    // public void BFS(Node root){
    //     Queue<Node> queue = new LinkedList<>();
    //     root.visited = true;
    //     queue.add(root);

    //     while(!queue.isEmpty()){
    //         Node r = queue.remove();
    //         System.out.println(r.name + " ");
    //         for(Node child : r.children){
    //             if(!child.visited){
    //                 child.visited = true;
    //                 queue.add(child);
    //             }
    //         }
    //     }
    // }

    // public void reset(){
    //     for(Map.Entry<String,Node> entry : nodes.entrySet()){
    //         entry.getValue().visited = false;
    //     }
    // }