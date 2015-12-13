package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Reload.A;
import com.mygdx.game.MyGdxGame;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class Start  implements Screen  {

    final MyGdxGame game;
    private Viewport viewport;
    private ItemWrapper root;
    private ButtonComponent button = new ButtonComponent();

    boolean screen2=false;

    TransformComponent red=new TransformComponent();

    public Start(final MyGdxGame gam) {
        game = gam;
    }

    @Override
    public void show() {
        System.out.print("Start");

        viewport = new FitViewport(A.x_pit, A.y_pit);
        game.sh.loadScene("MainScene",viewport);
        root = new ItemWrapper(game.sh.getRoot());

        red=root.getChild("Red").getEntity().getComponent(TransformComponent.class);
        red.x=10;

        Buttons();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.sh.getEngine().update(Gdx.graphics.getDeltaTime());
        newscreen();
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        //S.saveData();
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {Buttons();
    }

    private void Buttons() {
        game.sh.addComponentsByTagName("button",button.getClass());

        root.getChild("Button1").getEntity().getComponent(ButtonComponent.class).addListener(new ButtonComponent.ButtonListener() {
            public void touchUp() {
            }

            public void touchDown() {
            }

            public void clicked() {
                screen2=true;
            }
        });
    }

    private void newscreen()
    {
       if(screen2) game.setScreen(new Start2(game));
    }

}
