package ustc.openglexpr.sharp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class TraingleSharp extends SharpAbs {

    private FloatBuffer mSmoothColor = null;

    public TraingleSharp(float[] vtxBuf) {
        NR_VERTICES = 3;
        int point = NR_VERTICES * NR_POINTS;
        int size = vtxBuf.length;
        NR_SHARPS = size / point;
        updateVertexBuffer(vtxBuf);
    }

    @Override
    public void draw(GL10 gl) {
        //gl.glColor4f(RED, GREEN, BLUE, ALPHA);
        float[] smooth = {
                RED, 0.0f, 0.0f, ALPHA,
                0.0f, GREEN, 0.0f, ALPHA,
                0.0f, 0.0f, BLUE, ALPHA
        };
        ByteBuffer vbb = ByteBuffer.allocateDirect(NR_VERTICES * 4 * 4);
        vbb.order(ByteOrder.nativeOrder());
        mSmoothColor = vbb.asFloatBuffer();
        mSmoothColor.put(smooth);
        mSmoothColor.position(0);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mSmoothColor);
        gl.glRotatef(ROTATE, 1.0f, 0.0f, 0.0f);

        for (int i = 0; i < getSharpNum(); i++) {
            mIdxBuffer.position(0);
            mVtxBuffer.position(i * NR_VERTICES * NR_POINTS);
            gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, mVtxBuffer);
            /*gl.glDrawElements(GL10.GL_TRIANGLES, NR_VERTICES,
                    GL10.GL_UNSIGNED_SHORT, mIdxBuffer);*/
            gl.glDrawArrays(GL10.GL_TRIANGLES, 0, NR_VERTICES);
        }
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }

}
