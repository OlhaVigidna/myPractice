package prac;

public class SecondClass implements Int {
    int lenght = 10;
    int diapaz = 300;


    @Override
    public int[] creator() {
        int[] array = new int[lenght];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random()*diapaz);

        }
        return array;
    }
}
