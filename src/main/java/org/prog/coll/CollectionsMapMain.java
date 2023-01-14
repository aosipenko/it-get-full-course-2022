package org.prog.coll;

import java.util.HashMap;
import java.util.Map;

public class CollectionsMapMain {

    public static void main(String... args) {
        HashMap<String, String> planeSits = new HashMap();

        planeSits.put("24C", "Elton John");
        planeSits.put("24B", null);
        planeSits.put("12C", "Keanu Reeves");

//        planeSits.put("24C", null);

        for (Map.Entry e : planeSits.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }



    }
}
