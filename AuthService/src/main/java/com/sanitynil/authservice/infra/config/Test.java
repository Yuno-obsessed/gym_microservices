package com.sanitynil.authservice.infra.config;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

interface sunstar {
    void printInfo();
}

interface smth{
    void printShit();
    void printDamnShit();
}

abstract class second{
    public void shit(String some){
       System.out.println(some + "shit");
    }
    abstract void printMoreShit();
    abstract void printSomeShit();
}

class employee extends second implements smth, sunstar{
    @Override
   public void printMoreShit(){
    System.out.println("more shit");
   }
    @Override
    public void printDamnShit() {
        System.out.println("damn shit");
    }

    @Override
    public void printSomeShit() {
        System.out.println("some shit");
    }

    @Override
    public void printShit() {
        System.out.println("print shit");
    }

    public void printInfo() {
        String name = "avinash";
        int age = 21;
        float salary = 222.2F;

        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);

    }

}

class base {
    public static void main(String args[]) {
        sunstar s = new employee();
        employee e = new employee();
        e.printInfo();
        s.printInfo();
        e.printDamnShit();
        e.printShit();
        e.printMoreShit();
        e.printSomeShit();
        e.shit("SHIT SHIT ");
        String shit = "Shit";
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("Name", s1 -> s1.length());
        int[] fibs = {1, 2};
        Stream<Integer> stream = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
    }
}
