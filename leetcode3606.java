import java.util.*;

class Solution {
    public List<String> validateCoupons(
        String[] code,
        String[] businessLine,
        boolean[] isActive
    ) {

        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i]) continue;

            String bl = businessLine[i];
            if (!(bl.equals("electronics") || bl.equals("grocery")
                || bl.equals("pharmacy") || bl.equals("restaurant")))
                continue;

            if (code[i].isEmpty()) continue;
            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;

            if (bl.equals("electronics")) electronics.add(code[i]);
            else if (bl.equals("grocery")) grocery.add(code[i]);
            else if (bl.equals("pharmacy")) pharmacy.add(code[i]);
            else restaurant.add(code[i]);
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> result = new ArrayList<>();
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);

        return result;
    }
}
