import java.util.ArrayList;
import java.util.List;

public class Tree<E> {
    public Tree<E> parent;
    public E item;
    private List<Tree<E>> children = new ArrayList<>();

    public Tree(E item) {
        this.item = item;
    }

    public void addChild(Tree<E> tree) {
        children.add(tree);
        tree.parent = this;
    }

    public Tree<E> getChild(int index) {
        if (index >= 0 && index < children.size()) return children.get(index);
        return null;
    }

    public int childrenCount() {
        return children.size();
    }

    public int size() {
        int total = 1;
        for (Tree<E> filho : children) total += filho.size();
        return total;
    }
}