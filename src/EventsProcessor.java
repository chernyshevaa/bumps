import model.Event;

import java.util.Arrays;

public class EventsProcessor {
    public static void process(Event[] events){
        int windowSize = 5;
        int skip = 2;

        long begin = events[0].getTimestamp();

        for (int i = 0 + windowSize; i < events.length - windowSize; i += skip){
            boolean hasBump = WindowProcessor.hasBumpByDiff(Arrays.copyOfRange(events, i - windowSize, i+ windowSize));

            if (hasBump){
                System.out.println("Bump at " + (events[i].getTimestamp() - begin) / 1000 + " " + events[i].getLocation());
            }

        }
    }
}
