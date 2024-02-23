import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class calculadoratest {
    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();
    }

    @Test
    public void testSuma() {
        performClick(R.id.button1);
        performClick(R.id.button2);
        performClick(R.id.buttonsuma);
        performClick(R.id.button3);
        performClick(R.id.button4);
        performClick(R.id.buttonigual);
        assertPantalla("46");
    }

    @Test
    public void testResta() {
        performClick(R.id.button9);
        performClick(R.id.button5);
        performClick(R.id.buttonresta);
        performClick(R.id.button2);
        performClick(R.id.button6);
        performClick(R.id.buttonigual);
        assertPantalla("93");
    }

    @Test
    public void testMultiplicacion() {
        performClick(R.id.button8);
        performClick(R.id.buttonmulti);
        performClick(R.id.button3);
        performClick(R.id.buttonigual);
        assertPantalla("24");
    }

    @Test
    public void testDivision() {
        performClick(R.id.button7);
        performClick(R.id.button5);
        performClick(R.id.buttondivi);
        performClick(R.id.button5);
        performClick(R.id.buttonigual);
        assertPantalla("15");
    }

    @Test
    public void testDivisionPorCero() {
        performClick(R.id.button4);
        performClick(R.id.buttondivi);
        performClick(R.id.button0);
        performClick(R.id.buttonigual);
        assertPantalla("Infinity");
    }

    @Test
    public void testReset() {
        performClick(R.id.button1);
        performClick(R.id.button2);
        performClick(R.id.button3);
        performClick(R.id.button4);
        performClick(R.id.buttonreset);
        assertPantalla("0");
    }

    private void performClick(int id) {
        Button button = activity.findViewById(id);
        button.performClick();
    }

    private void assertPantalla(String expected) {
        TextView pantalla = activity.findViewById(R.id.tvResultado);
        assertEquals(expected, pantalla.getText().toString());
    }
}





