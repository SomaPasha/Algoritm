import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class HashTableImpl<K,V> implements  HashTable<K,V> {




    static  class Item<K,V> implements Entry<K,V>{


        private   K key;
        private  V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value= value;
        }
        @Override
        public void setKey(K key) {
            this.key= key;
        }


        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private final  Item<K,V>[] data;
    private ArrayList<Deque<Item<K,V>>> nextData;

    public HashTableImpl(int initialCapacity) {
        this.data =  new Item[initialCapacity*2];
        nextData = new ArrayList<>();
        for (int i = 0; i <initialCapacity*2 ; i++) {
            nextData.add(new LinkedList());
        }
        emptyEntry = new Item<>(null,null);
    }

    public HashTableImpl() {
        this(16);
    }

    private final Item<K,V>  emptyEntry;

    private int size;

    @Override
    public boolean put(K key, V value) {
        if(size()== data.length) {
            return  false;
        }
        int index = hashFunc(key);
        if (index<0)  {
            index= index*-1;
        }
            data[index] =new Item<>(key, value);
            Deque<Item<K,V>> deque = nextData.get(index);
            deque.add(data[index]);
            nextData.set(index, deque);
            size++;
            return  false;
    }

    private boolean isKeyEquals(Item<K,V> item, K key) {
        if(item == emptyEntry){
            return false;
        }
        return  item.getKey()== null  ? key==null : item.getKey().equals(key);
    }

    public int getStep( K key) {
        return 1;
    }

    private int hashFunc(K key) {
        return key.hashCode()%data.length;


    }

    @Override
    public V get(K key) {
        int index =hashFunc(key);
      if (index==-1 ){ return  null ;} else {
          for ( Item<K,V> item:
          nextData.get(index) ) {
               if (item.getKey()!=null){
              if(item.getKey().equals(key)){
                  return item.getValue();
              }}
          }
      }
      return  null;
    }

    private int indexOf(K key) {
        int index =hashFunc(key);
        int count =0;
        while (count<data.length){
        Item<K,V> item = data[index];
        if(item == null){
            break;
        } else  if (isKeyEquals(data[index], key)){
            return index;
        }

        count++;
        index+=getStep(key);
        index%= data.length;
        }
        return  -1;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (index==-1){
            return  null;
        }
        Item <K,V> temp=null;
        for ( Item<K,V> item:
                nextData.get(index) ) {
            if(item.getKey().equals(key)){
                temp = item;
                 item.setValue(null);
                 item.setKey(null);
               // item=emptyEntry;
            }
        }


        return temp.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size!=0;
    }

    @Override
    public void display() {
        System.out.println("------------------------");
        for (int i = 0; i < nextData.size(); i++) {
            System.out.printf("%d = [%s]%n", i, nextData.get(i));
        }
        System.out.println("------------------------");
    }
}
