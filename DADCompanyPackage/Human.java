package DADCompanyPackage;

/**
 * holds informations about human but its abstract class
* @author dervisaliduman
* @version 1.7.0_201
*/
public abstract class Human implements Comparable<Human>, Human_interface{
	protected String name;
	protected String surname;
	protected String email;
	protected String password;
	protected int id;
	protected static int human_count = 0;

	/**
	 * sets humans informations
	 * @param name name of human
	 * @param surname surname of human
	 * @param email email of human
	 * @param password password of human
	 * @param id id of human
	 */
	public Human(String name, String surname,String email, String password, int id){
        set_name(name);
        set_surname(surname);
        set_email(email);
        set_id(id);
        increase_count();
    }

    /**
	*@return human information string
	*/
    @Override
    public String toString(){
        return "\nName: " + get_name() + "\nSurname: " + get_surname() + "\nE-mail: "+ get_email() + "\nID: " + get_id() + "\n";
    }

    /**
	*compares two objects
	* @retun if they are equal true
	*/
    @Override
    public boolean equals(Object o) { 
		if(o == null){
        	return false;
		}
        if(!(o instanceof Human)){
        	return false;
        }

        Human_interface rv = (Human_interface)o ;

        return get_name().equals(rv.get_name()) && get_surname().equals(rv.get_name()) && get_email().equals(rv.get_email()) && get_id() == rv.get_id();
    }

    /**
	*compares two objects
	* @return if they are equal true
	*/
    @Override
    public int compareTo(Human rv){
		if(rv == null)
			return -1;

		if(get_name().equals(rv.get_name()) && get_surname().equals(rv.get_name()) && get_email().equals(rv.get_email()) && get_id() == rv.get_id())
			return 0;

		return -1;
    }

    /**
    *sets name
    *@param name given name
    */
	protected void set_name(String name){
		this.name = name;
	}

	/**
	*sets surname of human
	*/
	protected void set_surname(String surname){
		this.surname = surname;
	}

	/**
	*sets email
	*@param email email of human
	*/
	protected void set_email(String email){
		this.email = email;
	}

	/**
	*sets password
	*@param password given password
	*/
	protected void set_password(String password){
		this.password = password;
	}

	/**
	*sets id
	*@param id given id
	*/
	protected void set_id(int id){
		this.id = id;
	}

	/**
	*@return name of user
	*/
	@Override
	public String get_name(){
		return name;
	}

	/**
	*@return surname of user
	*/
	@Override
	public String get_surname(){
		return surname;
	}

	/**
	*@return email of user
	*/
	@Override
	public String get_email(){
		return email;
	}

	/**
	*@return password of user
	*/
	@Override
	public String get_password(){
		return password;
	}

	/**
	*@return id of user
	*/
	@Override
	public int get_id(){
		return id;
	}

	/**
	*increases human count
	*/
	protected static void increase_count(){
		human_count++;
	}

	/**
	*decreases human count
	*/
	protected static void decrease_count(){
		human_count--;
	}

}