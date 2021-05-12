package DADCompanyPackage;

/**
 * 
 * @author dervisaliduman
 *
 */
public interface Human_interface {

	/**
	*@return human information string
	*/
	String toString();

	/**
	*compares two objects
	* @retun if they are equal true
	*/
	boolean equals(Object o);

	/**
	*@return name of user
	*/
	String get_name();

	/**
	*@return surname of user
	*/
	String get_surname();

	/**
	*@return email of user
	*/
	String get_email();

	/**
	*@return password of user
	*/
	String get_password();

	/**
	*@return id of user
	*/
	int get_id();

}