package data;

import java.util.Scanner;

@SuppressWarnings("resource")
public class test {
	static EasyStorage storage = new EasyStorage("out.txt");

	public static void main(String[] arrays) {
		one(false);
	}

	public static void one(boolean stupid) {
		if (stupid != true) {
			System.out.println("What would you like to do");
		}
		System.out.println(":: Write | Get | Delete ::");
		Scanner scanner = new Scanner(System.in);
		String action = scanner.nextLine();
		String Action = action.toLowerCase();
		if (Action.equals("write") || Action.equals("get") || Action.equals("delete")) {
			if (Action.equals("write")) {
				write(false);
			}
			if (Action.equals("get")) {
				get(false);
			}
			if (Action.equals("delete")) {
				delete(false);
			}
		} else {
			System.out.println("'" + Action + "' Is not a posible action, please try again!");
			one(true);
		}
	}

	public static void write(boolean stupid) {
		if (stupid != true) {
			System.out.println("Wellcome to the write menu!");
		}
		System.out.println("Type 'Back' to go back or type 'Next' to continue!");
		Scanner scanner = new Scanner(System.in);
		String Action = scanner.nextLine().toUpperCase();
		if (Action.equals("BACK") || Action.equals("NEXT")) {
			if (Action.equals("BACK")) {
				one(false);
			}
			if (Action.equals("NEXT")) {
				writenext(false, null, null);
			}
		} else {
			System.out.println("'" + Action + "' Is not a posible action, please try again!");
			write(true);
		}
	}

	public static void writenext(boolean yesOrNoStupid, String id2, String data2) {
		if (yesOrNoStupid != true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the id for the save to be called! (CaSeSeNsItIvE!)");
			String ID = scanner.nextLine();
			System.out.println("Now please enter the data! (CaSeSeNsItIvE!)");
			String Data = scanner.nextLine();
			System.out.println("We have recived the data:: ID: " + ID + " :: and the data :: Data: " + Data);
			System.out.println("Can you confirm this is correct: Y | N");
			String Confirm = scanner.nextLine().toUpperCase();
			if (Confirm.equals("Y") || Confirm.equals("N")) {
				if (Confirm.equals("Y")) {
					System.out.println("Writing :: ID: " + ID + " :: and the data :: Data: " + Data + " :: To file.");
					storage.write(ID, Data);
					
					one(false);
				} else {
					one(false);
				}
			} else {
				writenext(true, ID, Data);
			}
			one(false);
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Can you confirm this is correct: Y | N");
			String Confirm = scanner.nextLine().toUpperCase();
			if (Confirm.equals("Y") || Confirm.equals("N")) {
				if (Confirm.equals("Y")) {
					System.out.println("Writing :: ID: " + id2 + " :: and the data :: Data: " + data2 + " :: To file.");
					storage.write(id2, data2);
					one(false);
				} else {
					one(false);
				}
			} else {
				writenext(true, id2, data2);
			}
		}
	}

	public static void get(boolean stupid) {
		if (stupid != true) {
			System.out.println("Wellcome to the get menu!");
		}
		System.out.println("Type 'Back' to go back or type 'Next' to continue!");
		Scanner scanner = new Scanner(System.in);
		String Action = scanner.nextLine().toUpperCase();
		if (Action.equals("BACK") || Action.equals("NEXT")) {
			if (Action.equals("BACK")) {
				one(false);
			}
			if (Action.equals("NEXT")) {
				System.out.println("Please enter the call id!");
				String ID = scanner.nextLine();
				System.out.println("Sent get request!");
				String get = storage.get(ID);
				System.out.println("Got: '" + get + "' from the id " + ID + ".");
				one(false);
			}
		} else {
			System.out.println("'" + Action + "' Is not a posible action, please try again!");
			get(true);
		}
	}

	public static void delete(boolean stupid) {
		if (stupid != true) {
			System.out.println("Wellcome to the delete menu!");
		}
		System.out.println("Type 'Back' to go back or type 'Next' to continue!");
		Scanner scanner = new Scanner(System.in);
		String Action = scanner.nextLine().toUpperCase();
		if (Action.equals("BACK") || Action.equals("NEXT")) {
			if (Action.equals("BACK")) {
				one(false);
			}
			if (Action.equals("NEXT")) {
				System.out.println("Please enter the id of the data you would like to delete! (CaSeSeNsItIvE!)");
				String ID = scanner.nextLine();
				System.out.println("Sent delete request!");
				storage.delete(ID);
				one(false);
			}
		} else {
			System.out.println("'" + Action + "' Is not a posible action, please try again!");
			delete(true);
		}
	}
	
	public static void deletenext(boolean yesOrNoStupid, String id2) {
		if (yesOrNoStupid != true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the id for the delete to be called! (CaSeSeNsItIvE!)");
			String ID = scanner.nextLine();
			System.out.println("We have recived the data:: ID:" + ID + " ::");
			System.out.println("Can you confirm this is correct: Y | N");
			String Confirm = scanner.nextLine().toUpperCase();
			if (Confirm.equals("Y") || Confirm.equals("N")) {
				if (Confirm.equals("Y")) {
					System.out.println("Deleting '" + ID + "'");
					storage.delete(ID);
					
					one(false);
				} else {
					one(false);
				}
			} else {
				deletenext(true, ID);
			}
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Can you confirm this is correct: Y | N");
			String Confirm = scanner.nextLine().toUpperCase();
			if (Confirm.equals("Y") || Confirm.equals("N")) {
				if (Confirm.equals("Y")) {
					System.out.println("Deleting '" + id2 + "'");
					storage.delete(id2);
					
					one(false);
				} else {
					one(false);
				}
			} else {
				deletenext(true, id2);
			}
		}
	}
}
