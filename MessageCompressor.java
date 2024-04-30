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

         return compressedMessage.toString();
    }

    public String decompressMessage(String compressedMessage) {
        StringBuilder decompressedMessage = new StringBuilder();

        for (int i = 0; i < compressedMessage.length(); i += 2) {
            int count = Character.getNumericValue(compressedMessage.charAt(i));
            char c = compressedMessage.charAt(i + 1);
            decompressedMessage.append(String.valueOf(c).repeat(count));
        }

        return decompressedMessage.toString();
    }
}

        

  
