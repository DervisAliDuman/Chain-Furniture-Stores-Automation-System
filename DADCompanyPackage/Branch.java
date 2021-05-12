package DADCompanyPackage;

/**
 * it has products, employees and information of theese
* @author dervisaliduman
* @version 1.7.0_201
*/
public class Branch implements Branch_interface{
	private int id;
	private static int branch_count = 0;
	private HybridList<Product_interface> products = new HybridList<Product_interface>();
	private int product_count = 0;

	private KWArrayList<Branch_Employee> branch_employees = new KWArrayList<Branch_Employee>();
	private int branch_employee_count = 0;

	/**
	 * you need to give some products in order to create a branch. i think if branch has no product then it is not a branch
	 * @param products array of products will be added
	 * @param product_count	count of products
	 */
	public Branch(HybridList<Product_interface> products, int product_count){
		id = branch_count + 900;
		this.products  = products;
		this.product_count = product_count;
		increase_count();
	}

	/**
	 * adds branch employeee in employee array that in the parameters
	 * @param b employee that will be added
	 * @throws AlreadyAddedException
	 */
	@Override
	public void add_branch_employee(Branch_Employee b) throws AlreadyAddedException{
		boolean flag = false;
		for(int i = 0; i< branch_employee_count ; i++){
			if(get_branch_employee(i).get_email().equals(b.get_email())){
				flag =true;
				throw new AlreadyAddedException("This person already added");
			}
		}
		if(!flag){
			branch_employee_count++;
			branch_employees.add(b);
		}

	}

	/**
	 * Deletes branch employees by index
	 * @param index index of employee
	 */
	@Override
	public void delete_branch_employee(int index){
		if(index< branch_employees.size()){

			branch_employee_count--;
			branch_employees.remove(index);
		}
	}

	/**
	*increases branch count
	*/
    protected static void increase_count(){
		branch_count++;
	}

	/**
	*decreases branch count
	*/
	protected static void decrease_count(){
		branch_count--;
	}

	/**
	*sets id of branch
	*@param id id of employee
	*/
	protected void set_id(int id){
		this.id = id;
	}

	/**
	*gets id of branch
	*/
	@Override
	public int get_id(){
		return id;
	}

	/**
	 *
	 * @param index index of wanted employee
	 * @return return employee in that index
	 */
	public Branch_Employee get_branch_employee(int index){ 			//BOOL
		return branch_employees.get(index);
	}

	/**
	 * @param index index of product
	 *@return product class element by index
	 */
	@Override
	public Product_interface get_product(int index){
		return products.get(index);
	}

	/**
	*@return count of product
	*/
	@Override
	public int get_product_count(){
		return product_count;
	}

	/**
	*finds products by names in all products
	*@param product_name takes name of product for find it
	*@return product that found
	*/
	@Override
	public Product_interface find_product_by_name(String product_name){

		if (products.size() <1) {
			return null;
		}

		for (int i = 0; i< products.size() ; i++ ) {
			if(products.get(i).get_product_name().equals(product_name)){
				return products.get(i);
			}
		}

		return null;
		
	}

	/**
	 * returns branch emloyee count
	 * @return branch emloyee count
	 */
	public int get_branch_employee_count(){
		return branch_employee_count;
	}

	/**
	*uses products toString() method and creates strin for itself in order to show productlist
	*@return product list as a string
	*/
	@Override
    public String toString(){
		StringBuilder sb = new StringBuilder();
    	if(product_count > 0 ){
    		for (int i = 0;i<products.size() ; i++) {
    			sb.append(products.get(i).get_stock_string());
	    	}
    	}
        return sb.toString();

    }

}