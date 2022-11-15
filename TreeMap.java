import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class TreeMap<KeyType extends Comparable<KeyType>, ValueType> extends RedBlackTree<Pair<KeyType, ValueType>>  implements ITreeMap<KeyType, ValueType> {

    int size = 0;


    @Override
    public boolean put(KeyType key, ValueType value) {
        if(containsKey(key))
        {
            return false;
        }
        else {
            Pair<KeyType, ValueType> node = new Pair<>(key, value);
            insert(node);
            size++;
            return true;
        }

    }

    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if(key == null)
        {
            throw new NullPointerException("Key is null");
        }
        if(!containsKey(key))
        {
            throw new NullPointerException("Key does not exist");
        }

        Node<Pair<KeyType, ValueType>> node = NodeLookup(key);
        return node.data.getValue();
    }

    private Node<Pair<KeyType, ValueType>> NodeLookup(KeyType key) throws NoSuchElementException
    {

        Node<Pair<KeyType, ValueType>> node =  new Node<>(new Pair<>(key , null));

        while (node != null)
        {
            int compare = key.compareTo(node.data.getKey());

            if(compare > 0)
            {
                node = node.rightChild;
            }

            if(compare < 0)
            {
                node = node.leftChild;
            }

            if(compare == 0)
            {
                return node;
            }

        }
        throw new NullPointerException("Key cannot be found");
    }

    @Override
    public ValueType remove(KeyType key) { // set to null as we are not using this method.
        // the interface forces us to implement this.
        return null;
    }

    @Override
    public boolean containsKey(KeyType key) {
        if(key == null)
        {
            return false;
        }
        Pair<KeyType, ValueType> containsKey = new Pair<>(key, null);
        return contains(containsKey);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.root = null;
        size = 0;
    }

    public void traverse(Node<Pair<KeyType, ValueType>> node, ArrayList<ValueType> list)
    {
        if(node == null)
        {
            return;
        }
        traverse(node.leftChild, list);
        list.add(node.data.getValue());
        traverse(node.rightChild, list);
    }

    @Override
    public Iterator<ValueType> iterator() {
        ArrayList<ValueType> list = new ArrayList<>();

        if(this.root.rightChild != null || this.root.leftChild != null)
        {
            traverse(this.root, list);
        }

        return new Iterator<>() {
            private int currentNode = 0;

            @Override
            public boolean hasNext() {
                return currentNode < list.size();
            }

            @Override
            public ValueType next() {
                return list.get(currentNode++);
            }
        };


    }
}
