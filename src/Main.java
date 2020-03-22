import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.Event;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            Gson g = new Gson();

            JsonReader reader = new JsonReader((new FileReader("03-21_07_28_34-4.json")));

            Event[] events = g.fromJson(reader, Event[].class);

            System.out.println(events.length);
            System.out.println(events[0].getTimestamp());

            EventsProcessor.process(events);
        }catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        }


    }
}
