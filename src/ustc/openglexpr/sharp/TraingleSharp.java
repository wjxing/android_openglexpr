package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public class TraingleSharp extends SharpAbs {

    public TraingleSharp(float[] vtxBuf) {
        NR_VERTICES = 3;
        updateVertexBuffer(vtxBuf);
    }

    @Override
    public void draw(GL10 gl) {
        onChangedBegin(gl);
        mIdxBuffer.position(0);
        mVtxBuffer.position(0);
        gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, mVtxBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, NR_VERTICES,
                GL10.GL_UNSIGNED_SHORT, mIdxBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, NR_VERTICES);
        onChangedEnd(gl);
        gl.glLoadIdentity();
    }

}
