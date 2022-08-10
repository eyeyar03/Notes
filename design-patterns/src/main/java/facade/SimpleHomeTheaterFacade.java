package facade;

import facade.devices.Amplifier;
import facade.devices.CdPlayer;
import facade.devices.DvdPlayer;
import facade.devices.PopcornPopper;
import facade.devices.Projector;
import facade.devices.Screen;
import facade.devices.TheatreLights;
import facade.devices.Tuner;

public class SimpleHomeTheaterFacade implements HomeTheaterFacade {

  private Amplifier amplifier;

  private CdPlayer cdPlayer;

  private DvdPlayer dvdPlayer;

  private PopcornPopper popcornPopper;

  private Projector projector;

  private Screen screen;

  private TheatreLights theatreLights;

  private Tuner tuner;

  public SimpleHomeTheaterFacade(
      Amplifier amplifier,
      CdPlayer cdPlayer,
      DvdPlayer dvdPlayer,
      PopcornPopper popcornPopper,
      Projector projector,
      Screen screen,
      TheatreLights theatreLights,
      Tuner tuner) {
    this.amplifier = amplifier;
    this.cdPlayer = cdPlayer;
    this.dvdPlayer = dvdPlayer;
    this.popcornPopper = popcornPopper;
    this.projector = projector;
    this.screen = screen;
    this.theatreLights = theatreLights;
    this.tuner = tuner;
  }

  @Override
  public void watchMovie(String movieTitle) {
    System.out.println("Get ready to watch a movie...");

    popcornPopper.on();
    popcornPopper.pop();

    theatreLights.dim();

    screen.down();

    projector.on();
    projector.wideScreenMode();

    amplifier.on();
    amplifier.setDvd();
    amplifier.setSurroundSound();
    amplifier.setVolume();

    dvdPlayer.on();
    dvdPlayer.play(movieTitle);
  }

  @Override
  public void endMovie() {
    System.out.println("Shutting the movie theater down...");
    popcornPopper.off();

    theatreLights.on();

    screen.up();

    projector.off();

    amplifier.off();

    dvdPlayer.stop();
    dvdPlayer.eject();
    dvdPlayer.off();
  }
}
