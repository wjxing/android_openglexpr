package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public class QuaterSharp extends SharpAbs {

    public QuaterSharp(float[] vtxBuf) {
        NR_VERTICES = 4;
        updateVertexBuffer(vtxBuf);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glLoadIdentity();
        onChangedBegin(gl);
        mIdxBuffer.position(0);
        mVtxBuffer.position(0);
        gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, mVtxBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, NR_VERTICES);
        onChangedEnd(gl);
        gl.glLoadIdentity();
    }

}
