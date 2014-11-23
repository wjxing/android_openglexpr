package ustc.openglexpr.texture;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import ustc.openglexpr.R;
import ustc.openglexpr.sharp.DataPool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class TexturePicture {
    private int mTextureID = -1;
    private FloatBuffer _mVtxBuf = null;
    private FloatBuffer _mTxtBuf = null;
    private ByteBuffer _mIdxBuf = null;
    private static final int NR_POINTS = 3;
    private static final int NR_TEXTURE_POINTS = 2;
    public float ROTATE = 0.0f;
    public TexturePicture(Context ctx, GL10 gl) {
        loadTexture(ctx, gl);
        loadBuffer();
    }

    public void draw(GL10 gl) {
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        _mVtxBuf.position(0);
        _mTxtBuf.position(0);
        _mIdxBuf.position(0);
        gl.glLoadIdentity();
        gl.glRotatef(ROTATE, 0.0f, 1.0f, 0.0f);
        gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, _mVtxBuf);
        gl.glTexCoordPointer(NR_TEXTURE_POINTS, GL10.GL_FLOAT, 0, _mTxtBuf);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, mTextureID);
        gl.glDrawElements(GL10.GL_TRIANGLE_STRIP, _mIdxBuf.remaining(),
                GL10.GL_UNSIGNED_BYTE, _mIdxBuf);
        gl.glFinish();
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D);
        gl.glLoadIdentity();
    }

    private void loadBuffer () {
        ByteBuffer vbb = ByteBuffer.allocateDirect(DataPool.TEXTURE_PIC_COORDS.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        _mVtxBuf = vbb.asFloatBuffer();
        _mVtxBuf.put(DataPool.TEXTURE_PIC_COORDS);
        _mVtxBuf.position(0);

        vbb = ByteBuffer.allocateDirect(DataPool.TEXTURE_COORDS.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        _mTxtBuf = vbb.asFloatBuffer();
        _mTxtBuf.put(DataPool.TEXTURE_COORDS);
        _mTxtBuf.position(0);

        vbb = ByteBuffer.allocateDirect(DataPool.TEXTURE_IDX.length);
        vbb.order(ByteOrder.nativeOrder());
        _mIdxBuf = vbb;
        _mIdxBuf.put(DataPool.TEXTURE_IDX);
        _mIdxBuf.position(0);
    }

    private void loadTexture(Context ctx, GL10 gl) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_launcher);
            int[] textures = new int[1];
            gl.glGenTextures(1, textures, 0);
            mTextureID = textures[0];
            gl.glBindTexture(GL10.GL_TEXTURE_2D, mTextureID);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
        } finally {
            if (bitmap != null)
                bitmap.recycle();
        }
    }
}
