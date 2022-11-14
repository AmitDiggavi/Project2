public class Pair<KeyType extends Comparable<KeyType>, ValueType> implements Comparable<Pair<KeyType, ValueType>> {

    private final KeyType key;
    private final ValueType value;

    public Pair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }


    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }


    @Override
    public int compareTo(Pair<KeyType, ValueType> compare) {
        return key.compareTo(compare.key);
    }
}
