import java.util.Set;
import java.util.HashSet;


public class VennDiagram<T> {

    Set<T> field1, field2, field3;
    String one, two, three;

    public VennDiagram(String label1, String label2, String label3) {

        one = label1;
        two = label2;
        three = label3;
        field1 = new HashSet<>();
        field2 = new HashSet<>();
        field3 = new HashSet<>();

    }

    private Set<T>
    getCircleForLabel(String label) {

        if (one == label) {
            return field1;
        } else if (two == label) {
            return field2;
        } else if (three == label) {
            return field3;
        } else return null;
    }

    public void add(T item, String... labels) {
        for (String label : labels) {
            getCircleForLabel(label).add(item);
        }
    }

    public Set<T> unionOf(String one, String two) {
        Set<T> sets = new HashSet<>();

        sets.addAll(getCircleForLabel(one));

        sets.addAll(getCircleForLabel(two));
        return sets;
    }

    public Set<T> intersectionOf(String one, String two) {
        Set<T> set = new HashSet<>();
        for (T item :
                getCircleForLabel(one)) {
            if (getCircleForLabel(two).contains(item)) {
                set.add(item);
            }
        }
        return set;
    }

    public Set<T> complementOf(String one, String two) {
        Set<T> set3 = new HashSet<>();
        for (T items :
                getCircleForLabel(one)) {
            if (!getCircleForLabel(two).contains(items)) {
                set3.add(items);

            }
        }
        return set3;
    }

    public Set<T> diagramCenter() {
        Set<T> set4 = new HashSet<>();
        for (T items : field1) {
            if (field2.contains(items) && field3.contains(items)) {
                set4.add(items);
            }
        }
        return set4;
    }
}