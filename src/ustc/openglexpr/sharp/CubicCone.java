package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public class CubicCone extends Sharp3DAbs {
    private TraingleSharp mTraingle1 = null;
    private TraingleSharp mTraingle2 = null;
    private TraingleSharp mTraingle3 = null;
    private TraingleSharp mTraingle4 = null;
    public CubicCone() {
        mTraingle1 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_1);
        mTraingle1.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_1);
        /*mTraingle1.RED = 1.0f;
        mTraingle1.GREEN = 0.0f;
        mTraingle1.BLUE = 0.0f;*/
        mTraingle2 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_2);
        mTraingle2.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_2);
        /*mTraingle2.RED = 0.0f;
        mTraingle2.GREEN = 1.0f;
        mTraingle2.BLUE = 0.0f;*/
        mTraingle3 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_3);
        mTraingle3.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_3);
        /*mTraingle3.RED = 0.0f;
        mTraingle3.GREEN = 0.0f;
        mTraingle3.BLUE = 1.0f;*/
        mTraingle4 = new TraingleSharp(DataPool.CUBIC_CONE_COORDS_4);
        mTraingle4.updateColorBuffer(DataPool.CUBIC_CONE_COLOR_4);
    }

    @Override
    public void draw(GL10 gl) {
        onChangedBegin(gl);
        mTraingle1.draw(gl);
        mTraingle2.draw(gl);
        mTraingle3.draw(gl);
        mTraingle4.draw(gl);
        onChangedEnd(gl);
    }

    public void increaseRotate(float rotate) {
        mTraingle1.ROTATE += rotate;
        mTraingle4.ROTATE += rotate;
        mTraingle3.ROTATE += rotate;
        mTraingle2.ROTATE += rotate;
    }

}
