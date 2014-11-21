package ustc.openglexpr;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import ustc.openglexpr.sharp.DataPool;
import ustc.openglexpr.sharp.QuaterSharp;
import ustc.openglexpr.sharp.TraingleSharp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class DrawSurfaceView extends GLSurfaceView {
    private static final String TAG = "DrawSurfaceView";
    private Renderer mRender = null;

    public DrawSurfaceView(Context context) {
        super(context);
        init();
    }

    public DrawSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "touch glsurface action " + event.getAction());
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mRender.increaseRotate(10.0f);
            break;
        default:
            break;
        }
        return super.onTouchEvent(event);
    }

    private void init() {
        mRender = new Renderer();
        setRenderer(mRender);
    }

    private class Renderer implements GLSurfaceView.Renderer {

        private TraingleSharp mOneTraingle = null;
        private TraingleSharp mTwoTraingle = null;
        private QuaterSharp mQuater = null;

        @Override
        public void onDrawFrame(GL10 gl) {
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            gl.glLoadIdentity();
            gl.glTranslatef(0.0f, 0.5f, 0.0f);
            mOneTraingle.draw(gl);

            gl.glLoadIdentity();
            gl.glTranslatef(0.0f, 0.5f, 0.0f);
            mTwoTraingle.draw(gl);

            gl.glLoadIdentity();
            gl.glTranslatef(0.0f, -1.5f, 0.0f);
            mQuater.draw(gl);

            gl.glLoadIdentity();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            gl.glViewport(0, 0, width, height);
        }

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            initSharps();
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glShadeModel(GL10.GL_SMOOTH);
            gl.glClearColor(DataPool.BK_RED, DataPool.BK_GREEN,
                    DataPool.BK_BLUE, DataPool.BK_ALPHA);
            gl.glClearDepthf(1.0f);
            gl.glEnable(GL10.GL_DEPTH_TEST);
            gl.glDepthFunc(GL10.GL_LEQUAL);
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        }

        private void initSharps() {
            mOneTraingle = new TraingleSharp(DataPool.ONE_TRAINGLE_COORDS);
            mOneTraingle.BLUE = 0.7f;
            mTwoTraingle = new TraingleSharp(DataPool.TWO_TRAINGLE_COORDS);
            mTwoTraingle.RED = 0.7f;
            mQuater = new QuaterSharp(DataPool.QUARTER_COORDS);
        }

        public void increaseRotate(float rotate) {
            mOneTraingle.ROTATE += rotate;
            mTwoTraingle.ROTATE += rotate;
            mQuater.ROTATE += rotate;
        }
    }

}
