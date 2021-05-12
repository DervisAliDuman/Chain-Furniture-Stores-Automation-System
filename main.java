import DADCompanyPackage.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
* @author dervisaliduman
* @version 1.7.0_201
*/
public class main{
	public static void main(String[] args) {

		System.out.print("\n\n\n\n");

		Company com = new Company("Dervis","Duman","asd@gmail.com","12345678");
		Admin first_admin = com.get_admin(0);
		System.out.println("DADCompanyPackage.Company created and DADCompanyPackage.Admin added: \n"+ com.get_admin(0));

		try {
			System.out.println("Trying to reach don't exist admin indexed 2: ");
			com.get_admin(2);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println(first_admin.toString());

		Customer customer = new Customer(com,"ali","alici","bbb@bbb.com","32325345");
		Customer customer2 = new Customer(com,"mehmet","kurt","aaa@aaa.com","32325345");
		try {
			customer.singin();
		}catch (AlreadyAddedException a){
			System.out.println(a);
		}

		try {
			customer.singin();
		}catch (AlreadyAddedException a){
			System.out.println(a);
		}
		try {
			customer2.singin();
		}catch (AlreadyAddedException a){
			System.out.println(a);
		}

		customer.subscribe("rose city","555 999 22 44");

		HybridList<Product_interface> products = new HybridList<Product_interface>();
		products.add(new Product("office chair", 7 ,5)) ;

		HybridList<Product_interface> products2 = new HybridList<Product_interface>();
		products2.add(new Product("bookcase", 12 ,1)) ;
		products2.add(new Product("office cabinet", 12 ,1)) ;

		HybridList<Product_interface> products3 = new HybridList<Product_interface>();
		products3.add(new Product("office desk", 5 ,4)) ;

		HybridList<Product_interface> products4 = new HybridList<Product_interface>();
		products4.add(new Product("meeting table", 10 ,4));

		first_admin.add_branch(products,1);
		first_admin.add_branch(products2,2);
		first_admin.add_branch(products3,1);
		first_admin.add_branch(products4,1);

		try {
			first_admin.add_branch_employee_to_branch(0,"fatih","caliskan","aaa@aaa.com","1234567");
		}
		catch (AlreadyAddedException e){
			System.out.println(e);
		}

		try {
			first_admin.add_branch_employee_to_branch(1,"ahmet","caliskan","ddd@ddd","1234567");
		}
		catch (AlreadyAddedException e){
			System.out.println(e);
		}

		try {
			first_admin.add_branch_employee_to_branch(2,"mehmet","caliskan","eee@eee","1234567");
		}
		catch (AlreadyAddedException e){
			System.out.println(e);
		}

		try {
			first_admin.add_branch_employee_to_branch(3,"mustafa","caliskan","ggg@ggg","1234567");
		}
		catch (AlreadyAddedException e){
			System.out.println(e);
		}

		if (customer.buy_product_by_name_model_and_color("office chair", 1, 1)) {
			System.out.println("DADCompanyPackage.Customer bought black, model 1, office chair ");
		} else{
			System.out.println("Not succesfull buy operation");
		}

		System.out.println(com.get_customer(0).see_listof_products());

		System.out.println(com.get_all_customers_string());
		
		System.out.println(customer.see_purchase_history());
		
		System.out.print("Needed products are: ");
		System.out.println(first_admin.see_listof_products_that_needed());

		if(first_admin.add_product_by_name_model_and_color_to_branch(0,"office chair", 1 , 1)){
			System.out.println("After adding product to branch 1: office chair, model 1, black");
		}else{
			System.out.println("This store doesn't sell this item");
		}

		System.out.println("\n"+first_admin.see_listof_products_that_needed());

		if(first_admin.add_product_by_name_model_and_color_to_branch(2,"office desk", 1 , 3)){
			System.out.println("After adding product to branch 3: office desk, model 1, blue");
		}else{
			System.out.println("This store doesn't sell this item");
		}

		if (first_admin.add_product_by_name_model_and_color_to_branch(0,"office lamb", 3 , 2)){
			System.out.println("After adding product branch 1: office lamb, model 3, white");
		}else{
			System.out.println("This store doesn't sell this item");
		}

		System.out.println(first_admin.see_listof_products());

		try {
			com.get_branch(0).get_branch_employee(0).sell_product_by_name_model_and_color("office chair",3,2,0);
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
	/*	//If you want to delete, you can delete in menu at the same time.
		try {
			first_admin.delete_branch_employee_by_branch_index(0,com.get_branch(0).get_branch_employee(0).get_id());
			System.out.println("Deleted branch employee");
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		try {
			first_admin.delete_branch_byindex(0);
			System.out.println("Deleted branch");
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println("\n"+first_admin.see_listof_products());

		System.out.println("\n\nAs you can see, there is no products of old branch anymore");*/


		//Extra hybritlist test cases
		System.out.println("\n\n\nHybritlist Test cases\n");

		HybridList<Integer> array = new HybridList<Integer>();

		for (int i = 0; i < 15 ; i++) {
			array.add(i);

		}

		System.out.println("Success");

		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}

		System.out.println("Indexof 3: " + array.indexOf(3));
		array.set(0, 99);

		array.remove(0);
		array.remove(1);
		array.add(99);
		array.add(77);
		array.remove(1);
		array.remove(1);
		array.remove(3);
		array.remove(3);
		array.add(55);
		array.add(99);
		array.add(92);
		array.remove(2);

		array.remove(1);
		array.removeLast();

		System.out.println("Success");

		for (int i = 0; i < array.size(); i++) {
			System.out.println("İ: "+i +"   " +array.get(i));
		}



		menu(com);
	}

	public static void menu(Company company){
		boolean loop_flag = true;
		while (loop_flag){
			System.out.println("\n\nWelcome to test menu, please select what you are \n");
			System.out.println("Press 1 if you are admin.");
			System.out.println("Press 2 if you are branch employee.");
			System.out.println("Press 3 if you are customer.");
			System.out.println("Press 4 for exit the program.");
			try {
				Scanner scan = new Scanner(System.in);
				int a = scan.nextInt();
				switch (a) {
					case 1:
						admin_menu(company);
						break;
					case 2:
						branch_employee_menu(company);
						break;
					case 3:
						customer_menu(company);
						break;
					case 4:
						loop_flag=false;
						break;
					default:
						System.out.println("Wrong input detected.");
						break;
				}
			}catch (InputMismatchException eee){
				System.out.println("Invalid input EXCEPTION");
			}
		}

	}

	public static void admin_menu(Company company){
		Admin admin = company.get_admin(0);
		String name = "", surname = "", mail = "", password = "";
		int a, branch_index,model_number,color_number;
		String product_name = "";
		boolean loop_flag = true;
		while (loop_flag) {
			System.out.println("\n\nWelcome to admin test menu, please select what you want \n");
			System.out.println("Press 1 for see list of branch employees.");
			System.out.println("Press 2 for see list of products.");
			System.out.println("Press 3 for see list of products that needed.");
			System.out.println("Press 4 for add branch employee to branch.");
			System.out.println("Press 5 for add product.");
			System.out.println("Press 6 for delete product.");
			System.out.println("Press 7 for delete branch.");
			System.out.println("Press 8 for add branch.");
			System.out.println("Press 9 for delete branch employee.");
			System.out.println("Press 0 for exit.");

			try {
				Scanner scan = new Scanner(System.in);
				a = scan.nextInt();
				switch (a) {
					case 1:
						System.out.println(admin.list_of_branch_employees());
						break;
					case 2:
						System.out.println(admin.see_listof_products());
						break;
					case 3:
						System.out.println("Needed Items are: ");
						System.out.println(admin.see_listof_products_that_needed());
						break;
					case 4:
						System.out.println("Which branch that you want to add");
						System.out.println(admin.list_of_branches());
						System.out.print("DADCompanyPackage.Branch number from list :");
						a = scan.nextInt();
						name = scan.nextLine();
						System.out.println("Give information about employee that you want to  add:");
						System.out.print("Name:");
						name = scan.nextLine();

						System.out.print("Surname:");
						surname = scan.nextLine();
						System.out.print("mail:");
						mail = scan.nextLine();
						System.out.print("password:");
						password = scan.nextLine();


						try {
							admin.add_branch_employee_to_branch((a - 1), name, surname, mail, password);
							System.out.print("Succesfull:");
						} catch (AlreadyAddedException e) {
							System.out.println(e);
						} catch (IndexOutOfBoundsException ee) {
							System.out.println(ee);
						}

						break;
					case 5: System.out.println(admin.branch_item_list());

						try {
							System.out.print("Brach number:");
							branch_index = scan.nextInt();

							surname = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();

							boolean isadded = admin.add_product_by_name_model_and_color_to_branch(branch_index-1,product_name,model_number,color_number);
							if(!isadded){
								System.out.println("Probably your imput mismatched");
							}else{
								System.out.println("Sucsessfull");
							}
						}catch (IndexOutOfBoundsException e){
							System.out.println(e);
						}

						break;
					case 6:

						try {
							surname = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();

							boolean isdeleted = admin.delete_product_by_name(product_name,model_number,color_number);
							if(!isdeleted){
								System.out.println("Probably your input mismatched");
							}else{
								System.out.println("Succesfull");
							}
						}catch (IndexOutOfBoundsException e){
							System.out.println(e);
						}

						break;
					case 7: System.out.println(admin.list_of_branches());
						System.out.print("Which branch that you want to delete: ");
						branch_index = scan.nextInt();
						try {
							admin.delete_branch_byindex(branch_index-1);
							System.out.print("Succesfull:");
						}catch (IndexOutOfBoundsException e){
							System.out.println("Wrong index");
						}catch (NullPointerException ee){
							System.out.println("There are no branches anymore");
						}
						break;
					case 8:
						try {
							System.out.println("First, please write item will sold in that branch.");
							surname = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();

							HybridList<Product_interface> products = new HybridList<Product_interface>();
							products.add(new Product(product_name,model_number,color_number));

							admin.add_branch(products,1);
							System.out.println("Succesfull");
						}catch (IndexOutOfBoundsException e){
							System.out.println("Wrong index");
						}catch (NullPointerException ee){
							System.out.println("There is problem");
						}

						break;
					case 9:
						try {
							System.out.println("Select which employee that you want to delete ");
							System.out.println(admin.list_of_branches());
							System.out.print("Which branch:");
							branch_index = scan.nextInt();

							admin.delete_branch_employee_by_branch_index(branch_index-1,0);
							System.out.println("Succesfull");
						}catch (IndexOutOfBoundsException e){
							System.out.println("Wrong index");
						}catch (NullPointerException ee){
							System.out.println("There are no branch employee in that branch");
						}

						break;
					case 0: loop_flag=false;
						break;
					default:
						System.out.println("Wrong input detected.");
						break;
				}
			}catch (InputMismatchException eee){
				System.out.println("Invalid input EXCEPTION");
			}
		}

	}

	public static void branch_employee_menu(Company company){
		boolean loop_flag = true;
		Branch_Employee branch_employee = company.get_branch(0).get_branch_employee(0);
		String str,product_name;
		int model_number,color_number,customer_index;
		while (loop_flag){
			System.out.println("\n\nWelcome to branch employee test menu; \n");
			System.out.println("Press 1 for see list of products.");
			System.out.println("Press 2 for delete product.");
			System.out.println("Press 3 for see list of customer.");
			System.out.println("Press 4 for sell product to customer.");
			System.out.println("Press 5 for exit.");
			try {
				Scanner scan = new Scanner(System.in);
				int a = scan.nextInt();
				switch (a) {
					case 1:
						System.out.println(branch_employee.see_listof_products());

						break;
					case 2:

						try {
							str = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();

							boolean isdeleted = branch_employee.delete_product_by_name_model_and_color(product_name,model_number,color_number);
							if(!isdeleted){
								System.out.println("Probably we don't have that item.");
							}else{
								System.out.println("Succesfull");
							}
						}catch (IndexOutOfBoundsException e){
							System.out.println(e);
						}catch (NullPointerException ee){
							System.out.println("We dont have this item for now");
						}

						break;
					case 3:
						System.out.println(branch_employee.see_listof_customers());
						break;
					case 4:

						try {
							str = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();
							System.out.print("DADCompanyPackage.Customer index:");
							customer_index = scan.nextInt();

							boolean isdeleted = branch_employee.sell_product_by_name_model_and_color(product_name, model_number, color_number , customer_index);
							if(!isdeleted){
								System.out.println("Probably your input mismatched");
							}else{
								System.out.println("Succesfull");
							}
						}catch (IndexOutOfBoundsException e){
							System.out.println(e);
						}catch (NullPointerException ee){
							System.out.println("We dont have this item for now");
						}

						break;
					case 5:
						loop_flag=false;
						break;
					default:
						System.out.println("Wrong input detected.");
						break;
				}
			}catch (InputMismatchException eee){
				System.out.println("Invalid input EXCEPTION");
			}
		}
	}

	public static void customer_menu(Company company){

		Customer customer =  company.get_customer(0);
		String str,product_name,adress,tel_num;
		int model_number,color_number;
		boolean loop_flag = true;
		while (loop_flag) {
			System.out.println("\n\nWelcome to customer test menu \n");
			System.out.println("Press 1 for subscribe or resubscribe.");
			System.out.println("Press 2 for see list of products.");
			System.out.println("Press 3 for see purchase history.");
			System.out.println("Press 4 for buy product");
			System.out.println("Press 5 for exit");
			try {
				Scanner scan = new Scanner(System.in);
				int a = scan.nextInt();
				switch (a) {
					case 1:
						str = scan.nextLine();
						System.out.print("Adress:");
						adress = scan.nextLine();
						System.out.print("Tel num:");
						tel_num = scan.nextLine();

						customer.subscribe(adress, tel_num);
						System.out.println("Succesfull");
						break;
					case 2:
						System.out.println(customer.see_listof_products());
						break;
					case 3:
						System.out.println(customer.see_purchase_history());
						break;
					case 4:
						try {
							str = scan.nextLine();
							System.out.print("DADCompanyPackage.Product name:");
							product_name= scan.nextLine();
							System.out.print("DADCompanyPackage.Model number:");
							model_number = scan.nextInt();
							System.out.print("Color number:");
							color_number = scan.nextInt();

							boolean isdeleted = customer.buy_product_by_name_model_and_color(product_name,model_number,color_number);
							if(!isdeleted){
								System.out.println("Probably we dont have that item");
							}else{
								System.out.println("Succesfull");
							}
						}catch (IndexOutOfBoundsException e){
							System.out.println(e);
						}catch (NullPointerException ee){
							System.out.println("We dont have this item for now");
						}

						break;
					case 5:
						loop_flag = false;
						break;

					default:
						System.out.println("Wrong input detected.");
						break;
				}
			} catch (InputMismatchException eee) {
				System.out.println("Invalid input EXCEPTION");
			}
		}
	}

}
