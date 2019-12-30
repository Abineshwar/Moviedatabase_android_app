package com.example.rabin.hw03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddMovieActivity extends AppCompatActivity {

    EditText name1, et_desc1, year1, imdb1;
    Spinner spinner;
    TextView seekbarvalue, tv_desc;
    Button addmovie;
    SeekBar seekbar;
    String sname, sdesc, syear, simdb, svalue, sgenre;
    Movie result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        final Movie obj1 = new Movie();


        name1 = (EditText) findViewById(R.id.et_name1);
        et_desc1 = (EditText) findViewById(R.id.et_description);
        year1 = (EditText) findViewById(R.id.et_year);
        imdb1 = (EditText) findViewById(R.id.et_imdb);
        seekbarvalue = (TextView) findViewById(R.id.tv_seekbarvalue);
        tv_desc = (TextView) findViewById(R.id.tv_description1);
        addmovie = (Button) findViewById(R.id.b_addmovie);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        spinner = (Spinner) findViewById(R.id.spinner1);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        setTitle("Add a Movie");
        seekbarvalue.setText(String.valueOf(1));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sgenre = adapterView.getItemAtPosition(i).toString();
                obj1.setSgenre(sgenre);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                i = seekbar.getProgress();
                seekbarvalue.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        addmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sname = name1.getText().toString();
                sdesc = et_desc1.getText().toString();
                syear = year1.getText().toString();
                simdb = imdb1.getText().toString();
                svalue = seekbarvalue.getText().toString();
                if (sname.equals("") || sdesc.equals("") || syear.equals("") || simdb.equals("") || svalue.equals("")) {
                    Toast.makeText(AddMovieActivity.this, "Enter a valid input", Toast.LENGTH_SHORT).show();
                } else {
                    obj1.setSname(sname);
                    obj1.setSdesc(sdesc);
                    obj1.setSyear(syear);
                    obj1.setSimdb(simdb);
                    obj1.setSvalue(svalue);
                    obj1.setSgenre(sgenre);
                    Intent j = new Intent(AddMovieActivity.this, MainActivity.class);
                    j.putExtra("ADD", "ADDVALUE");
                    j.putExtra("Movieobj", obj1);
                    setResult(AddMovieActivity.RESULT_OK, j);
                    finish();
                }
            }

        });
    }
}
