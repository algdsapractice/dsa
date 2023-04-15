package company.testKr;

import java.util.*;
/*
* Functional Smooothies Inc. is releasing a new smoothie machine that will make the best icy fruit beverages of all time. According to Wikipedia:

A smoothie (occasionally spelled smoothee or smoothy) is a thick, cold beverage made from pureed raw fruit blended with ice cream or frozen yogurt along with other ingredients such as crushed ice, fruit juice, sweeteners, dairy products, nuts, seeds, etc.

In order to sell the machine to smoothie vendors all over the world, Functional Smooothies needs to ensure that the machine takes all dietary preferences and allergies into account. They have hired you to write the software for the machine.

The software has a menu of standard smoothie options, including the ingredients for each drink. When a customer places their order, they supply a list of zero or more dietary restrictions that must be honoured. Your software will print out a list of the ingredients that the smoothie operator needs to put into the machine.

Menu
The menu options, along with the ingredients needed for each are as follows.

Classic: strawberry, banana, pineapple, mango, peach, honey
Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
Greenie: green apple, lime, avocado, spinach, ice, apple juice
Just Desserts: banana, ice cream, chocolate, peanut, cherry
Input
You should write a function called ingredients, which takes as input a string containing item from the menu and optionally one or more ingredients to omit from the smoothie, separated by commas.

Restricted ingredients have to be preceded by - sign, as opposed to the ones that should be added. Note that:

It is valid to have the allergens not present in the ordered smoothie. Those ingredients will just be ignored and no exception should be thrown.
As adding new ingredients is not supported yet, any input with additional ingredients is considered invalid and an IllegalArgumentException should be thrown.
In very rare cases of the user input processor mechanical failures, their order might be lost or arrive empty to the software.

Output
The function should return a string listing the ingredients that the operator needs to put in. To make it more convenient for the operator, the ingredients should be listed in alphabetical order and separated by commas in the string returned from the function.

A smoothie with no ingredients is represented as "". In case of input being invalid, an IllegalArgumentException should be thrown.

Examples
if a customer orders a Classic but is allergic to strawberry and peanuts, your function will be called with the argument "Classic,-strawberry,-peanut" and should return "banana,honey,mango,peach,pineapple". Note that peanut was ignored as it is not a part of the Classic menu.
Requesting Classic with additional mango "Classic,mango" should result in IllegalArgumentException being thrown.
Same result should apply for requesting a smoothie that is not present in the menu "Vitamin smoothie".


public class SmoothieTest {
    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                     Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                     Smoothie.ingredients("Classic,-strawberry"));
    }
}
* */

public class Smoothie {

    public  static Map<String, ArrayList<String>> map = new HashMap<>();

    static
    {
        map.put("Classic",new ArrayList<>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
        map.put("Freezie",new ArrayList<>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
        map.put("Greenie",new ArrayList<>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
        map.put("Just Desserts",new ArrayList<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));
    }

    public String ingredients (String order){
        if(null == order || order.trim().length()==0){
            throw  new IllegalArgumentException("Invalid order");
        }
        String items[] = order.split(",");
        String filter []= new String[items.length-1];
//        System.out.println("Filter Data"+Arrays.toString(filter));
        String key = items[0];
        if(items.length==0){
            throw  new IllegalArgumentException("Invalid order");

        }

        if(!map.containsKey(key)){
            throw  new IllegalArgumentException("Invalid order");
        }


        for (int i = 1; i <items.length;i++){
            if(!items[i].startsWith("-")){
                throw  new IllegalArgumentException("Invalid order");
            }
            filter[i-1] = items[i].substring(1);
        }

//        System.out.println("Filter Data after"+Arrays.toString(filter));

        ArrayList<String> smoothies= map.get(key);
        smoothies.removeIf(a->Arrays.asList(filter).contains(a));
        Collections.sort(smoothies);
        return String.join(",", smoothies);

    }


    public static void main(String[] args) {
        Smoothie smoothie = new Smoothie();
        String resul2= smoothie.ingredients("Classic");
        String result= smoothie.ingredients("Classic,-strawberry");

        System.out.println(resul2);
        System.out.println(result);
    }
}
