package ustc.openglexpr.sharp;

import javax.microedition.khronos.opengles.GL10;

public class Cubic extends Sharp3DAbs {
    private QuaterSharp mQuater1 = null;
    private QuaterSharp mQuater2 = null;
    private QuaterSharp mQuater3 = null;
    private QuaterSharp mQuater4 = null;
    private QuaterSharp mQuater5 = null;
    private QuaterSharp mQuater6 = null;
    public Cubic() {
        mQuater1 = new QuaterSharp(DataPool.CUBIC_COORDS_1);
        mQuater1.updateColorBuffer(DataPool.CUBIC_COLOR_1);
        mQuater2 = new QuaterSharp(DataPool.CUBIC_COORDS_2);
        mQuater2.updateColorBuffer(DataPool.CUBIC_COLOR_2);
        mQuater3 = new QuaterSharp(DataPool.CUBIC_COORDS_3);
        mQuater3.updateColorBuffer(DataPool.CUBIC_COLOR_3);
        mQuater4 = new QuaterSharp(DataPool.CUBIC_COORDS_4);
        mQuater4.updateColorBuffer(DataPool.CUBIC_COLOR_4);
        mQuater5 = new QuaterSharp(DataPool.CUBIC_COORDS_5);
        mQuater5.updateColorBuffer(DataPool.CUBIC_COLOR_5);
        mQuater6 = new QuaterSharp(DataPool.CUBIC_COORDS_6);
        mQuater6.updateColorBuffer(DataPool.CUBIC_COLOR_6);
    }

    @Override
    public void draw(GL10 gl) {
        onChangedBegin(gl);
        mQuater1.draw(gl);
        mQuater2.draw(gl);
        mQuater3.draw(gl);
        mQuater4.draw(gl);
        mQuater5.draw(gl);
        mQuater6.draw(gl);
        onChangedEnd(gl);
    }

    public void increaseRotate(float rotate) {
        mQuater1.ROTATE += rotate;
        mQuater2.ROTATE += rotate;
        mQuater3.ROTATE += rotate;
        mQuater4.ROTATE += rotate;
        mQuater5.ROTATE += rotate;
        mQuater6.ROTATE += rotate;
    }

}
