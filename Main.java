public class Main {
    public static void main(String[] args){
       
        int costumer=7717;                                            
        short order=00000;
        
        Order o=new Order(order, costumer);
        
        o.addIngredient("cheese", 1);
        o.printOrderAttr();
        o.printCheck();
       
    }
}
