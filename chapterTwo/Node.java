public class Node<E>{
    private E value;
    private Node<E> next;

    public E setValue(E value){
        this.value = value;
        return value;
    }

    public Node<E> setNext(Node<E> next){
        this.next = next;
        return next;
    }

    public E getValue(){
        return this.value;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public Node(E value){
        this.value = value;
        this.next = null;
    }

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }
}