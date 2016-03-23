package sut.game01.core;

import static playn.core.PlayN.*;

import react.UnitSlot;

import playn.core.*;
import tripleplay.game.*;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;

public class HomeScreen extends UIScreen {

  public static final Font TITLE_FONT = graphics().createFont("Helvetica",
    Font.Style.PLAIN,24);

  private ScreenStack ss;
  private Root root;
  private final TestScreen testScreen;
  

  public HomeScreen(ScreenStack ss) {
    this.ss = ss;
    this.testScreen = new TestScreen(ss);
  }

  @Override
  public void wasShown(){
    super.wasShown();
    root = iface.createRoot(AxisLayout.vertical().gap(15),
      SimpleStyles.newSheet(),this.layer);
    root.addStyles(Style.BACKGROUND
      .is(Background.bordered(0xFFCCCCCC,
      0xFF99CCFF,5).inset(5,10)));

    root.setSize(width(),height());

    root.add(new Label("START")
     .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));

    root.add(new Button("START").onClick(new UnitSlot(){
      public void onEmit(){
        ss.push(testScreen);
      }
    }));

     root.add(new Label("CREDITS")
     .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));

    root.add(new Button("CREDITS").onClick(new UnitSlot(){
      public void onEmit(){
        ss.push(testScreen);
      }
    }));

  } 
}







