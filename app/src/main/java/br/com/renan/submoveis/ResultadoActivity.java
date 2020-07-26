package br.com.renan.submoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView tvAtivo, tvPl, tvRoe, tvLpa, tvVpa, tvPvp;

    String ativo;
    Double patrimonioLiquido, lucroLiquido, precoAcoes;
    Long numeroAcoes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        carregarDados();

        Double lpa = lucroLiquido / numeroAcoes;
        Double pl = precoAcoes / lpa;
        Double roe = (lucroLiquido/patrimonioLiquido) * 100;
        Double vpa = patrimonioLiquido/numeroAcoes;
        Double pvp = precoAcoes / vpa;

        this.tvAtivo = findViewById(R.id.tvAtivo);
        this.tvLpa = findViewById(R.id.tvLpa);
        this.tvPl = findViewById(R.id.tvPl);
        this.tvRoe = findViewById(R.id.tvRoe);
        this.tvVpa = findViewById(R.id.tvVpa);
        this.tvPvp = findViewById(R.id.tvPvp);

        this.tvAtivo.setText(this.ativo);
        this.tvLpa.setText(String.format("LPA: %.2f", lpa));
        this.tvPl.setText(String.format("P/L: %.2f", pl));
        this.tvRoe.setText(String.format("ROE: %.2f", roe));
        this.tvVpa.setText(String.format("VPA: %.2f", vpa));
        this.tvPvp.setText(String.format("P/VP: %.2f", pvp));


    }

    public void carregarDados(){
        Bundle b = getIntent().getExtras();
        if(b != null){
            this.ativo = b.getString("ativo");
            this.lucroLiquido = b.getDouble("lucroLiquido");
            this.precoAcoes = b.getDouble("precoAcoes");
            this.patrimonioLiquido = b.getDouble("patrimonioLiquido");
            this.numeroAcoes = b.getLong("numeroAcoes");
        }
    }

}
