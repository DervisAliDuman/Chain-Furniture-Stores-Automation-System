package DADCompanyPackage;

import java.util.*;

/**
 * Class that includes everything that in bussinies. (admins, branches, employees, customers, products ....etc.)
* @author dervisaliduman
* @version 1.7.0_201
*/
public class Company{
	
	private KWArrayList<Admin> admins = new KWArrayList<Admin>();
	private KWLinkedList<Branch_interface> branches = new KWLinkedList<Branch_interface>();
	private KWArrayList<Customer> customers = new KWArrayList<Customer>();

	private int admin_count = 0;
	private int branch_count = 0;
	private int customer_count = 0;

	/**
	 * Creates company but firstly it needs at least one admin
	 * @param admin_name name of admin
	 * @param admin_surname surname of admin
	 * @param admin_email email of admin
	 * @param admin_password password of admin
	 */
	public Company(String admin_name, String admin_surname, String admin_email, String admin_password){
		increase_company_admin_count();		//adding admin to admin array
		admins.add(new Admin(this,admin_name,admin_surname,admin_email,admin_password));
	}

	/**
	*increases admin count
	*/
	public void increase_company_admin_count(){
		admin_count++;	
	}

	/**
	 *
	 * @return count of admin
	 */
	public int get_admin_count() {
		return admin_count;
	}

	/**
	 * @param index index of customer
	*gets customer by index
	*@return customer that in index
	*/
	public Customer get_customer(int index) throws IndexOutOfBoundsException{
		if(index>=0 && index<100 && customer_count>index){
			return customers.get(index);
		}
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
	}

	/**
	 * @param index of admin
	 *gets admin by index
	 *@return admin that in index
	 * @throws IndexOutOfBoundsException
	 */
	public Admin get_admin(int index) throws IndexOutOfBoundsException{
		if(index>=0 && index<100 && admin_count>index){
			return admins.get(index);
		}
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
	}

	/**
	 * gets branch by index of branches
	 * @param index branchs index
	 * @return branch element on index
	 * @throws IndexOutOfBoundsException
	 */
	public Branch_interface get_branch(int index)throws IndexOutOfBoundsException{
		if(index>=0 && index<100 && branch_count>index){
			return branches.get(index);
		}
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
	}

