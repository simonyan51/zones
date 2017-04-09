import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by simonyan_51 on 09.04.2017.
 */
public class Client {

    private ArrayList<TimeZone> timeZones;

    public Client() {
        timeZones = new ArrayList<>();
    }

    public void start() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter File Source:");
        readFile(input.nextLine());
        System.out.println("Choose How You Want To Sort. 1-Country Code, 2-Time Zone:");
        sort(timeZones, input.nextInt());
        for (TimeZone timeZone : timeZones) {
            StringBuilder str = new StringBuilder();
            str.append(timeZone.getId()).append(", ").append(timeZone.getCountryCode()).append(", ").append(timeZone.getTimeZone());
            System.out.println(str);
        }
    }

    private void sort(ArrayList<TimeZone> timeZones, int sortIndex) {
        Collections.sort(this.timeZones, new Comparator<TimeZone>() {

            @Override
            public int compare(TimeZone o1, TimeZone o2) {
                if (sortIndex == 1) {
                    return o1.getCountryCode().compareTo(o2.getCountryCode());
                } else if (sortIndex == 2) {
                    return o1.getTimeZone().compareTo(o2.getTimeZone());
                }
                return 0;
            }
        });
    }

    private void readFile(String src) throws IOException {
        FileReader file = new FileReader(src);
        BufferedReader read = new BufferedReader(file);
        String line;
        while((line = read.readLine()) != null) {
            String[] fileAttr = line.replace("\"", "").split(",");
            TimeZone timeZone = new TimeZone(Integer.parseInt(fileAttr[0]), fileAttr[1].trim(), fileAttr[2].trim());
            timeZones.add(timeZone);
        }

    }
}
