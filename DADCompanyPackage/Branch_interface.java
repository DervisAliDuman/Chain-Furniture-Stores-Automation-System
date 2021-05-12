package DADCompanyPackage;

public interface Branch_interface {

	/**
	 * adds branch employeee in employee array that in the parameters
	 * @param b employee that will be added
	 */
	void add_branch_employee(Branch_Employee b) throws AlreadyAddedException;

	/**
	 * Deletes branch employees by index
	 * @param index index of employee
	 */
	void delete_branch_employee(int index);

	/**
	 *
	 * @param index index of wanted employee
	 * @return return employee in that index
	 */
	Branch_Employee get_branch_employee(int index);

	/**
	*gets id of branch
	*/
	int get_id();

	/**
	 * @param index index of product
	 *@return product class element by index
	 */
	Product_interface get_product(int index);

	/**
	*@return count of product
	*/
	int get_product_count();

	/**
	*finds products by names in all products
	*@param product_name takes name of product for find it
	*@return product that found
	*/
	Product_interface find_product_by_name(String product_name);

	int get_branch_employee_count();

	/**
	*uses products toString() method and creates strin for itself in order to show productlist
	*@return product list as a string
	*/
	String toString();

}