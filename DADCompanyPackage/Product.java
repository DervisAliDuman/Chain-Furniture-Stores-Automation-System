package DADCompanyPackage;

/**
 * it includes items with some features like model and color
* @author dervisaliduman
* @version 1.7.0_201
*/
public class Product implements Product_interface{
	private String product_name;
	private int model_count = 0;
	private int color_count = 0;
	private int product_count = 0;

	private HybridList<Model> models = new HybridList<Model>();

	/**
	 * creates products at least one product per model and color
	 * @param product_name name of product
	 * @param model_count model count of product
	 * @param color_count color count for each model
	 */
	public Product(String product_name, int model_count, int color_count){
		set_product_name(product_name);
		set_model_count(model_count);
		this.color_count = color_count;
		product_count = model_count*color_count;

		for (int i = 0; i < get_model_count(); i++ ){
			models.add(new Model(color_count));
		}

	}

	/**
	*gets model by its index
	*@param index of returned model
	*@return model that given index
	*/
	@Override
	public Model get_model(int index){
		return models.get(index);
	}

	/**
	 * sets product name from given string
	 * @param product_name setts product name from this
	 */
	@Override
	public void set_product_name(String product_name){
		this.product_name = product_name;
	}

	/**
	*sets model count from given count
	*@param model_count sets model count from this
	*/
	@Override
	public void set_model_count(int model_count){
		this.model_count=model_count;
	}
	
	/**
	*@return products name string
	*/
	@Override
	public String get_product_name(){
		return product_name;
	}

	/**
	* @return how many model we have
	*/
	@Override
	public int get_model_count(){
		return model_count;
	}

	/**
	*@retun total color count
	*/
	@Override
	public int get_color_count(){
		return color_count;
	}

	/**
	*@retun string of all products this class has
	*/
	@Override
	public String get_stock_string(){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i< get_model_count() ; i++) {	//adds product info's model by model in string
			sb.append("\nModels "+ (i+1) +" for: "+get_product_name());
				if(color_count>0){
					sb.append("\nBlack count: "+ models.get(i).get_black_count());
				}
				if(color_count>1){
					sb.append("\nWhite count: "+ models.get(i).get_white_count());
				}
				if(color_count>2){
					sb.append("\nBlue count: "+ models.get(i).get_blue_count());
				}
				if(color_count>3){
					sb.append("\nRed count: "+ models.get(i).get_red_count());
				}
				if(color_count>4){
					sb.append("\nOrange count: "+ models.get(i).get_orange_count());
				}
		}
		return sb.toString();
	}
} 