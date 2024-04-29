import java.util.HashMap;
import java.util.Map;

public class Star {
    // A map to hold the nodes in the network model
    private static Map<String, ClientNode> nodes;

    
    public Star() {
        nodes = new HashMap<>();
    }



    // Method to get the number of clients in the network
        public static int getNumberOfClients() {
            return nodes.size();
    }


    // Method to retrieve a node from the network model
    public static ClientNode getNode(String nodeId) {
        return nodes.get(nodeId);
    }
    // Method to insert a node into the network model
    public void insertNode(ClientNode node) {
        // Adding the node to the map using its ID as the key
        nodes.put(node.getId(), node);
        System.out.println("Node with ID " + node.getId() + " inserted into the network.");
    }

    // Method to delete a node from the network model
    public void deleteNode(String nodeId) {
        // Removing the node from the map using its ID
        if (nodes.containsKey(nodeId)) {
            nodes.remove(nodeId);
            System.out.println("Node with ID " + nodeId + " deleted from the network.");
        } else {
            System.out.println("Node with ID " + nodeId + " not found in the network.");
        }
    }

    public static void listAllClients() {
        if (nodes.isEmpty()) {
            System.out.println("No clients in the network.");
        } else {
            System.out.println("List of clients in the network:");
            nodes.forEach((id, client) -> System.out.println("Client ID: " + id));
        }


    
        ServerNode server = new ServerNode();

        // Create a Star network model instance
        Star networkModel = new Star();

        // Creating  client node instances
        ClientNode client1 = new ClientNode(server);
        ClientNode client2 = new ClientNode(server);

        // Inserting nodes into the network model
        networkModel.insertNode(client1);
        networkModel.insertNode(client2);

        // Deleting a node from the network model
        networkModel.deleteNode(client1.getId());




    }
}