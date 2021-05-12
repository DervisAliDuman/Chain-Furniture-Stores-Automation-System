package DADCompanyPackage;

/**
 * Branch employees and their informations here
* @author dervisaliduman
*/
public class Branch_Employee extends Human{
	private Company company;
	protected static int  branch_employee_count;
	protected int branch_id;

	/**
	 * taking and setting branch employee information
	 * @param company company that working
	 * @param branch_id id of employee
	 * @param name name of employee	
	 * @param surname surname of employee
	 * @param email email of employee
	 * @param password	password of employee
	 */
	public Branch_Employee(Company company,int branch_id, String name, String surname, String email, String password){
       	super(name,surname,email,password,200+branch_employee_count);
       	this.branch_id = branch_id;
       	this.company = company;
       	branch_employee_count++;
    }

    /**
    *@return string that includes all items
    */
    public String see_listof_products(){
    	return company.get_all_items_string();
    }

    /**
     * deletes products by function that in company class
     * @param product_name name of product
     * @param model_number number of model
     * @param color_number number of color
     * @return if sucseed
     */
    public boolean delete_product_by_name_model_and_color(String product_name, int model_number, int color_number){	
    	return company.buy_product_by_name(product_name,model_number,color_number);
    	
    }

    /**
	 * sells products to customer
	 * @param product_name name of product
	 * @param model_number	number of model
	 * @param color_number	color of product
	 * @param customer_index index of customer
	 * @return if task sucseed
	 */
    public boolean sell_product_by_name_model_and_color(String product_name, int model_number, int color_number , int customer_index){
    	Customer customer = company.get_customer(customer_index);
    	if(customer.is_subscribed()){

    		if(company.buy_product_by_name(product_name,model_number,color_number)){

    			customer.add_purchase_history_to_string(product_name,model_number,color_number);
    			return true;
    		}	
    	}
    	else {
			System.out.println("There is no such item or customer did not subscribed.");
		}

    	return false;	
    }

    /**
    *shows list of customers by function that in company class
    *@return customer list string
    */
    public String see_listof_customers(){
    	return company.get_all_customers_string();
    }

    /**
    *@return informations of employee
    */
    @Override
    public String toString(){
        return "\nName: " + get_name() + "\nSurname: " + get_surname() + "\nE-mail: "+ get_email() + "\nID: " + get_id() + "\nBranch ID: " + branch_id + "\n";
    }
}