import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            ServerNode server = new ServerNode();
                Star network = new Star();


        while (true) {
            System.out.println("Network Simulator");
            System.out.println("1. Create a new client");
            System.out.println("2. Send a message and broker it");
            System.out.println("3. Delete a client");
            System.out.println("4. Exit");
            System.out.println("5. View number of clients");
            System.out.println("6. List all clients");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Creates a new client and add it to the network
                    ClientNode newClient = new ClientNode(server);
                    network.insertNode(newClient);
                    System.out.println("Created client with ID: " + newClient.getId());
                    break;

                case 2:
                    
                    // Create ClientNode instances and register them with the server
                    ClientNode client1 = new ClientNode(server);
                    ClientNode client2 = new ClientNode(server);
                    server.registerClient(client1);
                    server.registerClient(client2);
                
                    // Simulate receiving messages from clients
                    client1.send("Hello from " + client1.getId());
                    client2.send("Hello from " + client2.getId());
                
                    //To broker messages between clients
                    server.brokerMessages();
                    break;

                case 3:
                    // Delete a client from the network
                    System.out.print("Enter client ID to delete: ");
                    String clientId = scanner.nextLine();
                    network.deleteNode(clientId);
                    break;

                case 4:
                    // Exit the simulator
                    System.out.println("Exiting Network Simulator.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");

                case 5:
                    // Print the number of clients in the network
                    System.out.println("Number of clients: " + Star.getNumberOfClients());
                    break;

                case 6:
                    // List all clients in the network
                    Star.listAllClients();
                    break;


            }
        }
    }
}
