package stargame.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by ASUS on 19.12.2017.
 */

public class BaseTexture extends Texture{

    public BaseTexture(String internalPath){
        this(Gdx.files.internal(internalPath));
    }

    public BaseTexture(FileHandle file) {
        super(file, true);
        setFilter(TextureFilter.MipMapLinearNearest, TextureFilter.Linear);
    }
}
