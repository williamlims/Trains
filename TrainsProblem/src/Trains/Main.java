package Trains;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Graph<String> graph = new Graph<String>();
		Scanner input = new Scanner(System.in);
		int option = 10;
		
		while(option != 0) {
			System.out.println("################## OPTIONS MENU ####################");
			System.out.println("1 - Enter (1) to upload the Vertex File.");
			System.out.println("2 - Enter (2) to upload the Graph File.");
			System.out.println("3 - Enter (3) to TEST the App.");
			System.out.println("4 - Enter (4 or any other key) to exit.");
			option = Integer.parseInt(input.nextLine());
			
			if(option == 1) {
				graph.uploadFileVertex(graph);
			} else if(option == 2) {
				graph.uploadFileGraph(graph);
			} else if(option == 3) {
				graph.Test(graph);
				System.out.println("Press any key!");
				input.nextLine();				
			} else {
				break;
			}
			option = 10;	 
		}
		input.close();
		System.out.println("APPLICATION CLOSED!");
			        
	}

}
