import java.util.ArrayList;

public class Main {
    private static Integer maxWeight = 9;
    private static Integer iconMax = 0;
    private static ArrayList<Thing> thingMax = new ArrayList<>();
    private static ArrayList<Thing> thingsAll = new ArrayList<>();


    public static void main(String[] args) {
        // 1 Задание
        //  System.out.println(vozvedeniStepen(6,7));

        thingsAll.add(new Thing("cat", 4, 10));
        thingsAll.add(new Thing("dog", 6, 100));
        thingsAll.add(new Thing("car", 40, 1000));
        thingsAll.add(new Thing("brilliant", 10, 1));
        Integer numberThings = thingsAll.size();
        for (int i = 0; i < thingsAll.size(); i++) {
            checkWeight(numberThings);
            convertArr(thingsAll);
        }

        for (int t = 0; t < thingMax.size(); t++) {
            System.out.print(thingMax.get(t).getName() + " ");
        }

    }

    private static void checkWeight(Integer numberThings) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Thing> answerWeight = new ArrayList<>();
        Integer weight = 0;
        if (numberThings == 0) {
            return;
        }
        for (int i = 0; i < numberThings; i++) {
            weight = weight + thingsAll.get(i).getWeight();
            answer.add(thingsAll.get(i).getName());
            answerWeight.add(thingsAll.get(i));
        }
        if (weight <= maxWeight) {
            Integer icon = 0;
            for (int i = 0; i < answerWeight.size(); i++) {
                icon = icon + thingsAll.get(i).getIcon();
            }
            if (iconMax < icon) {
                iconMax = icon;
                thingMax.clear();
                for (int i = 0; i < answerWeight.size(); i++) {
                    icon = icon + thingsAll.get(i).getIcon();
                    thingMax.add(thingsAll.get(i));
                }
            }
            checkWeight(numberThings - 1);

        } else {
            checkWeight(numberThings - 1);
        }
    }


    private static ArrayList<Thing> convertArr(ArrayList<Thing> things) {
        Thing elementFirst = things.get(0);
        for (int i = 1; i < things.size(); i++) {
            things.set(i - 1, things.get(i));
        }
        things.set(things.size() - 1, elementFirst);
        return things;
    }


    private static Integer vozvedeniStepen(Integer number, Integer stepen) {
        if (stepen == 0) {
            return 1;
        }
        if (stepen == 1) {
            return number;
        }
        return number * vozvedeniStepen(number, stepen - 1);
    }


}


