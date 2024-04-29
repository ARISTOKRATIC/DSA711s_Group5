import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.concurrent.ConcurrentHashMap;

public class ServerNode {
    //creating a thread-safe map called messages to store compressed messages.
    private ConcurrentHashMap<String, String> messages = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ClientNode> clients = new ConcurrentHashMap<>();
    private MessageCompressor messageCompressor = new MessageCompressor();

        public void registerClient(ClientNode client) {
            clients.put(client.getId(), client);
        }

            public void receiveMessage(String clientId, String message) {
                String compressedMessage = messageCompressor.compressMessage(message);
                System.out.println("Received compressed message from client " + clientId + ": " + compressedMessage);
                messages.put(clientId, compressedMessage);
                brokerMessages();
            }

                    public void sendMessage(String clientId, String message) {
                        ClientNode client = clients.get(clientId);
                        if (client != null) {
                            client.receive(message, clientId);
                        } else {
                            System.out.println("Client with ID " + clientId + " not found.");
                        }
                    }

                        public void brokerMessages() {
                            messages.forEach((clientId, message) -> {
                                messages.keySet().stream()
                                        .filter(recipientId -> !recipientId.equals(clientId))
                                        .forEach(recipientId -> sendMessage(recipientId, message));
                            });
                        }

    
public static void main(String[] args) {
    ServerNode server = new ServerNode();

    // Create ClientNode instances after creating the ServerNode
    ClientNode client1 = new ClientNode(server);
    ClientNode client2 = new ClientNode(server);

    // Register clients with the server
    server.registerClient(client1);
    server.registerClient(client2);

    // Simulate receiving messages from clients
    client1.send("Hello from " + client1.getId());
    client2.send("Hello from " + client2.getId());

    // Broker messages between clients
    server.brokerMessages();
}
}