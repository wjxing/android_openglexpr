package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public abstract class SharpAbs extends SharpData implements ColorAndRotateChanged {

    protected int NR_VERTICES = 1;

    public SharpAbs() {
    }

    @Override
    public void onChangedBegin(GL10 gl) {
        if (mColorBuffer == null) {
            gl.glColor4f(RED, GREEN, BLUE, ALPHA);
        } else {
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            mColorBuffer.position(0);
            gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);
        }
        gl.glLoadIdentity();
        gl.glRotatef(ROTATE, 0.0f, 1.0f, 0.0f);
    }

    @Override
    public void onChangedEnd(GL10 gl) {
        if (mColorBuffer != null)
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glLoadIdentity();
    }
    

    public abstract void draw(GL10 gl);

}
