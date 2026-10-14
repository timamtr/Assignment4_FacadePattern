public class HomeTheaterFacade {
    private final Amplifier amp;
    private final DvdPlayer dvd;
    private final Projector projector;
    private final Screen screen;
    private final TheaterLights lights;
    private final PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector,
                             Screen screen, TheaterLights lights, PopcornPopper popper) {
        if (amp == null || dvd == null || projector == null || screen == null || lights == null || popper == null) {
            throw new IllegalArgumentException("Subsystem components cannot be null");
        }
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        try {
            popper.on();
            popper.pop();
            lights.dim(10);
            screen.down();
            projector.on();
            projector.wideScreenMode();
            amp.on();
            amp.setSurroundSound();
            amp.setVolume(5);
            dvd.on();
            dvd.play(movie);
        } catch (Exception e) {
            System.err.println("Error occurred while setting up the home theater: " + e.getMessage());
        }
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
