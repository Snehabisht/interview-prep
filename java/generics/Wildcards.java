package generics;

import java.util.ArrayList;
import java.util.List;

class AnimalClass {
    void eat() {
        System.out.println("Eating");
    }

    void walk() {
        System.out.println("Walking");
    }
}




class DogClass extends AnimalClass{
    void bark() {
        System.out.println("Barking");
    }
}

public class Wildcards {
    static void main() {
        // works but will give runtime error
//        DogClass[] dogs = new DogClass[10];
//        AnimalClass[] animals = dogs; //initially null
//        animals[0] = new DogClass();
//        animals[1] = new DogClass();
//        animals[2] = new DogClass();
//        animals[3] = new DogClass();
//        animals[4] = new AnimalClass();
//
//        for (int i = 0; i<10; ++i){
//            animals[i].eat();
//        }

//        not allowed with generics -> invariant
//        ArrayList<DogClass> dogsList = new ArrayList<>();
//        ArrayList<AnimalClass> animalsList = dogs;

        List<DogClass> dogClasses = new ArrayList<>();
        dogClasses.add(new DogClass());
        dogClasses.add(new DogClass());
        fun(dogClasses);

        List<AnimalClass> animalClasses = new ArrayList<>();
        animalClasses.add(new AnimalClass());
        animalClasses.add(new AnimalClass());
        fun2(animalClasses);

    }

    //wildcard with upper bound, animal or its subclasses can come
    static void fun(List<? extends AnimalClass> values){
        for (AnimalClass animalClass : values) {
            animalClass.eat();
        }
      //  values.add(new AnimalClass()); writing not allowed
    }

    //wildcard with lower bound, animal or its subclasses can come
    static void fun2(List<? super AnimalClass> values){
        // reading not allowed
        // for(AnimalClass animalClass : values) {
        //   animalClass.eat();
        //}
        values.add(new AnimalClass());
    }

}
