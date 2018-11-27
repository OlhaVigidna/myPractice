package collections.ThirdTask;

import java.util.Comparator;

public class SortByBribe implements Comparator<Deputy> {
    @Override
    public int compare(Deputy o1, Deputy o2) {
        return  o2.getSizeOfGrafte()-o1.getSizeOfGrafte();
    }
}
