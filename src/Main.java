import java.io.IOException;

/**
 * Created by simonyan_51 on 09.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
