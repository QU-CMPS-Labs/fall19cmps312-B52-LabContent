package com.cmps312.implicityexplicitytutorial;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Planet implements Parcelable {

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel source) {
            return new Planet(source);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };
    private String name;
    private String description;

    public Planet() {

    }

    public Planet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected Planet(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
    }

    public static ArrayList<Planet> populatePlanetData() {
        ArrayList<Planet> planets = new ArrayList<>();
        Planet planet;


        planet = new Planet();
        planet.setName("Mercury");
        planet.setDescription("\n\nINTRODUCTION\n\nMercury has been known to us " +
                "since 300BC and is a very small planet close to the sun making it" +
                " hard to see. Mercury can only been seen with a telescope before " +
                "sunset or just after dawn. It appears as a small spot in front of" +
                " the surface of the sun. There is no life on Mercury  extreme " +
                "temperature changes make this impossible.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Venus");
        planet.setDescription("\n\nINTRODUCTION\n\nVenus is the second planet from " +
                "the sun and the hottest one in our solar system with temperatures" +
                " up to 462 C.It is often referred to as Earths sister planet as " +
                "they are similar in size mass and density but it is thought to be " +
                "the least hospitable planet due to its intense heat.Venus is one of " +
                "the brightest objects in the sky next to the sun and the moon it is " +
                "the sixth largest planet in our solar system.The surface of the planet " +
                "is rocky and covered in cratered and volcanic land.It also has clouds on " +
                "the surface made up of sulphuric acid these clouds are so thick that they " +
                "stop the heat escaping from the planet keeping the temperature high.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Earth");
        planet.setDescription("\n\nINTRODUCTION\n\nEarth is the largest of the inner planets and the" +
                " only planet in our solar system that is known to support life.Formed around 4.5 " +
                "billion years ago Earth is the only planet not named after a Roman or Greek God or " +
                "Goddess instead it is an English/German word meaning the ground.The Earth is the " +
                "third planet from the sun. Our atmosphere made up of 78 percent nitrogen and 21 " +
                "percent oxygen protects us from the sun’s ultraviolet solar radiation and incoming " +
                "meteoroids which mostly break up when entering the atmosphere.ÒEarth orbits the sun" +
                " every 365 days known as 1 year.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Mars");
        planet.setDescription("\n\nINTRODUCTION\n\nMars is the fourth planet from the sun it is also " +
                "known as the Red Planet due to its red dusty landscape.Named after the Roman god of" +
                " war Mars is the last one of the inner planets.It has two moons and takes 24 hours " +
                "and 37 minutes to spin once on its axis. Mars is a rocky planet this is referred to" +
                " as a terrestrial planet.Over 40 spacecrafts have been launched to explore Mars but " +
                "only around 16 have been successful.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Jupiter");
        planet.setDescription("\n\nINTRODUCTION\n\nJupiter is the largest planet in our solar system" +
                " with a diameter of 139822 km.Named after the King of gods it is the 5th planet from" +
                " the sun and the first of the Gas Giants.Jupiter is made up mainly of gas " +
                "(90 percent hydrogen and 10 percent helium) meaning it does not have a solid " +
                "surface under its atmosphere there is a liquid ocean of water and hydrogen.Jupiter " +
                "has four sets of rings the halo ring the main ring the Amalthea gossamer ring and " +
                "the Thebe gossamer ring these are also referred to as the Jovian ring system.These" +
                " rings are made up of dust particles. Jupiter is known for its great red spot this " +
                "spot is a storm that has lasted for over 300 years.Jupiter has a huge magnetic " +
                "field stronger than any other planet in our solar system. It also has 67 moons " +
                "over 50 of these are known moons with a further 17 awaiting confirmation of discovery." +
                "The four largest moons are Io Europa Ganymede and Callisto and are called the " +
                "Galilean satellites.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Uranus");
        planet.setDescription("\n\nINTRODUCTION\n\nUranus named after the Greek god of the sky " +
                "is the seventh planet from the sun and the third largest in our solar system." +
                "Known mainly as one of the Gas Giants due to its atmosphere of mainly hydrogen " +
                "helium and methane Uranus is also called an Ice Giant as 80 percent or more if " +
                "the planet is made up of icy materials.Unlike the other planets Uranus spins on " +
                "its side at an angle of 98 percent scientists believe this is due to a object the " +
                "size of earth crashing into it causing it to rotate horizontally.");
        planets.add(planet);

        planet = new Planet();
        planet.setName("Saturn");
        planet.setDescription("\n\nINTRODUCTION\n\nSaturn is the sixth planet from the sun and is " +
                "the second largest after Jupiter.Also known as one of the Gas Giants Saturn does " +
                "not have a solid surface.Its atmosphere is made up of predominantly hydrogen and " +
                "helium.  This planet was named after the Roman God of agriculture.Like all the Gas " +
                "Giants Saturn also has rings surrounding it they are a mixture of Ice rock and dust " +
                "particles however its rings are the largest of the four Gas Giants and the brightest." +
                "It also has about 53 known moons and moonlets with at least 9 more waiting " +
                "confirmation of discovery. One of these moons is Titan and is the only " +
                "moon in our solar system to have its own atmosphere.");
        planets.add(planet);


        planet = new Planet();
        planet.setName("Neptune");
        planet.setDescription("\n\nINTRODUCTION\n\nNeptune is the most distant planet in our " +
                "solar system located 4.5 billion Km from the Sun.Named after the God of the " +
                "Sea, Neptune is the fourth largest Planet and like the other Gas Giants is " +
                "made up mostly of hydrogen, helium and methane.Neptune was not known about " +
                "for many centuries due to its distance, it was finally discovered in 1846. " +
                "Neptune has thirteen confirmed moons with one more awaiting confirmation of discovery.");
        planets.add(planet);

        return planets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
    }
}
