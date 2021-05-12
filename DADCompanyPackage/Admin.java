package DADCompanyPackage;

/**
 * Administrator class
* @author dervisaliduman
* @version 1.7.0_201
*/
public class Admin extends Human{
	private Company company;
	protected static int admin_count;

	/**
	 * creating admin and giving company 
	 * @param company company that working
	 * @param name	name of admin
	 * @param surname	surname of admin
	 * @param email	email of admin
	 * @param password password of admin
	 */
	public Admin(Company company , String name, String surname, String email, String password){
        super(name,surname,email,password,admin_count + 100);
        this.company = company;
        increase_count();
    }

    
	/**
	 * 
	 * @return string of list of products
	 */
    public String see_listof_products(){
    	return company.get_all_items_string();
    }

    /**
     * 
     * @return string of list of products that needed
     */
    public String see_listof_products_that_needed(){
    	String s = company.get_needed_items_string();
    	if(s.equals("")){
    		return "There is no need to buy product";
    	}
    	return s;
    }

    /**
     * it works like branch's contructor. it takes same parameter
     * @param products list of products that will added
     * @param product_count count of products wil add
     */
    public void add_branch(HybridList<Product_interface> products, int product_count){
    	Branch_interface new_branch = new Branch(products, product_count);
    	company.add_branch(new_branch);
	}

    /**
     * deletes branch by index
     * @param index branch's index
     */
	public void delete_branch_byindex(int index){
			company.delete_branch_byindex(index);
	}
	
	/**
	 * deletes products by function that in company class
	 * @param product_name name of product
	 * @param model_number	number of model
	 * @param color_number	color of product
	 * @return if task sucseed
	 */
	public boolean delete_product_by_name_model_and_color(String product_name, int model_number, int color_number){
    	
    	return company.buy_product_by_name(product_name,model_number,color_number);
    	
    }

    /**
     * adds products by function that in company class
     * @param branch_index branch id
     * @param product_name	name of product
     * @param model_number	number of model
     * @param color_number	color of product
     * @return if task sucseed
     */
    public boolean add_product_by_name_model_and_color_to_branch(int branch_index , String product_name, int model_number, int color_number){
    	
    	return company.add_product_by_name_to_branch(branch_index,product_name,model_number,color_number);
    	
    }

	/**
	 *returns string of items each branch
	 * @return string of items each branch
	 */
    public String branch_item_list(){
    	return company.branch_item_list();
	}

    /**
     * adds branch employee with his informations
     * @param branch_index branch index
     * @param name name of employee
     * @param surname	surname of employee
     * @param email	email of employee
     * @param password password of employee
	 * @throws AlreadyAddedException
     */
	public void add_branch_employee_to_branch(int branch_index, String name, String surname,String email, String password) throws AlreadyAddedException{					// return bool

		Branch_Employee new_branch_emp = new Branch_Employee(company,branch_index,name,surname,email,password);
		try {
			company.add_branch_employee_bybranch_index(branch_index,new_branch_emp);
		}
		catch (AlreadyAddedException e){
			throw new AlreadyAddedException("This person already added");
		}

	}

	/**
	 *	Deletes product
	 * @param product_name name of product
	 * @param model_number product's model
	 * @param color_number color number of profuct
	 * @return if succesfull or not
	 */
	public boolean delete_product_by_name(String product_name, int model_number, int color_number){
		return company.buy_product_by_name(product_name,model_number,color_number);
	}

	/**
	 * returns string of list of branches and employee count
	 * @return string of list of branches and employee count
	 */
	public String list_of_branches(){
		return company.list_of_branches();
	}

	/**
	 *returns string of all branch employees
	 * @return string of all branch employees
	 */
	public String list_of_branch_employees(){
		return company.list_of_branch_employees();
	}

	/**
	 * deletes branch employee by his/her id
	 * @param branch_index id of branch that working on
	 * @param index	id of employee
	 */
	public void delete_branch_employee_by_branch_index(int branch_index, int index){
			company.delete_branch_employee_byindex(branch_index, index);
	}
	
	/**
	 * increases count
	 */
    protected static void increase_count(){
		admin_count++;
	}

    /**
	 * decreases count
	 */
	protected static void decrease_count(){
		admin_count--;
	}
}