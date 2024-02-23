package com.example.calculadoraa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvRes;
    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar TextView
        tvRes = findViewById(R.id.tvResultado);
    }

    public void calcular(View view) {
        Button boton = (Button) view;
        String textoBoton = boton.getText().toString();

        switch (textoBoton) {
            case "+":
            case "-":
            case "*":
            case "/":
                operador = textoBoton;
                num1 = obtenerNumeroEnPantalla();
                limpiarPantalla();
                break;
            case "=":
                num2 = obtenerNumeroEnPantalla();
                double resultado = calcularResultado();
                mostrarResultado(resultado);
                break;
            case "RESET":
                reiniciarCalculadora();
                break;
            default:
                agregarTextoALaPantalla(textoBoton);
                break;
        }
    }

    private double obtenerNumeroEnPantalla() {
        return Double.parseDouble(tvRes.getText().toString());
    }

    private void limpiarPantalla() {
        tvRes.setText("0");
    }

    private void mostrarResultado(double resultado) {
        tvRes.setText(String.valueOf(resultado));
    }

    private double calcularResultado() {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.POSITIVE_INFINITY;
                }
            default:
                return 0;
        }
    }

    private void reiniciarCalculadora() {
        limpiarPantalla();
        num1 = 0;
        num2 = 0;
        operador = "";
    }

    private void agregarTextoALaPantalla(String texto) {
        String textoPantalla = tvRes.getText().toString();
        if (textoPantalla.equals("0")) {
            tvRes.setText(texto);
        } else {
            tvRes.setText(textoPantalla + texto);
        }
    }
}
