package DADCompanyPackage;

/**
 * this class has colors and model counts
* @author dervisaliduman
* @version 1.7.0_201
*/
public class Model{
	private int color_count = 0;
	private int black_count = 0;
	private int white_count = 0;
	private int blue_count = 0;
	private int red_count = 0;
	private int orange_count = 0;
	
	/**
	*just calls color setter by count
	*@param color_count count of all colors
	*/
	public Model(int color_count){
		set_color_count(color_count);
	}

	/**
	*setts all color counts
	*@param color_count count of all colors
	*/
	public void set_color_count(int color_count){
		this.color_count=color_count;

		if(color_count == 5){
			black_count = 1;
			white_count = 1;
			blue_count = 1;
			red_count = 1;
			orange_count = 1;
		}else if(color_count == 4){
			black_count = 1;
			white_count = 1;
			blue_count = 1;
			red_count = 1;
			orange_count = 0;
		}else if(color_count == 3){
			black_count = 1;
			white_count = 1;
			blue_count = 1;
			red_count = 0;
			orange_count = 0;
		}else if(color_count == 2){
			black_count = 1;
			white_count = 1;
			blue_count = 0;
			red_count = 0;
			orange_count = 0;
		}else if(color_count == 1){
			black_count = 1;
			white_count = 0;
			blue_count = 0;
			red_count = 0;
			orange_count = 0;
		}
	}

	/**
	*@return all color count
	*/
	public int get_color_count(){
		return color_count;
	}

	/**
	*@return black color count
	*/
	public int get_black_count(){
		return black_count;
	}

	/**
	*@return white color count
	*/
	public int get_white_count(){
		return white_count;
	}

	/**
	*@return blue color count
	*/
	public int get_blue_count(){
		return blue_count;
	}

	/**
	*@return red color count
	*/
	public int get_red_count(){
		return red_count;
	}

	/**
	*@return orange color count
	*/
	public int get_orange_count(){
		return orange_count;
	}

	/**
	*decreases color count
	*/
	public void decrease_color_count(){
		color_count--;
	}

	/**
	*decreases black color count
	*/
	public void decrease_black_count(){
		black_count--;
		decrease_color_count();
	}

	/**
	*decreases white color count
	*/
	public void decrease_white_count(){
		white_count--;
		decrease_color_count();
	}

	/**
	*decreases blue color count
	*/
	public void decrease_blue_count(){
		blue_count--;
		decrease_color_count();
	}

 	/**
	*decreases red color count
	*/
	public void decrease_red_count(){
		red_count--;
		decrease_color_count();
	}

	/**
	*decreases orange color count
	*/
	public void decrease_orange_count(){
		orange_count--;
		decrease_color_count();
	}

	/**
	*decreases color count
	*/
	public void increase_color_count(){
		color_count++;
	}

	/**
	*decreases black color count
	*/
	public void increase_black_count(){
		black_count++;
	}

	/**
	*decreases white color count
	*/
	public void increase_white_count(){
		white_count++;
		increase_color_count();
	}

	/**
	*decreases blue color count
	*/
	public void increase_blue_count(){
		blue_count++;
		increase_color_count();
	}

	/**
	*decreases red color count
	*/
	public void increase_red_count(){
		red_count++;
		increase_color_count();
	}

	/**
	*decreases orange color count
	*/
	public void increase_orange_count(){
		orange_count++;
		increase_color_count();
	}
}