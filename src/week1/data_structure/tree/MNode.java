package week1.data_structure.tree;

import java.util.Map;

public class MNode<NK, NV> implements Map.Entry<NK, NV> {

    public NK key;
    public NV value;
    public MNode<NK, NV> next;

    public MNode(NK key, NV value, MNode<NK, NV> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public NK getKey() {
        return key;
    }

    @Override
    public NV getValue() {
        return value;
    }

    @Override
    public NV setValue(NV value) {
        NV old = this.value;
        this.value = value;
        return old;
    }
}
