package ustc.openglexpr.sharp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class SharpData {

    public float RED = 0.0f;
    public float GREEN = 25.0f;
    public float BLUE = 200.0f;
    public float ALPHA = 0.5f;
    public float ROTATE = 0.0f;

    protected ShortBuffer mIdxBuffer = null;
    protected FloatBuffer mVtxBuffer = null;
    protected final short[] INDICES_ARRAR = { 0, 1, 2 };
    
    protected FloatBuffer mColorBuffer = null;

    //supported single sharps
    protected static final int TRAINGLE_SHARP = 0;
    protected static final int QUATER_SHARP = 1;

    public void updateVertexBuffer(float[] vtxBuf) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vtxBuf.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mVtxBuffer = vbb.asFloatBuffer();

        ByteBuffer ibb = ByteBuffer.allocateDirect(INDICES_ARRAR.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        mIdxBuffer = ibb.asShortBuffer();

        mVtxBuffer.put(vtxBuf);
        mIdxBuffer.put(INDICES_ARRAR);

        mVtxBuffer.position(0);
        mIdxBuffer.position(0);
    }

    public void updateColorBuffer(float[] colorBuffer) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(colorBuffer.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mColorBuffer = vbb.asFloatBuffer();
        mColorBuffer.put(colorBuffer);
        mColorBuffer.position(0);
    }

}
