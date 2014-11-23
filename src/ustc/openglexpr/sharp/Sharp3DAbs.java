package ustc.openglexpr.sharp;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

public abstract class Sharp3DAbs extends SharpData implements ColorAndRotateChanged {

    @Override
    public void onChangedBegin(GL10 gl) {
        gl.glLoadIdentity();
        gl.glRotatef(ROTATE, 0.0f, 1.0f, 0.0f);
    }
    @Override
    public void onChangedEnd(GL10 gl) {
        gl.glLoadIdentity();
    }
    protected int NR_FACE = 1;
    protected List<SharpAbs> mSharps = null;

    public void addVertexBuffer(float[] vtxBuf, int sharpType) {
        if (mSharps == null) mSharps = new ArrayList<SharpAbs>();
        SharpAbs tramp;
        switch (sharpType) {
        case TRAINGLE_SHARP:
            tramp = new TraingleSharp(vtxBuf);
            mSharps.add(tramp);
            break;
        case QUATER_SHARP:
            tramp = new QuaterSharp(vtxBuf);
            mSharps.add(tramp);
            break;
        }
    }

    public void addVertexBuffer(SharpAbs sharp) {
        if (mSharps == null) mSharps = new ArrayList<SharpAbs>();
        mSharps.add(sharp);
    }
    public abstract void draw(GL10 gl);
}
