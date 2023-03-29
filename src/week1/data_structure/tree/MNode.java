package week1.data_structure.tree;

public class MNode<NK, NV> {

    public NK key;
    public NV value;
    public MNode<NK, NV> next;

    public MNode(NK key, NV value, MNode<NK, NV> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
