
public class VendingMachine {
    private int chocolate_amount;
    private int brownie_amount;
    private int milo_amount;
    private int chocolate_price;
    private int brownie_price;
    private int milo_price;
    private int total_revenue;
    private static int count = 0;
     

    public VendingMachine(int chocolate_amount, int brownie_amount, int milo_amount, int chocolate_price, int brownie_price, int milo_price){
        this.chocolate_amount = chocolate_amount;
        this.brownie_amount = brownie_amount;
        this.milo_amount = milo_amount;
        this.chocolate_price = chocolate_price;
        this.brownie_price = brownie_price;
        this.milo_price = milo_price;
        this.total_revenue = 0;
   
        System.out.println("Price and amount setted!");
    }

    public static int getCount(){
        return count;
    }
    
    public int getChocolateAmount(){
        return chocolate_amount;
    }

    public int getBrownieAmount(){
        return brownie_amount;
    }

    public int getMiloAmount(){
        return milo_amount;
    }

    public int getChocolatePrice(){
        return chocolate_price;
    }

    public int getBrowniePrice(){
        return brownie_price;
    }

    public int getMiloPrice(){
        return milo_price;
    }

    public void buyItem(String item){
        if (item.equals("Chocolate")){
            if (chocolate_amount > 0) {
                chocolate_amount--;
                total_revenue += chocolate_price;
                System.out.println("Getting chocolate...");
            } else {
                System.out.println("No chocolate left!");
            }
        } else if (item.equals("Brownie")){
            if (brownie_amount > 0) {
                brownie_amount--;
                total_revenue += brownie_price;
                System.out.println("Getting brownie...");
            } else {
                System.out.println("No brownie left!");
            }
        } else if (item.equals("Milo")){
            if (milo_amount > 0){
                milo_amount--;
                total_revenue += milo_price;
                System.out.println("Getting milo...");
            } else {
                System.out.println("No milo left!");
            }
        }
    }

    public void restock(int chocolate, int brownie, int milo) {
        this.chocolate_amount += chocolate;
        this.brownie_amount += brownie;
        this.milo_amount += milo;
        System.out.println("Restocked the vending machine.");
    }

    public String machine() {
        return "VendingMachine [chocolate=" + chocolate_amount + ", brownie=" + brownie_amount + ", milo=" + milo_amount + "]";
    }

    public int getTotalRevenue() {
        return total_revenue;
    }

}
