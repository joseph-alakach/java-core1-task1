import java.util.*;
public class Pizza {
    private String name;
    private ArrayList<String> ingredients = new ArrayList<>();
    private String pizzaType;
    private int quantity;


    public Pizza(String name, ArrayList<String> ingredients, String pizzaType, int quantity){
        this.name=name;
        this.ingredients=ingredients;
        this.pizzaType=pizzaType;
        this.quantity=quantity;
    }
    public String getName(){
        return this.name;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getPizzatype(){
        return this.pizzaType;
    }
    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }
    public boolean isFull(){
        if(ingredients.size()>=7){
            return true;
        }
        return false;
    }
    public void addIngredient(String newIng){
        if(this.isFull()){
            System.out.println("This pizza is full of ingredients. You cannot add any ingredient.");
        }else{
            for(String s:ingredients){
                if((s.toLowerCase()).equals(newIng.toLowerCase())){
                    System.out.println("you already have "+newIng+" on it!");
                    return;
                }
            }
            ingredients.add(newIng);
        }
    }
}
