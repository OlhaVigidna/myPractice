package prac;

public class FirstClass implements Int{
    int lenght = 10;

    Int intr = new Int() {
        @Override
        public int[] creator() {
            return new int[0];
        }
    };


    @Override
    public int[] creator() {
        int[] array = new int[lenght];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * intr.getDiap());
        }

        return array;
    }


}


