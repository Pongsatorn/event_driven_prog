package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.*;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class TestScreen extends Screen {

  private ScreenStack ss;
  private ImageLayer bgLayer;
  private ImageLayer backButtom;

  public TestScreen(final ScreenStack ss) {
    this.ss = ss;

    Image bgImage = assets().getImage("images/bg.png");
    this.bgLayer = graphics().createImageLayer(bgImage);
    Image backImage = assets().getImage("images/back-button.png");
    this.backButtom = graphics().createImageLayer(backImage);
    backButtom.setTranslation(235,350);

    backButtom.addListener(new Mouse.LayerAdapter(){
       @Override 
       public void onMouseUp(Mouse.ButtonEvent event){
        ss.remove(ss.top()); // <-- pop screen
       }
    });



  }
  @Override
  public void wasShown(){
    super.wasShown();
    this.layer.add(bgLayer);
    this.layer.add(backButtom);

  }

}







