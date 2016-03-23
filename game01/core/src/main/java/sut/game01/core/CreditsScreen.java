package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.*;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class CreditsScreen extends Screen {

  private ScreenStack ss;
  private ImageLayer bgLayer;
  private ImageLayer backButtom;
  private ImageLayer wordLayer;

  public CreditsScreen(final ScreenStack ss) {
    this.ss = ss;

    Image bgImage = assets().getImage("images/credits_sc.png");
    this.bgLayer = graphics().createImageLayer(bgImage);
    Image wordImage = assets().getImage("images/credits_word.png");
    this.wordLayer = graphics().createImageLayer(wordImage);
    Image backImage = assets().getImage("images/back_credits.png");
    this.backButtom = graphics().createImageLayer(backImage);
    backButtom.setTranslation(270,344);

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
    this.layer.add(wordLayer);
    this.layer.add(backButtom);

  }

}







