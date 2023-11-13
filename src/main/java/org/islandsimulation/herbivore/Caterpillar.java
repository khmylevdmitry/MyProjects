package org.islandsimulation.herbivore;

import lombok.Getter;
import org.islandsimulation.animal.Fox;
import org.islandsimulation.animal.Predator;
import org.islandsimulation.properties.AnimalProperties;
import org.islandsimulation.util.ConfigurationManager;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Caterpillar extends Herbivore {

    private static AnimalProperties properties;
    private double currentSaturation;
    private double maxSaturation;
    private double speed;
    private double weight;
    private boolean hasEaten;

    static {
        try {
            properties = new AnimalProperties(Caterpillar.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Caterpillar() {
        if (properties.getMaxSaturation() == 0) {
            currentSaturation = 0.0;
        } else {
            double randomNumber = ThreadLocalRandom.current().nextDouble(properties.getMaxSaturation() / 2, properties.getMaxSaturation());
            DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
            currentSaturation = Double.parseDouble(df.format(randomNumber));
        }
        maxSaturation = properties.getMaxSaturation();
        speed = properties.getSpeed();
        weight = properties.getWeight();
        hasEaten = false;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    @Override
    public void setCurrentSaturation(double currentSaturation) {
        this.currentSaturation = currentSaturation;
    }


    @Override
    public String toString() {
        return "Caterpillar";
    }
}