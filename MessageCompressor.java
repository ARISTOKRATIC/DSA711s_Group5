//This class just utilizes the huffman method to compress and decompress messages
public class MessageCompressor {

    public String compressMessage(String message) {
        StringBuilder compressedMessage = new StringBuilder();
        int count = 1;

        for (int i = 0; i < message.length(); i++) {
            if (i < message.length() - 1 && message.charAt(i) == message.charAt(i + 1)) {
                count++;
            } else {
                compressedMessage.append(count).append(message.charAt(i));
                count = 1;
            }
        }

        

  
