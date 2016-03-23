package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.*;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class HomeScreen extends Screen {
  private ScreenStack ss;
  private ImageLayer startButton;
  private ImageLayer creditButton;
  private ImageLayer homeButton;
  private ImageLayer titleLayer;
  private final TestScreen testScreen;
  private final CreditsScreen creditsScreen;
  public HomeScreen(final ScreenStack ss) {
    this.ss = ss;
    this.testScreen = new TestScreen(ss);
    this.creditsScreen = new CreditsScreen(ss);

    Image homeImage = assets().getImage("images/home_sc.jpg");
    this.homeButton = graphics().createImageLayer(homeImage);
    Image titleImage = assets().getImage("images/title.png");
    this.titleLayer = graphics().createImageLayer(titleImage);
    Image startImage = assets().getImage("images/start.png");
    this.startButton = graphics().createImageLayer(startImage);
    Image creditImage = assets().getImage("images/credits.png");
    this.creditButton = graphics().createImageLayer(creditImage);
    //titleLayer.setTranslation(350,5);
    creditButton.setTranslation(5,235);
    startButton.setTranslation(5,35);

    startButton.addListener(new Mouse.LayerAdapter(){
       @Override 
       public void onMouseUp(Mouse.ButtonEvent event){
        ss.push(testScreen); // <-- pop screen
       }
    });

    creditButton.addListener(new Mouse.LayerAdapter(){
       @Override 
       public void onMouseUp(Mouse.ButtonEvent event){
        ss.push(creditsScreen); // <-- pop screen
       }
    });

  }
  @Override
  public void wasShown(){
    super.wasShown();
    this.layer.add(homeButton);
    //this.layer.add(titleLayer);
    this.layer.add(startButton);
    this.layer.add(creditButton);
    

  }

}







