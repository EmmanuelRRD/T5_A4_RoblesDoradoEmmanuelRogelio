package com.example.t5_a4_roblesdoradoemmanuelrogelio;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     EditText box_inicial,box_binari,box_octal,box_hexadecimal;
     RadioButton btn_decimal,btn_binari,btn_octal,btn_hexa;

     //CheckBox check_binari,check_octal,check_hexa;

    String numeroDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        box_inicial = findViewById(R.id.box_num);
        box_binari = findViewById(R.id.box_numBinari);
        box_octal = findViewById(R.id.box_numOctal);
        box_hexadecimal = findViewById(R.id.box_numHexadecimal);

        btn_decimal = findViewById(R.id.btn_decimal);
        btn_binari = findViewById(R.id.btn_binario);
        btn_octal = findViewById(R.id.btn_octal);
        btn_hexa = findViewById(R.id.btn_hexadecimal);

    }

    public void operations(View v) {
        try {
            boolean isChecked = ((CheckBox) v).isChecked();
            String numeroInicial = box_inicial.getText().toString().trim();

            if (numeroInicial.isEmpty()) {
                Toast.makeText(this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                return;
            }

            int numeroDecimal;
            if (btn_decimal.isChecked()) {
                numeroDecimal = Integer.parseInt(numeroInicial);
            } else if (btn_binari.isChecked()) {
                numeroDecimal = Integer.parseInt(numeroInicial, 2);
            } else if (btn_octal.isChecked()) {
                numeroDecimal = Integer.parseInt(numeroInicial, 8);
            } else if (btn_hexa.isChecked()) {
                numeroDecimal = Integer.parseInt(numeroInicial, 16);
            } else {
                Toast.makeText(this, "Seleccione un formato de entrada", Toast.LENGTH_SHORT).show();
                return;
            }

            if (v.getId() == R.id.check_binari) {
                if (isChecked) {
                    box_binari.setText(Integer.toBinaryString(numeroDecimal));
                } else {
                    box_binari.setText("");
                }
            } else if (v.getId() == R.id.check_octal) {
                if (isChecked) {
                    box_octal.setText(Integer.toOctalString(numeroDecimal));
                } else {
                    box_octal.setText("");
                }
            } else if (v.getId() == R.id.check_hexa) {
                if (isChecked) {
                    box_hexadecimal.setText(Integer.toHexString(numeroDecimal));
                } else {
                    box_hexadecimal.setText("");
                }
            } else {
                Toast.makeText(this, "Elemento no reconocido", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        } catch (ClassCastException e) {
            Toast.makeText(this, "Error en la conversión de tipo de vista", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Ocurrió un error inesperado", Toast.LENGTH_SHORT).show();
        }
    }








}