import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Comparable;

/*Create a list of cats and order it like this: (name - age - color)
 * cat 1 = name: Jon, age:18(months), color: black
 * cat 2 = name: Simba, age: 6(months), color: orange
 * cat 3 = name: Jon, age: 12(months), color: white
*/


public class OrderOfElements {
    public static void main(String[] args) {

        List<Cat> myCats = new ArrayList<>(){{
            add(new Cat("Jon", 18, "black"));
            add(new Cat("Simba", 6, "orange"));
            add(new Cat("Jon", 12, "white"));
        }};  

        System.out.println("In order of insertion: ");
        System.out.println(myCats);

        System.out.println("In a random order: ");
        Collections.shuffle(myCats);
        System.out.println(myCats);

        System.out.println("Alphabetical order (Name)");
        Collections.sort(myCats);
        System.out.println(myCats);

        System.out.println("In order of age (younger to older)");
        Collections.sort(myCats,  new ComparatorAge());
        myCats.sort(new ComparatorAge());
        System.out.println(myCats);

        System.out.println("Color in alphabetical order");
        myCats.sort(new ComparatorColor());
        System.out.println(myCats);

        System.out.println("Order Name/Color/Age");
        myCats.sort(new ComparatorNameColorAge());
        System.out.println(myCats);
    }
}

class Cat implements Comparable<Cat> {
    private String name;
    private Integer age;
    private String color;

    public Cat(String name, Integer age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "{" +
                "Name:  " + name +
                ", age: " + age + 
                ", color: " + color + " }";
    }

    @Override
    public int compareTo(Cat cat){
        return this.getName().compareToIgnoreCase(cat.getName());
    }
}

class ComparatorAge implements Comparator<Cat>{
    @Override
    public int compare(Cat c1, Cat c2){
        return Integer.compare(c1.getAge(), c2.getAge());
    }

}

class ComparatorColor implements Comparator<Cat>{
    @Override
    public int compare(Cat c1, Cat c2){
        return c1.getColor().compareToIgnoreCase(c2.getColor());
    }
}

class ComparatorNameColorAge implements Comparator<Cat>{
    @Override
    public int compare(Cat c1, Cat c2){
        int name = c1.getName().compareToIgnoreCase(c2.getName());
        if (name != 0) return name;

        int color = c1.getColor().compareToIgnoreCase(c2.getColor());
        if (color !=0) return color;

        return Integer.compare(c1.getAge(), c2.getAge());
    }

}
