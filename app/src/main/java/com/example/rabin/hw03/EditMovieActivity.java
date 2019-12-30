package com.example.rabin.hw03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditMovieActivity extends AppCompatActivity {

    EditText name1, et_desc1, year1, imdb1;
    Spinner spinner;
    TextView seekbarvalue, tv_desc;
    Button save;
    SeekBar seekbar;
    String sname, sdesc, syear, simdb, svalue;
    int Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        final Movie obj1 = (Movie) getIntent().getSerializableExtra("Movieobj");
        Index = (Integer) getIntent().getSerializableExtra("Index");


        name1 = (EditText) findViewById(R.id.et_name2);
        et_desc1 = (EditText) findViewById(R.id.et_description2);
        year1 = (EditText) findViewById(R.id.et_year2);
        imdb1 = (EditText) findViewById(R.id.et_imdb2);
        seekbarvalue = (TextView) findViewById(R.id.tv_seekbarvalue2);
        tv_desc = (TextView) findViewById(R.id.tv_description2);
        save = (Button) findViewById(R.id.b_save);
        seekbar = (SeekBar) findViewById(R.id.seekbar2);
        spinner = (Spinner) findViewById(R.id.spinner2);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

            setTitle("Edit a Movie");
            name1.setText(obj1.getSname());
            et_desc1.setText(obj1.getSdesc());
            seekbarvalue.setText(obj1.getSvalue());
            year1.setText(obj1.getSyear());
            imdb1.setText(obj1.getSimdb());
            spinner.setSelection(adapter.getPosition(obj1.getSgenre()));
            seekbar.setProgress(Integer.parseInt(obj1.getSvalue()));
            save.setText("Save Changes");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                obj1.setSgenre(text);
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sname = name1.getText().toString();
                sdesc = et_desc1.getText().toString();
                syear = year1.getText().toString();
                simdb = imdb1.getText().toString();
                svalue = seekbarvalue.getText().toString();
                if (sname.equals("") || sdesc.equals("") || syear.equals("") || simdb.equals("") || svalue.equals("")) {
                    Toast.makeText(EditMovieActivity.this, "Enter a valid input", Toast.LENGTH_SHORT).show();
                } else {
                    obj1.setSname(sname);
                    obj1.setSdesc(sdesc);
                    obj1.setSyear(syear);
                    obj1.setSimdb(simdb);
                    obj1.setSvalue(svalue);
                    Intent u = new Intent(EditMovieActivity.this, MainActivity.class);
                    u.putExtra("EDIT", "EDITVALUE");
                    u.putExtra("Movieobj", obj1);
                    u.putExtra("Index", Index);
                    setResult(201, u);
                    finish();
                }
            }

        });
    }
}
