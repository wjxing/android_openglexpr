package ustc.openglexpr.sharp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public abstract class SharpAbs {
    public float RED = 0.0f;
    public float GREEN = 25.0f;
    public float BLUE = 200.0f;
    public float ALPHA = 0.5f;
    public float ROTATE = 0.0f;

    protected ShortBuffer mIdxBuffer = null;
    protected FloatBuffer mVtxBuffer = null;

    private final short[] INDICES_ARRAR = { 0, 1, 2 };

    protected static final int NR_POINTS = 3;
    protected int NR_VERTICES = 1;
    protected int NR_SHARPS = 1;

    public SharpAbs() {
    }

    public void updateVertexBuffer(float[] vtxBuf) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(NR_VERTICES * 3 * 4 * NR_SHARPS);
        vbb.order(ByteOrder.nativeOrder());
        mVtxBuffer = vbb.asFloatBuffer();

        ByteBuffer ibb = ByteBuffer.allocateDirect(NR_VERTICES * 2);
        ibb.order(ByteOrder.nativeOrder());
        mIdxBuffer = ibb.asShortBuffer();

        mVtxBuffer.put(vtxBuf);
        mIdxBuffer.put(INDICES_ARRAR);

        mVtxBuffer.position(0);
        mIdxBuffer.position(0);
    }

    public ShortBuffer getIndexBuffer() {
        return mIdxBuffer;
    }

    public FloatBuffer getFloatBuffer() {
        return mVtxBuffer;
    }

    public int getSharpNum() {
        return NR_SHARPS;
    }
    
    public abstract void draw(GL10 gl);

}
