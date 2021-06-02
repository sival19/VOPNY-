package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class MountainSet {

    private Set<Mountain> mountainSet;

    public MountainSet(){
        mountainSet = new TreeSet<>();
    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }

    public void addMountain(Mountain m){
        this.mountainSet.add(m);
    }

    public Set<Mountain> sortByRange(Comparator comp){
        Set<Mountain> range = new TreeSet<>(comp);
        range.addAll(mountainSet);
        return range;
    }

    public static void main(String[] args) throws URISyntaxException {
        MountainSet set = new MountainSet();
        String path = MountainSet.class.getResource("FranskeBjerge.csv").toURI().getPath();
        File f =new File(path);
        try (Scanner scanner = new Scanner(f)){
            String line;
            String[] items;
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                items = line.split(";");
                set.addMountain(new Mountain(items[0], items[1], items[2], items[3], items[4], items[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(set.sortByRange(new MoubtainRangeComparator()));
    }
}
