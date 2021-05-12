package DADCompanyPackage;

/**
 * It has customer informations
* @author dervisaliduman
* @version 1.7.0_201s
*/
public class Customer extends Human{
	private Company company;
	protected static int customer_count;
	private boolean subscribed = false;

	private String address;
	private String tel_num;

	private String purcase_history;
	private int bought_count = 0;

	/**
	 * taking and setting customer information
	 * @param company name of company that will buy something
	 * @param name	name of customer
	 * @param surname	surname of customer
	 * @param email	email of customer
	 * @param password password of customer
	 */
	public Customer(Company company ,String name, String surname,String email, String password){
        super(name,surname,email,password,300+customer_count);
        this.company = company;
        purcase_history = "\nPurchase history \n";
        increase_count();
    }

    /**
    *controlls that if cutomer subscribed
    *@return if subscribed true
    */
    public boolean is_subscribed(){
    	return subscribed;
    }

   	/**
   	*@return string that includes all items
   	*/
    public String see_listof_products(){
    	return company.get_all_items_string();
    }

    /**
     * subscribtion function
     * @param address given adress of customer
     * @param tel_num tel_num of customer
     */
    public void subscribe(String address, String tel_num){
    	this.address = address;
    	this.tel_num = tel_num;
    	subscribed = true;
    }

    /**
     * adds item to purchase history 
     * @param product_name name of product will add
     * @param model_number model number of product will add
     * @param color_number color number of product will add
     */
    public void add_purchase_history_to_string(String product_name, int model_number, int color_number){
    	bought_count++;

    	String color_name= "";
    	if(color_number == 1){
    		color_name+="black";
    	}else if(color_number == 2){
    		color_name+="white";
    	}else if(color_number == 3){
    		color_name+="blue";
    	}else if(color_number == 4){
    		color_name+="red";
    	}else if(color_number == 5){
    		color_name+="orange";
    	}
    	String s = "Product name: " + product_name + "   Model: " + model_number + "  Color: " + color_name;
    	purcase_history += s;
    	purcase_history += "\n";
    }

    /**
    *shows purchase history
    *@return purschase history as a string
    */
    public String see_purchase_history(){
    	if(bought_count >0){
    		return purcase_history;
    	}
    	return "Empty purchase history";
    }

    /**
     * buy's item
     * @param product_name name of product will buy
     * @param model_number model number of product will buy
     * @param color_number color number of product will buy
     */
    public boolean buy_product_by_name_model_and_color(String product_name, int model_number, int color_number){
    	if(is_subscribed()){
    		if(company.buy_product_by_name(product_name,model_number,color_number)){
    			add_purchase_history_to_string(product_name,model_number,color_number);
    			
    			return true;
    		}	
    	}
    	return false;
    }

    /**
    *adds customer in DADCompanyPackage.Company
	 * @throws AlreadyAddedException
    */
    public void singin() throws AlreadyAddedException{
    	try {
			company.add_customer(this);
		}catch (AlreadyAddedException a){
			throw new AlreadyAddedException("This person already added");
		}

    }

    /**
    *increases count
    */
    protected static void increase_count(){
		customer_count++;
	}

	/**
    *decreases count
    */
	protected static void decrease_count(){
		customer_count--;
	}
}