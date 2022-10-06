import java.util.*;
import java.lang.*;
public class wordSorter {
    public static HashMap<String, Integer>
    sortByValue(HashMap<String, Integer> hashMap)
    {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(
                hashMap.entrySet());
        Collections.sort(
            list,
            new Comparator<Map.Entry<String, Integer> >() {
                public int compare(
                    Map.Entry<String, Integer> object1,
                    Map.Entry<String, Integer> object2)
                {
                    return (object1.getValue())
                        .compareTo(object2.getValue());
                }
            });
        HashMap<String, Integer> result
            = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }
        return result;
    }
}

