import model.Event;

// Checks whether the window of events has bump or not
public class WindowProcessor {

    public static BumpType hasBumpByMean(Event[] events){
        float mean = calculateZMean(events);

        if (mean > 0.3){
            return BumpType.HIGH;
        }else if (mean > 0.2){
            return BumpType.LOW;
        }else {
            return BumpType.NO;
        }
    }

    public static BumpType hasBumpByDiff(Event[] events){
        float diff = calculateZDiff(events);

        if (diff > 1){
            return BumpType.HIGH;
        }else if (diff > 0.5){
            return BumpType.LOW;
        }else {
            return BumpType.NO;
        }
    }

    private static float calculateZMean(Event[] events){
        float mean = 0;
        for (Event e : events){
            float z = Math.abs(e.getZ());
            mean += z;
        }

        return mean;
    }

    private static float calculateZDiff(Event[] events){
        float max = -100;
        float min = 100;
        for (Event e : events){
            if (e.getZ() > max) {
                max = e.getZ();
            }
            if (e.getZ() < min){
                min = e.getZ();
            }
        }

        return (max - min);
    }
}
