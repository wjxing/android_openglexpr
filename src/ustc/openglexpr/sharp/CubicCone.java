package ustc.openglexpr.sharp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CubicCone extends Sharp3DAbs {
    private TraingleSharp mTraingle1 = null;
    private TraingleSharp mTraingle2 = null;
    private TraingleSharp mTraingle3 = null;
    private TraingleSharp mTraingle4 = null;
    private FloatBuffer _mVtxBuf = null;
    private FloatBuffer _mColorBuf = null;
    private ShortBuffer _mIdxBuffer = null;

    public CubicCone() {
        mTraingle1 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_1);
        mTraingle1.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_1);
        /*
         * mTraingle1.RED = 1.0f;
         * mTraingle1.GREEN = 0.0f;
         * mTraingle1.BLUE = 0.0f;
         */
        mTraingle2 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_2);
        mTraingle2.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_2);
        mTraingle3 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_3);
        mTraingle3.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_3);
        mTraingle4 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_4);
        mTraingle4.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_4);
        ByteBuffer vbb = ByteBuffer
                .allocateDirect(DataPool.CUBIC_CONE_COORDS.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        _mVtxBuf = vbb.asFloatBuffer();
        _mVtxBuf.put(DataPool.CUBIC_CONE_COORDS);
        _mVtxBuf.position(0);
        vbb = ByteBuffer.allocateDirect(DataPool.CUBIC_CONE_COLOR.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        _mColorBuf = vbb.asFloatBuffer();
        _mColorBuf.put(DataPool.CUBIC_CONE_COORDS);
        _mColorBuf.position(0);
        vbb = ByteBuffer
                .allocateDirect(DataPool.CUBIC_CONE_COORDS_IDX.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        _mIdxBuffer = vbb.asShortBuffer();
        _mIdxBuffer.put(DataPool.CUBIC_CONE_COORDS_IDX);
        _mIdxBuffer.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        mTraingle1.draw(gl);
        mTraingle2.draw(gl);
        mTraingle3.draw(gl);
        mTraingle4.draw(gl);
        onChangedBegin(gl);
        _mVtxBuf.position(0);
        _mColorBuf.position(0);
        _mIdxBuffer.position(0);
        gl.glTranslatef(0.0f, -0.3f, 0.0f);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, _mVtxBuf);
        gl.glColorPointer(NR_COLORS, GL10.GL_FLOAT, 0, _mColorBuf);
        gl.glDrawElements(GL10.GL_TRIANGLE_STRIP,
                _mIdxBuffer.remaining(), GL10.GL_UNSIGNED_BYTE,
                _mIdxBuffer);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        onChangedEnd(gl);
    }

    public void increaseRotate(float rotate) {
        ROTATE += rotate;
        mTraingle1.ROTATE += rotate;
        mTraingle4.ROTATE += rotate;
        mTraingle3.ROTATE += rotate;
        mTraingle2.ROTATE += rotate;
    }

}