	/**
	*@return all customers inormations as a string 
	*/
	public String get_all_customers_string(){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i< customer_count ; i++ ) {
			sb.append(get_customer(i));
		}
		return sb.toString();
	}

	/**
	 *returns string of all branch employees
	 * @return string of all branch employees
	 */
	public String list_of_branch_employees(){
		StringBuilder sb = new StringBuilder();

		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()) {
			Branch b = (Branch) iter.next();
			for (int j = 0 ; j< b.get_branch_employee_count() ; j++){
				sb.append(b.get_branch_employee(j));
			}
			i++;
		}

		sb.append("");
		return  sb.toString();
	}

	/**
	 * returns string of list of branches and employee count
	 * @return string of list of branches and employee count
	 */
	public String list_of_branches(){
		StringBuilder sb = new StringBuilder();
		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()){
			Branch b = (Branch) iter.next();
			sb.append("Branch "+ (i+1) + " :     " + "Employee count : " + b.get_branch_employee_count());
			sb.append("\n\n");
			i++;
		}
		sb.append("");
		return  sb.toString();
	}

	/**
	*prints items that needed to buy
	*@return string of needed items
	*/
	public String get_needed_items_string(){
		StringBuilder sb = new StringBuilder();//all this for loops for looking all items and branches
		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()){
			Branch b = (Branch) iter.next();
			for (int j = 0; j < b.get_product_count(); j++) {
				for (int k = 0; k < b.get_product(j).get_model_count() ; k++ ) {
					int count = b.get_product(j).get_model(k).get_color_count();
					if(count >0 && b.get_product(j).get_model(k).get_black_count() <1){
						sb.append("\nBranch: "+ (i+1) + " Product: " + b.get_product(j).get_product_name() + " Model: " + (k+1) + " Color: black" );
					}else if(count >1 && b.get_product(j).get_model(k).get_white_count() <1){
						sb.append("\nBranch: "+ (i+1) + " Product: " + b.get_product(j).get_product_name() + " Model: " + (k+1) + " Color: white" );
					}else if(count >2 && b.get_product(j).get_model(k).get_blue_count() <1){
						sb.append("\nBranch: "+ (i+1) + " Product: " + b.get_product(j).get_product_name() + " Model: " + (k+1) + " Color: blue");
					}else if(count >3 && b.get_product(j).get_model(k).get_red_count() <1){
						sb.append("\nBranch: "+ (i+1) + " Product: " + b.get_product(j).get_product_name() + " Model: " + (k+1) + " Color: red");
					}else if(count >4 && b.get_product(j).get_model(k).get_orange_count() <1){
						sb.append("\nBranch: "+ (i+1) + " Product: " + b.get_product(j).get_product_name() + " Model: " + (k+1) + " Color: orange");
					}
				}
			}
			i++;
		}
		return sb.toString();
	}

	/**
	*@retun string that have all item informations
	*/
	public String get_all_items_string(){
		StringBuilder sb = new StringBuilder();

		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()){
			Branch b = (Branch) iter.next();
			sb.append("\n\n\nBranch " + (i+1) + " has theese items.");
			sb.append(b.toString());

			i++;
		}
		return sb.toString();
	}

	/**
	 * adds product in branch (uses from admin)
	 * @param branch_index branch id
	 * @param product_name name of product
	 * @param model_number number of model
	 * @param color_number number of color
	 * @return if success or not
	 * @throws IndexOutOfBoundsException
	 */
	public boolean add_product_by_name_to_branch(int branch_index,String product_name, int model_number, int color_number)throws IndexOutOfBoundsException{
		Branch b = (Branch) get_branch(branch_index);
		for (int i = 0; i < b.get_product_count() ; i++ ) {	//controlling that if there is an item
			if(! b.get_product(i).get_product_name().equals(product_name)){
				System.out.println("This branch doesn't sell this item.");
				return false;
			}
		}
		//they are looking for color and increases that stock
		if(color_number == 1){
			b.find_product_by_name(product_name).get_model(model_number-1).increase_black_count();
			return true;		
		}else if(color_number == 2){
			b.find_product_by_name(product_name).get_model(model_number-1).increase_white_count();
			return true;
		}else if(color_number == 3){
			b.find_product_by_name(product_name).get_model(model_number-1).increase_blue_count();
			return true;
		}else if(color_number == 4){
			b.find_product_by_name(product_name).get_model(model_number-1).increase_red_count();
			return true;			
		}else if(color_number == 5){
			b.find_product_by_name(product_name).get_model(model_number-1).increase_orange_count();
			return true;		
		}
		return false;
	}

	/**
	 *returns string of items each branch
	 * @return string of items each branch
	 */
	public String branch_item_list(){
		StringBuilder sb = new StringBuilder();

		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()){
			Branch b = (Branch) iter.next();
			sb.append("Branch " + (i+1) + " can sell theese items.\n");
			for (int j = 0 ; j< b.get_product_count();j++){
				sb.append("\n   Product name:");
				sb.append(b.get_product(j).get_product_name());
				sb.append("   Model Count:");
				sb.append(b.get_product(j).get_model_count());
				sb.append("   Color Count:");
				sb.append(b.get_product(j).get_color_count());
			}
			sb.append("\n");
			i++;
		}

		return sb.toString();
	}

	/**
	 * it is both for buying and decreasing product
	 * @param product_name name of product
	 * @param model_number number of model
	 * @param color_number number of color
	 * @return if success or not
	 */
	public boolean buy_product_by_name(String product_name, int model_number, int color_number){

		Iterator iter = branches.iterator();
		int i =0;
		while (iter.hasNext()){
			Branch b = (Branch) iter.next();
			//searching item branch by branch then decreases count
			if(color_number == 1){
				if(b.find_product_by_name(product_name).get_model(model_number-1).get_black_count() > 0){
					b.find_product_by_name(product_name).get_model(model_number-1).decrease_black_count();
					return true;
				}
			}else if(color_number == 2){
				if(b.find_product_by_name(product_name).get_model(model_number-1).get_white_count() > 0){
					b.find_product_by_name(product_name).get_model(model_number-1).decrease_white_count();
					return true;
				}
			}else if(color_number == 3){
				if(b.find_product_by_name(product_name).get_model(model_number-1).get_blue_count() > 0){
					b.find_product_by_name(product_name).get_model(model_number-1).decrease_blue_count();
					return true;
				}
			}else if(color_number == 4){
				if(b.find_product_by_name(product_name).get_model(model_number-1).get_red_count() > 0){
					b.find_product_by_name(product_name).get_model(model_number-1).decrease_red_count();
					return true;
				}
			}else if(color_number == 5){
				if(b.find_product_by_name(product_name).get_model(model_number-1).get_orange_count() > 0){
					b.find_product_by_name(product_name).get_model(model_number-1).decrease_orange_count();
					return true;
				}
			}
			i++;
		}

		return false;
	}

	/**
	 * adds customer
	 * @param c customer that will be added
	 * @throws AlreadyAddedException
	 */
	public void add_customer(Customer c) throws AlreadyAddedException{

		for(int i = 0; i< customer_count ; i++){
			if(get_customer(i).get_email().equals(c.get_email())) {
				throw new AlreadyAddedException("This person already added");
			}

		}
		customers.add(c);

		customer_count++;
	}

	/**
	 * admins add branches
	 * @param b branch that will be added
	 */
	public void add_branch(Branch_interface b){
		branch_count++;
		branches.add(branches.size(),b);
	}

	/**
	*admin can delete branch with this, it decreases count
	*@param index is index of branches
	 * @throws IndexOutOfBoundsException
	*/
	public void delete_branch_byindex(int index)throws IndexOutOfBoundsException{
		if(index<branch_count){

			branches.remove(index);

			branch_count--;
		}else{
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}

	}

	/**
	 * adds employye to branch
	*@param branch_index branch index that we want to add
	*@param b branch employee that we want to add
	 *@throws IndexOutOfBoundsException
	*/
	public void add_branch_employee_bybranch_index(int branch_index, Branch_Employee b)throws IndexOutOfBoundsException,AlreadyAddedException{   						//return boolean	//is_already_added()
		if (branch_index < branch_count){
			try {

				get_branch(branch_index).add_branch_employee(b);
			}
			catch (AlreadyAddedException e){
				throw new AlreadyAddedException("This person already added");
			}
		}else{
			throw new IndexOutOfBoundsException("Index " + branch_index + " is out of bounds!");
		}
	}

	/**
	 * deletes employye from branch
	*@param branch_index branch index that we want to add
	*@param index branch employee that we want to add
	 * @throws IndexOutOfBoundsException
	*/
	public void delete_branch_employee_byindex(int branch_index, int index)throws IndexOutOfBoundsException{   						//return boolean
		if(branch_index<branch_count ){

			get_branch(branch_index).delete_branch_employee(index);
		}else{

			throw new IndexOutOfBoundsException("Index " + branch_index + " is out of bounds!");
		}

	}


}