package facade;

import facade.devices.Amplifier;
import facade.devices.CdPlayer;
import facade.devices.DvdPlayer;
import facade.devices.PopcornPopper;
import facade.devices.Projector;
import facade.devices.Screen;
import facade.devices.TheatreLights;
import facade.devices.Tuner;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class FacadeTest {

  @Test
  public void testHomeTheater_watchMovie() {
    Amplifier amplifier = Mockito.mock(Amplifier.class);
    CdPlayer cdPlayer = Mockito.mock(CdPlayer.class);
    DvdPlayer dvdPlayer = Mockito.mock(DvdPlayer.class);
    PopcornPopper popcornPopper = Mockito.mock(PopcornPopper.class);
    Projector projector = Mockito.mock(Projector.class);
    Screen screen = Mockito.mock(Screen.class);
    TheatreLights theatreLights = Mockito.mock(TheatreLights.class);
    Tuner tuner = Mockito.mock(Tuner.class);

    HomeTheaterFacade homeTheaterFacade =
        new SimpleHomeTheaterFacade(
            amplifier, cdPlayer, dvdPlayer, popcornPopper, projector, screen, theatreLights, tuner);

    homeTheaterFacade.watchMovie("Batman");

    InOrder inOrder =
        Mockito.inOrder(
            popcornPopper,
            popcornPopper,
            theatreLights,
            screen,
            projector,
            projector,
            amplifier,
            amplifier,
            amplifier,
            amplifier,
            dvdPlayer,
            dvdPlayer);

    inOrder.verify(popcornPopper).on();
    inOrder.verify(popcornPopper).pop();
    inOrder.verify(theatreLights).dim();
    inOrder.verify(screen).down();
    inOrder.verify(projector).on();
    inOrder.verify(projector).wideScreenMode();
    inOrder.verify(amplifier).on();
    inOrder.verify(amplifier).setDvd();
    inOrder.verify(amplifier).setSurroundSound();
    inOrder.verify(amplifier).setVolume();
    inOrder.verify(dvdPlayer).on();
    inOrder.verify(dvdPlayer).play("Batman");
  }

  @Test
  public void testHomeTheater_endMovie() {
    Amplifier amplifier = Mockito.mock(Amplifier.class);
    CdPlayer cdPlayer = Mockito.mock(CdPlayer.class);
    DvdPlayer dvdPlayer = Mockito.mock(DvdPlayer.class);
    PopcornPopper popcornPopper = Mockito.mock(PopcornPopper.class);
    Projector projector = Mockito.mock(Projector.class);
    Screen screen = Mockito.mock(Screen.class);
    TheatreLights theatreLights = Mockito.mock(TheatreLights.class);
    Tuner tuner = Mockito.mock(Tuner.class);

    HomeTheaterFacade homeTheaterFacade =
        new SimpleHomeTheaterFacade(
            amplifier, cdPlayer, dvdPlayer, popcornPopper, projector, screen, theatreLights, tuner);

    homeTheaterFacade.endMovie();

    InOrder inOrder =
        Mockito.inOrder(
            popcornPopper,
            theatreLights,
            screen,
            projector,
            amplifier,
            dvdPlayer,
            dvdPlayer,
            dvdPlayer);

    inOrder.verify(popcornPopper).off();
    inOrder.verify(theatreLights).on();
    inOrder.verify(screen).up();
    inOrder.verify(projector).off();
    inOrder.verify(amplifier).off();
    inOrder.verify(dvdPlayer).stop();
    inOrder.verify(dvdPlayer).eject();
    inOrder.verify(dvdPlayer).off();
  }
}
