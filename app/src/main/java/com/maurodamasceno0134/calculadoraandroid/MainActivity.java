package com.maurodamasceno0134.calculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnCE, btnSomar, btnSubtrair, btnMultiplicar, btnDividir, btnIgual;
    private double valor1, valor2, resultado;
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnCE=findViewById(R.id.btnCE);

        btnSomar=findViewById(R.id.btnSomar);
        btnSubtrair=findViewById(R.id.btnSubtrair);
        btnMultiplicar=findViewById(R.id.btnMultiplicar);
        btnDividir=findViewById(R.id.btnDividir);

        btnIgual=findViewById(R.id.btnIgual);

        btn0.setOnClickListener(cliqueBotaoNumerico);
        btn1.setOnClickListener(cliqueBotaoNumerico);
        btn2.setOnClickListener(cliqueBotaoNumerico);
        btn3.setOnClickListener(cliqueBotaoNumerico);
        btn4.setOnClickListener(cliqueBotaoNumerico);
        btn5.setOnClickListener(cliqueBotaoNumerico);
        btn6.setOnClickListener(cliqueBotaoNumerico);
        btn7.setOnClickListener(cliqueBotaoNumerico);
        btn8.setOnClickListener(cliqueBotaoNumerico);
        btn9.setOnClickListener(cliqueBotaoNumerico);

        btnSomar.setOnClickListener(cliqueBotaoOperacao);
        btnSubtrair.setOnClickListener(cliqueBotaoOperacao);
        btnMultiplicar.setOnClickListener(cliqueBotaoOperacao);
        btnDividir.setOnClickListener(cliqueBotaoOperacao);

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                valor2 = Double.parseDouble(txtDisplay.getText().toString());
                switch (operacao) {
                    case "+":
                        resultado = valor1 + valor2;
                        break;
                    case "-":
                        resultado = valor1 - valor2;
                        break;
                    case "*":
                        resultado = valor1 * valor2;
                        break;
                    case "/":
                        resultado = valor1 / valor2;
                        break;
                }
                txtDisplay.setText(Double.toString(resultado));
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operacao = "";
                txtDisplay.setText("");
            }
        });
    }

    View.OnClickListener cliqueBotaoNumerico = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado = (Button)v;
            txtDisplay.setText(txtDisplay.getText().toString() + botaoPressionado.getText());
        }
    };

    View.OnClickListener cliqueBotaoOperacao = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado = (Button)v;
            operacao = botaoPressionado.getText().toString();
            valor1 = Double.parseDouble(txtDisplay.getText().toString());
            txtDisplay.setText("");
        }
    };
}
