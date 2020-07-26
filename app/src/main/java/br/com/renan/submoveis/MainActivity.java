package br.com.renan.submoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edAtivo, edLucroLiquido, edPatrimonioLiquido, edNumeroAcoes, edPrecoAcoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edAtivo = findViewById(R.id.edAtivo);
        this.edLucroLiquido = findViewById(R.id.edLucroLiquido);
        this.edPatrimonioLiquido = findViewById(R.id.edPatrimonioLiquido);
        this.edNumeroAcoes = findViewById(R.id.edNumeroAcoes);
        this.edPrecoAcoes = findViewById(R.id.edPrecoAcoes);
    }




    public void goToResultadoActivity(View view){

            try {
                String ativo = edAtivo.getText().toString();
                Double lucroLiquido = Double.parseDouble(edLucroLiquido.getText().toString());
                Double patrimonioLiquido = Double.parseDouble(edPatrimonioLiquido.getText().toString());
                Double precoAtual = Double.parseDouble(edPrecoAcoes.getText().toString());
                Long numeroAcoes = Long.parseLong(edNumeroAcoes.getText().toString());

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle b = new Bundle();
                b.putString("ativo", ativo);
                b.putDouble("lucroLiquido", lucroLiquido);
                b.putDouble("patrimonioLiquido", patrimonioLiquido);
                b.putDouble("precoAcoes", precoAtual);
                b.putLong("numeroAcoes", numeroAcoes);

                intent.putExtras(b);

                startActivity(intent);

                finish();
            }catch(Exception e){
                Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_SHORT).show();
            }
    }


}
