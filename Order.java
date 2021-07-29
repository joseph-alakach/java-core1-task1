import java.util.*;
public class Order{
    private  short orderNumber;
    private  int costumerNumber;
    private ArrayList<Pizza> pizzaList=new ArrayList<>();
    
    public Order( short orderNumber, int costumerNumber){
        this.orderNumber=orderNumber;
        this.costumerNumber=costumerNumber;
        Scanner scan=new Scanner(System.in);
        while(true){
            int pizzaIndex=1;
            System.out.println("what is the pizza name?");
            String name=scan.next();
            if(name.length()<4 || name.length()>20){
                
                name=costumerNumber+"_"+name+"_"+pizzaIndex;
            }

            System.out.println("the type of the pizza? (regular or calzone)");
            String type=scan.next();
            ArrayList<String> ingredients=new ArrayList<>();

            System.out.println("do you want Tomato paste 1 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Tomato paste");
            }
            System.out.println("do you want Cheese 1 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Cheese");
            }
            System.out.println("do you want Salami 1.5 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Salami");
            }
            System.out.println("do you want Bacon 1.2 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Bacon");
            }
            System.out.println("do you want Garlic 0.3 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Garlic");
            }
            System.out.println("do you want Corn 0.7 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Corn");
            }
            System.out.println("do you want Pepperoni 0.6 $ in it (yes or no)");
            if(scan.next().equals("yes")){
                ingredients.add("Pepperoni");
            }
            if(ingredients.size()<7){
                System.out.println("do you want Olives 0.5 $ in it (yes or no)");
                if(scan.next().equals("yes")){
                    ingredients.add("Olives");
                }
            }
            System.out.println("how many of that you want?");
            int quantity=scan.nextInt();

            pizzaList.add(new Pizza(name, ingredients, type, quantity));

            System.out.println("press 1 if you want another pizza or 2 if your are done");
            int answer=scan.nextInt();
            if(answer==2){
                break;
            }
            pizzaIndex++;
            
        }
        
    }
    
    public void printOrderAttr(){
        for(int i=0; i<pizzaList.size(); i++){
            System.out.println("["+this.orderNumber+" : "+this.costumerNumber+" : "+pizzaList.get(i).getName()+" : "+pizzaList.get(i).getQuantity()+"]");
        }
        
    }

    public void addIngredient(String newIngredient, int pizzaIndex){
        pizzaList.get(--pizzaIndex).addIngredient(newIngredient);
        
    }
    
    public void printCheck(){
        double total=0.0;
        System.out.println("********************************");
        System.out.println("Order: "+this.orderNumber);
        System.out.println("Client: "+this.costumerNumber);
        for(Pizza p:this.pizzaList){
                double sum=0.0;
            System.out.println("Name: "+p.getName());
            System.out.println("--------------------------------");
            System.out.print("Pizza Base: "+"("+p.getPizzatype()+")");
            switch(p.getPizzatype().toLowerCase()){
                case "regular":
                System.out.println(" 1 $");
                sum+=1;
                break;
                case "calzone":
                System.out.println(" 1.5 $");
                sum+=1.5;
                break;
            }
            for(String in:p.getIngredients()){
                System.out.print(in);
                switch(in.toLowerCase()){
                    case "tomato paste":
                    System.out.println(" 1 $");
                    sum+=1;
                    break;
                    case "cheese":
                    System.out.println(" 1 $");
                    sum+=1;
                    break;
                    case "salami":
                    System.out.println(" 1.5 $");
                    sum+=1.5;
                    break;
                    case "bacon":
                    System.out.println(" 1.2 $");
                    sum+=1.2;
                    break;
                    case "garlic":
                    System.out.println(" 0.3 $");
                    sum+=0.3;
                    break;
                    case "corn":
                    System.out.println(" 0.7 $");
                    sum+=0.7;
                    break;
                    case "pepperoni":
                    System.out.println(" 0.6 $");
                    sum+=0.6;
                    break;
                    case "olives":
                    System.out.println(" 0.5 $");
                    sum+=0.5;
                    break;
                }

            }
            System.out.println("--------------------------------");
            sum=sum*(p.getQuantity());
            System.out.println("Amount: "+sum+"$");
            System.out.println("Quantity: "+p.getQuantity());
            System.out.println("--------------------------------");
            total+=sum;
        }
        System.out.println("Total amount: "+total+"$");
        System.out.println("********************************");
        

    }
}