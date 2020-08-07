package jul7;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class TaskMap {
public static void main(String[] args) {
// ArrayList<String> li=new ArrayList<String>();
//
// li.add("");
// li.get(0);

HashMap<Integer, String> map=new HashMap<Integer, String>();
map.put(0, "X");
map.put(1, "X");
map.put(2, "Y");
map.put(3, "Z");

System.out.println(map.get(2));

for(int i=0;i<map.size();i++) {
System.out.println(map.get(i));
}

//for(String s:li)
for (Map.Entry<Integer, String> entry : map.entrySet()) {
   System.out.println(entry.getKey() + " = " + entry.getValue());
}

map.forEach((key,value) -> System.out.println(key + " = " + value));


map.forEach((key,value) -> System.out.println(key +"="+value));

Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
while (it.hasNext()) {
	Map.Entry<Integer, String> pair = (Map.Entry<Integer, String>) it.next();
	System.out.println(pair.getKey() + " = " + pair.getValue());
}



}
}