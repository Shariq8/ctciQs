import java.lang.StringBuilder;

public class MyLinkedList<E>{
    public Node<E> head;
    private int count;

    public MyLinkedList(){
        this.head = null;
        this.count = 1;
    }

    public void clear(){
        this.head = null;
        this.count = 1;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public boolean add(E value){
        if(head == null){
            this.head = new Node<>(value);
            return true;
        }
        Node<E> temp = new Node<>(value);
        temp.setNext(head);
        this.head = temp;
        this.count++;
        return true;
    }
    
    public boolean addLast(E value){
        if(head == null){
            this.head = new Node<>(value);
            return true;
        }
        Node<E> ptr = this.head;
        while(ptr.getNext() != null){
            ptr = ptr.getNext();
        }
        ptr.setNext(new Node<>(value));
        count++;
        return true;
    }

    public boolean contains(E element){
        Node<E> ptr = this.head;
        while(ptr.getNext() != null){
            if(ptr.getValue().equals(element)) return true;
            ptr = ptr.getNext();
        }
        return false;
    }

    public int indexOf(E element){
        Node<E> ptr = this.head;
        int index = 0;
        while(ptr.getNext() != null){
            if(ptr.getValue().equals(element)) return index;
            ptr = ptr.getNext();
            index++;
        }
        return -1;
    }

    public E get(int index){
        if(index > this.count || index < 0) throw new IndexOutOfBoundsException("Index is not in linked list length");
        Node<E> ptr = head;
        int i = 1;
        while(i != index){
            ptr = ptr.getNext();
            i++;
        }
        return ptr.getValue();
    }

    public E set(int index, E element){
        if(index > this.count || index < 0) throw new IndexOutOfBoundsException("Index is not in linked list length");
        Node<E> ptr = this.head;
        int i = 0;
        while(i != index){
            ptr = ptr.getNext();
            i++;
        }
        E temp = ptr.getValue();
        ptr.setValue(element);
        return temp;
    }

    public boolean remove(E element){
        Node<E> ptr = this.head;
        
        if(ptr.getValue().equals(element)){
            if(this.count == 0){
                this.head = null;
                return true;
            } 
            else{
                this.head = this.head.getNext();
                ptr = null;
                return true;
            }
        }
        while(ptr.getNext() != null){
            if(ptr.getNext().getValue().equals(element)){
                if(ptr.getNext().getNext() == null){
                    ptr.setNext(null);
                    return true;
                }else{
                    ptr.setNext(ptr.getNext().getNext());
                    return true;
                }
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        if(this.head == null) return "[]";
        Node<E> ptr = this.head;
        while(ptr.getNext()!=null){
            str.append(ptr.getValue() + " -> ");
            ptr = ptr.getNext();
        }
        str.append(ptr.getValue());
        return str.toString();
    }
}