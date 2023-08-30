package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AdminController;
import controller.BookController;
import controller.UserController;
import model.Book;
import model.User;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s[];
		System.out.println("--------------*****LIBRARY MANAGEMENT SYSTEM*****------------");
		System.out.println("MENU: 1.ADMIN 2.USER ");
		int option = scanner.nextInt();
		if (option == 1) {
			scanner.nextLine();
			AdminController con = new AdminController();
			System.out.println("Enter Username");
			String username = scanner.nextLine();
			System.out.println("Enter Password");
			String password = scanner.nextLine();
			System.out.println(con.AdminLoginValidation(username, password));
			BookController controller = new BookController();
			UserController conn = new UserController();
			try {
				int a;
				do {
					System.out.println("MENU: 1.Add Book 2.View Book 3.Update Book 4.Delete Book 5.View User 6.Change Password");
					option = scanner.nextInt();
					switch (option) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter bookid,bookname,author,publisher,publishedyear,language for ADD");
						s = scanner.nextLine().split(",");
						System.out.println(controller.addBook(Integer.parseInt(s[0]), s[1], s[2], s[3],
								Integer.parseInt(s[4]), s[5]));

						break;
					case 2:
						System.out.format("%-10s%-30s%-20s%-30s%-20s%s\n", "Book_ID", "BOOK_NAME", "AUTHOR",
								"PUBLISHER", "PUBLISHED_YEAR", "LANGUAGE");
						for (Book bk : controller.viewBook()) {
							System.out.println(bk);
						}
						break;

					case 3:
						scanner.nextLine();
						System.out.println("Enter bookid,bookname,author,publisher,publishedyear,language for UPDATE");
						s = scanner.nextLine().split(",");
						System.out.println(controller.updateBook(Integer.parseInt(s[0]), s[1], s[2], s[3],
								Integer.parseInt(s[4]), s[5]));
						break;
					case 4:

						System.out.println("Enter bookid for DELETE");
						Integer bookid = scanner.nextInt();
						System.out.println(controller.deleteBook(bookid));
						break;
						
					case 5:
						System.out.format("%-20s%-20s%-20s%-20s\n","USERNAME","EMAIL","MOBILENUMBER","PASSWORD");
						for(User us : conn.viewUser()) {
							System.out.println(us);
							
						}
						break;
					case 6:
						scanner.nextLine();
						System.out.println("Enter Username,Password to change");
						s = scanner.nextLine().split(",");
						System.out.println(con.ChangePassword(s[0], s[1]));
						break;

					default:
						System.out.println("Please Enter the Valid Option");
					}
					System.out.println("\nPress 1 for continue Admin operation else press 0");
					a = scanner.nextInt();
				} while (a == 1);

				System.out.println("Thank You!");
			} catch (InputMismatchException ex) {
				System.out.println(ex.getMessage());
			}
		} else if (option == 2) {
			System.out.println("Press 1 for Login ,Press 2 Register");
			option = scanner.nextInt();
			if (option == 1) {
				scanner.nextLine();
				UserController conn = new UserController();
				System.out.println("Enter Name");
				String name = scanner.nextLine();
				System.out.println("Enter Password");
				String pass = scanner.nextLine();
				System.out.println(conn.userloginvalidation(name, pass));
				BookController controller = new BookController();
				try {
					int a;

					do {
						System.out.println("MENU: 1.View Books 2.Update Details ");
						option = scanner.nextInt();
						switch (option) {
						case 1:
							System.out.format("%-10s%-30s%-20s%-30s%-20s%s\n", "Book_ID", "BOOK_NAME", "AUTHOR",
									"PUBLISHER", "PUBLISHED_YEAR", "LANGUAGE");
							for (Book bk : controller.viewBook()) {
								System.out.println(bk);

							}
							break;
						case 2:
							scanner.nextLine();
							System.out.println("Enter Name,Email,MobileNumber,Password");
							s = scanner.nextLine().split(",");
							System.out.println(conn.updatedetail(s[0], s[1], Long.parseLong(s[2]), s[3]));
							break;

						default:
							System.out.println("Please Enter the Valid Option");
						}
						System.out.println("\nPress 1 for continue User operation else press 0");
						a = scanner.nextInt();
					} while (a == 1);

					System.out.println("Thank You!");
				} catch (InputMismatchException ex) {
					System.out.println(ex.getMessage());
				}
			} else if (option == 2) {
				scanner.nextLine();
				UserController conn = new UserController();
				System.out.println("Please enter the necessary information to Register!");
				System.out.println("Enter Name,Email,MobileNumber,Password");
				s = scanner.nextLine().split(",");
				System.out.println(conn.addUser(s[0], s[1], Long.parseLong(s[2]), s[3]));
			} else {
				System.out.println("Please Enter the Valid Option");
			}
		} else {
			System.out.println("Please Enter the Valid Option");
		}
		scanner.close();
	}
}
