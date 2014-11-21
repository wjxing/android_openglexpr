package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public class QuaterSharp extends SharpAbs {

    public QuaterSharp(float[] vtxBuf) {
        NR_VERTICES = 4;
        int point = NR_VERTICES * NR_POINTS;
        int size = vtxBuf.length;
        NR_SHARPS = size / point;
        updateVertexBuffer(vtxBuf);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glColor4f(RED, GREEN, BLUE, ALPHA);
        gl.glRotatef(ROTATE, 0.0f, 1.0f, 0.0f);

        for (int i = 0; i < getSharpNum(); i++) {
            mIdxBuffer.position(0);
            mVtxBuffer.position(i * NR_VERTICES * NR_POINTS);
            //gl.glVertexPointer(NR_VERTICES, GL10.GL_FLOAT, 0, mVtxBuffer);
            gl.glVertexPointer(NR_POINTS, GL10.GL_FLOAT, 0, mVtxBuffer);
            /*gl.glDrawElements(GL10.GL_TRIANGLES, NR_VERTICES,
                    GL10.GL_UNSIGNED_SHORT, mIdxBuffer);*/
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, NR_VERTICES);
        }
    }

}
