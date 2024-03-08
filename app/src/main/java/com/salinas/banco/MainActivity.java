package com.salinas.banco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.salinas.banco.model.limiteCreditoModel;

public class MainActivity extends AppCompatActivity {

    Spinner cmbTipoTargeta;
    TextInputEditText txtValorLimite;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);
        String opcionTargeta[] = {"--TIPO DE TARGETA--", "Targeta 1", "Targeta 2", "Targeta 3", "Otro Tipo"};
        cmbTipoTargeta = findViewById(R.id.sptipoTargeta);
        txtValorLimite=findViewById(R.id.txvalorlimite);
        btnCalcular = findViewById(R.id.buttonCalcular);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.buttonSalir);

        ArrayAdapter<String> adapTipoTargeta = new ArrayAdapter<String> (
                this, android.R.layout.simple_spinner_item, opcionTargeta);

        cmbTipoTargeta.setAdapter(adapTipoTargeta);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    int noTargeta;
                    int limiteCredito;

                    noTargeta = cmbTipoTargeta.getSelectedItemPosition();
                    limiteCredito = Integer.parseInt(txtValorLimite.getText().toString());

                    if (cmbTipoTargeta.getSelectedItemPosition() == 0 ){
                        Toast.makeText(getApplicationContext(), "--Seleccione un Tipo de Targeta--", Toast.LENGTH_SHORT).show();
                    }else if(limiteCredito == 0) {
                        txtValorLimite.setError("Debe Ingresar la Cantidad");
                        txtValorLimite.requestFocus();
                    }else{

                        limiteCreditoModel obj = new limiteCreditoModel();

                        obj.setTipoTargeta(noTargeta);
                        obj.setLimiteCredito(limiteCredito);
                        Toast.makeText(getApplicationContext(), obj.calcularNuevoCredito(), Toast.LENGTH_SHORT).show();
                    }



                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"No puede dejar espacios es blanco",Toast.LENGTH_SHORT).show();
                }

                //Listener para salir de la app
                btnSalir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });


                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cmbTipoTargeta.setSelection(0);
                        txtValorLimite.setText(null);
                    }
                });

            }
        });
    }
}