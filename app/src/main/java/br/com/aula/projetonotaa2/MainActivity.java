package br.com.aula.projetonotaa2;//package br.com.aula.projetonotaa2;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}


import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //setando as variaveis
    private TextView textPeso, textAltura, textIMC;
    private SeekBar seekBarPeso, seekBarAltura;
    private int peso = 0;
    private int altura = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declarando as variaveis
        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
        textIMC = findViewById(R.id.textIMC);
        seekBarPeso = findViewById(R.id.seekBarPeso);
        seekBarAltura = findViewById(R.id.seekBarAltura);
        Button buttonCalcular = findViewById(R.id.btnCalcular);

        //seekBar para o usuário selecionar o peso
        seekBarPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                peso = progress;
                textPeso.setText("Peso: " + peso + " kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //seekBar para selecionar a Altura
        seekBarAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                altura = progress;
                textAltura.setText("Altura: " + altura + " cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Botão para calcular o IMC
        buttonCalcular.setOnClickListener(v -> {
            if (altura > 0) {
                double alturaMetros = altura / 100.0;
                double imc = peso / (alturaMetros * alturaMetros);
                textIMC.setText(String.format("Seu IMC é: %.2f", imc));
            } else {
                textIMC.setText("Defina a altura para calcular o IMC");
            }
        });
    }
}
