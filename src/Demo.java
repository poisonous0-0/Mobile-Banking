import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        String num = "3";

        System.out.println(arrayList.get(0));
        for(int i=0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        for(int i=0; i< arrayList.size(); i++){
            String temp = arrayList.get(i);
            if(num == temp){
                arrayList.remove(i);
            }
        }
        for(int i=0; i< arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


    }
}
