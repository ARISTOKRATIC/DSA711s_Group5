import java.util.UUID;

public class ClientNode {
    private String id;
    private ServerNode server;
    private MessageCompressor messageCompressor = new MessageCompressor();

    // Constructor creating a new ClientNode with a unique ID
    public ClientNode(ServerNode server) {
        // Generates a unique ID for each client node
        this.id = UUID.randomUUID().toString();
        this.server = server;
    }

    // Method to send a message to the server node
    public void send(String message) {
        // This just calls server's receiveMessage method to send the message
        server.receiveMessage(this.id, message);
    }

    // Method to receive a message from the server node and decompresses the message
    public void receive(String message, String senderId) {
        String decompressedMessage = messageCompressor.decompressMessage(message);
        // Print the message and the name/ID of the sender
        System.out.println("Client " + this.id + " received a message from " + senderId + ": " + decompressedMessage);
    }

    // Getter for the client node's ID
    public String getId() {
        return id;
    }

    // Main method to demonstrate (Testing purposes)
    public static void main(String[] args) {
        // Creating a server node instance
        ServerNode server = new ServerNode();

        // Creating a client node instance
        ClientNode client1 = new ClientNode(server);
        ClientNode client2 = new ClientNode(server);


        // Simulate client1 sending a message to client2 via the server
        client1.send("Hello from " + client1.getId());

        // The server would then broker the message to client2
        server.brokerMessages();
    }
}