package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Reload.A;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class Start2 implements Screen  {

    final MyGdxGame game;
    private Viewport viewport;
    private ItemWrapper root;
    private ButtonComponent button = new ButtonComponent();

    boolean screen3 = false;

    //TransformComponent transformComponent = new TransformComponent();

    public Start2(final MyGdxGame gam) {game = gam;}

    @Override
    public void show() {
        System.out.print("Second");

        viewport = new FitViewport(A.x_pit, A.y_pit);
        game.sh.loadScene("Scene2",viewport);
        root = new ItemWrapper(game.sh.getRoot());

        //Ругалось вот тут и что с этим делать
        /*transformComponent = root.getChild("Background").getEntity().getComponent(TransformComponent.class);
        transformComponent.x=10;
        transformComponent = root.getChild("Sky Tag").getEntity().getComponent(TransformComponent.class);
        transformComponent.x=10;*/

        Buttons();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.sh.getEngine().update(Gdx.graphics.getDeltaTime());
        newscren();
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

        root.getChild("Button2").getEntity().getComponent(ButtonComponent.class).addListener(new ButtonComponent.ButtonListener() {
            public void touchUp() {
            }

            public void touchDown() {
            }

            public void clicked() {
                screen3 = true;
            }
        });
    }
    private void newscren(){
        if(screen3)game.setScreen(new Start3(game));
    }

}
