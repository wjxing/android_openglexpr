package ustc.openglexpr;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class OpenglExprMainActivity extends Activity {

    private DrawSurfaceView mSurface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSurface = new DrawSurfaceView(this);
        setContentView(mSurface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSurface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSurface.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opengl_expr_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        mSurface.updateSharpType(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
