package space.kuz.myapplication;

import java.util.HashMap;

public class MyComputer {
    private  static    Integer[] arrCent = MyArray.getArray(50, 500, 2000);
    private static Integer[] arrMind = MyArray.getArray(4, 4, 24);
    public static String[] arrPro = new String[]{"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
    public static HashMap<String,Integer> arrPro_1 = new HashMap<>();
     private Integer cent ;
   private Integer mind;
   private String pro;
    private int proInt;

    MyComputer() {
        cent = arrCent[MyArray.getRandomElement(arrCent)];
        mind = arrMind[MyArray.getRandomElement(arrMind)];
      pro =  arrPro[MyArray.getRandomElement(arrPro)];
       }

    public Integer getCent() {
        return cent;
    }

    public void setCent(Integer cent) {
        this.cent = cent;
    }

    public Integer getMind() {
        return mind;
    }

    public void setMind(Integer mind) {
        this.mind = mind;
    }
    public Integer getProInt() {
        return arrPro_1.get(pro);
    }

    public String getPro() {
        return pro;
    }

    public void setProInt(int proInt) {
        pro = arrPro[proInt];
    }
    public void setPro(String pro) {
        this.pro = pro;
    }
}
