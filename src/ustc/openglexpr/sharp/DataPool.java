package ustc.openglexpr.sharp;

public final class DataPool {

    private DataPool() {
    }

    public static final float BK_RED = 0.3f;
    public static final float BK_GREEN = 0.3f;
    public static final float BK_BLUE = 0.3f;
    public static final float BK_ALPHA = 0.0f;

    ///////////////////////////////////////////////
    // one traingle with smooth color
    public static final float[] TRAINGLE_COLORS = {
        0.5f, 0.0f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.5f, 0.0f,
    };

    // NR_VERTICES * NR_POINTS * NR_TRAINGLES
    public static final float[] TRAINGLE_COORDS = {
        //1st traingle
        0.0f, -0.5f, 0f, // (x1, y1, z1)
        0.5f, -0.5f, 0f, // (x2, y2, z2)
        0.25f, 0.5f, 0f // (x3, y3, z3)
    };

    ///////////////////////////////////////////////
    //two traingle
    public static final float[] ONE_TRAINGLE_COORDS = {
        -1f, -0.5f, 0f,     // (x1, y1, z1)
        -0.25f, -0.5f, 0f,  // (x2, y2, z2)
        -0.5f, 0.5f, 0f,    // (x3, y3, z3)
    };

    public static final float[] TWO_TRAINGLE_COORDS = {
        0.25f, -0.5f, 0f,   // (x1, y1, z1)
        0.75f, -0.5f, 0f,   // (x2, y2, z2)
        0.5f, 0.5f, 0f      // (x3, y3, z3)
    };

    ///////////////////////////////////////////////
    //quarter
    public static final float[] QUARTER_COORDS = {
        -0.5f, -0.5f, 0.0f,
        -0.5f, 0.5f, 0.0f,
        0.5f, -0.5f, 0.0f,
        0.5f, 0.5f, 0.0f
    };

    ///////////////////////////////////////////////
    //cubic cone : method 1
    public static final float[] CUBIC_CONE_COLOR_1 = {
        0.5f, 0.0f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.5f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COORDS_1 = {
        0.0f, 0.5f, 0.0f,
        0.5f, 0.3f, 0.0f,
        -0.5f, 0.0f, 0.0f
    };
    public static final float[] CUBIC_CONE_COLOR_2 = {
        0.6f, 0.0f, 0.0f, 0.0f,
        0.6f, 0.6f, 0.0f, 0.0f,
        0.6f, 0.6f, 0.6f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COORDS_2 = {
        /*0.0f, 0.5f, 0.0f,
        0.6f, 0.25f, 0.0f,
        0.5f, 0.0f, 0.0f*/
        0.0f, 0.5f, 0.0f,
        0.0f, 0.0f, -0.5f,
        0.5f, 0.3f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COLOR_3 = {
        0.7f, 0.0f, 0.0f, 0.0f,
        0.7f, 0.7f, 0.0f, 0.0f,
        0.7f, 0.7f, 0.7f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COORDS_3 = {
        /*0.0f, 0.5f, 0.0f,
        0.6f, 0.25f, 0.0f,
        -0.5f, 0.0f, 0.0f*/
        0.0f, 0.5f, 0.0f,
        -0.5f, 0.0f, 0.0f,
        0.0f, 0.0f, -0.5f
    };
    public static final float[] CUBIC_CONE_COLOR_4 = {
        0.8f, 0.0f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.8f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COORDS_4 = {
        /*0.6f, 0.25f, 0.0f,
        -0.5f, 0.0f, 0.0f,
        0.5f, 0.0f, 0.0f*/
        0.0f, 0.0f, -0.5f,
        0.5f, 0.3f, 0.0f,
        -0.5f, 0.0f, 0.0f
    };

    ///////////////////////////////////////////////
    //cubic cone : method 2
    public static final float[] CUBIC_CONE_COLOR = {
        0.8f, 0.0f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.8f, 0.0f,
        0.3f, 0.3f, 0.3f, 0.0f,
    };
    public static final float[] CUBIC_CONE_COORDS = {
        0.0f, 0.5f, 0.0f,
        0.0f, 0.0f, 0.5f,
        -0.5f, 0.0f, 0.0f,
        0.3f, 0.3f, -0.3f
    };
    public static final short[] CUBIC_CONE_COORDS_IDX = {
        0, 1, 2,
        0, 3, 1,
        0, 2, 3,
        1, 2, 3
    };

    ///////////////////////////////////////////////
    //cubic
    public static final float[] CUBIC_COLOR_1 = {
        0.5f, 0.0f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.0f, 0.0f,
        0.5f, 0.5f, 0.5f, 0.0f
    };
    public static final float[] CUBIC_COORDS_1 = {
        -0.5f, -0.5f, 0.5f,
        -0.5f, 0.5f, 0.5f,
        0.5f, -0.5f, 0.5f,
        0.5f, 0.5f, 0.5f
    };
    public static final float[] CUBIC_COLOR_2 = {
        0.6f, 0.0f, 0.0f, 0.0f,
        0.6f, 0.6f, 0.0f, 0.0f,
        0.6f, 0.6f, 0.6f, 0.0f
    };
    public static final float[] CUBIC_COORDS_2 = {
        -0.5f, -0.4f, -0.5f,
        -0.5f, 0.6f, -0.5f,
        0.5f, -0.4f, -0.5f,
        0.5f, 0.6f, -0.5f
    };
    public static final float[] CUBIC_COLOR_3 = {
        0.7f, 0.0f, 0.0f, 0.0f,
        0.7f, 07f, 0.0f, 0.0f,
        0.7f, 0.7f, 0.7f, 0.0f
    };
    public static final float[] CUBIC_COORDS_3 = {
        -0.5f, 0.5f, 0.5f,
        -0.5f, 0.6f, -0.5f,
        0.5f, 0.5f, 0.5f,
        0.5f, 0.6f, -0.5f
    };
    public static final float[] CUBIC_COLOR_4 = {
        0.8f, 0.0f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.0f, 0.0f,
        0.8f, 0.8f, 0.8f, 0.0f
    };
    public static final float[] CUBIC_COORDS_4 = {
        -0.5f, -0.5f, 0.5f,
        -0.5f, -0.4f, -0.5f,
        0.5f, -0.5f, 0.5f,
        0.5f, -0.4f, -0.5f
    };
    public static final float[] CUBIC_COLOR_5 = {
        0.9f, 0.0f, 0.0f, 0.0f,
        0.9f, 0.9f, 0.0f, 0.0f,
        0.9f, 0.9f, 09f, 0.0f
    };
    public static final float[] CUBIC_COORDS_5 = {
        0.5f, -0.5f, 0.5f,
        0.5f, 0.5f, 0.5f,
        0.5f, -0.4f, -0.5f,
        0.5f, 0.6f, -0.5f
    };
    public static final float[] CUBIC_COLOR_6 = {
        1.0f, 0.0f, 0.0f, 0.0f,
        1.0f, 1.0f, 0.0f, 0.0f,
        1.0f, 1.0f, 1.0f, 0.0f
    };
    public static final float[] CUBIC_COORDS_6 = {
        -0.5f, -0.5f, 0.5f,
        -0.5f, 0.5f, 0.5f,
        -0.5f, -0.4f, -0.5f,
        -0.5f, 0.6f, -0.5f
    };
}
