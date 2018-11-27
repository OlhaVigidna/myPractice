package prac;

public interface Int {
    int DIAP = 200;

    default int getDiap(){
        return DIAP;
    }

    int[] creator();
}
