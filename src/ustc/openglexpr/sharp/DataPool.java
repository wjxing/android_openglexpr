package ustc.openglexpr.sharp;

public final class DataPool {

    private DataPool() {
    }

    public static final float BK_RED = 0.3f;
    public static final float BK_GREEN = 0.3f;
    public static final float BK_BLUE = 0.3f;
    public static final float BK_ALPHA = 0.0f;

    // NR_VERTICES * NR_POINTS * NR_TRAINGLES
    public static final float[] ONE_TRAINGLE_COORDS = {
            //1st traingle
        0.0f, -0.5f, 0f,    // (x1, y1, z1)
        0.5f, -0.5f, 0f,    // (x2, y2, z2)
        0.25f, 0.5f, 0f     // (x3, y3, z3)
    };

    public static final float[] TWO_TRAINGLE_COORDS = {
        // 1st traingle
        -1f, -0.5f, 0f,     // (x1, y1, z1)
        -0.25f, -0.5f, 0f,  // (x2, y2, z2)
        -0.5f, 0.5f, 0f,    // (x3, y3, z3)
        // 2nd traingle
        0.25f, -0.5f, 0f,   // (x1, y1, z1)
        0.75f, -0.5f, 0f,   // (x2, y2, z2)
        0.5f, 0.5f, 0f      // (x3, y3, z3)
    };

    public static final float[] QUARTER_COORDS = {
        -0.9f, 0.9f, 0.0f,
        -0.9f, 0.75f, 0.0f,
        -0.75f, 0.9f, 0.0f,
        -0.75f, 0.25f, 0.0f
    };

}
