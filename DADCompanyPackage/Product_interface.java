package DADCompanyPackage;

public interface Product_interface {

	/**
	*gets model by its index
	*@param index of returned model
	*@return model that given index
	*/
	Model get_model(int index);

	/**
	 * sets product name from given string
	 * @param product_name setts product name from this
	 */
	void set_product_name(String product_name);

	/**
	*sets model count from given count
	*@param model_count sets model count from this
	*/
	void set_model_count(int model_count);

	/**
	*@return products name string
	*/
	String get_product_name();

	/**
	* @return how many model we have
	*/
	int get_model_count();

	/**
	*@retun total color count
	*/
	int get_color_count();

	/**
	*@retun string of all products this class has
	*/
	String get_stock_string();

}