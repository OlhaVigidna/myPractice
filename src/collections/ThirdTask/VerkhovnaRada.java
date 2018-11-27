package collections.ThirdTask;

import java.util.*;

public class VerkhovnaRada {
    private Map<String, Fraction> fractionMap;

    public VerkhovnaRada(Map<String, Fraction> fractionMap) {
        this.fractionMap = fractionMap;
    }

    public Map<String, Fraction> addFraction(Map<String, Fraction> fractionMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter fraction name");
        String fractionName = scanner.nextLine();
        fractionMap.put(fractionName, new Fraction());
        return fractionMap;
    }

    public Map<String, Fraction> deleteFraction(Map<String, Fraction> fractionMap){
        Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
        Iterator<Map.Entry<String, Fraction>> iterator = entries.iterator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name fraction wich you want delete");
        String name = scanner.nextLine();
        while (iterator.hasNext()){
            Map.Entry<String, Fraction> next = iterator.next();
            if (next.getKey().equals(name)){
                iterator.remove();
            }
        }
        return fractionMap;
    }

    public Map<String, Fraction> deleteAllFractions(Map<String, Fraction> fractionMap){
        fractionMap.clear();
        return fractionMap;
    }

    public void showParticularFractions(Map<String, Fraction> fractionMap){
       Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
       String nameFraction = getFractionName();
        for (Map.Entry<String, Fraction> entry : entries) {
            if (entry.getKey().equals(nameFraction)){
                System.out.println(entry);
            }
        }
    }

    public Map<String, Fraction> addDeputy(Map<String, Fraction> fractionMap){
        String fractionName = getFractionName();
        Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
        for (Map.Entry<String, Fraction> entry : entries) {
            if (entry.getKey().equals(fractionName)){
                entry.getValue().addDeputy(entry.getValue().getDeputies());
            }
        }
        return  fractionMap;
    }
       public Map<String, Fraction> deleteDeputy(Map<String, Fraction> fractionMap){
        String fractionName = getFractionName();
        Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
        for (Map.Entry<String, Fraction> entry : entries) {
            if (entry.getKey().equals(fractionName)){
                entry.getValue().delete(entry.getValue().getDeputies());
            }
        }
        return  fractionMap;
    }

    public Map<String, Fraction> showAllGrafters(Map<String, Fraction> fractionMap){
        String fractionName = getFractionName();
        Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
        for (Map.Entry<String, Fraction> entry : entries) {
            if (entry.getKey().equals(fractionName)) {
                List<Deputy> list = entry.getValue().getDeputies();
                for (Deputy deputy : list) {
                    if (deputy.isGrafter()) {
                        System.out.println(deputy);
                    }
                }
            }
        }
        return  fractionMap;
    }

     public Map<String, Fraction> theBigestGrafter(Map<String, Fraction> fractionMap){
        String fractionName = getFractionName();
        Set<Map.Entry<String, Fraction>> entries = fractionMap.entrySet();
        for (Map.Entry<String, Fraction> entry : entries) {
            if (entry.getKey().equals(fractionName)){
                entry.getValue().theBigestGrafter(entry.getValue().getDeputies());
            }
        }
        return  fractionMap;
    }




    public String getFractionName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter fraction name");
        String name = scanner.nextLine();
        return name;
    }


    public Map<String, Fraction> getFractionMap() {
        return fractionMap;
    }

    public void setFractionMap(Map<String, Fraction> fractionMap) {
        this.fractionMap = fractionMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerkhovnaRada that = (VerkhovnaRada) o;
        return Objects.equals(fractionMap, that.fractionMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fractionMap);
    }

    @Override
    public String toString() {
        return "VerkhovnaRada{" +
                "fractionMap=" + fractionMap +
                '}';
    }
}
