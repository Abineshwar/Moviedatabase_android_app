
package com.example.rabin.hw03;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add, edit, delete, year, rating;
    int REQ_CODE, CALL_CODE;
    Movie result;
    String[] movieNames;
    ArrayList<Movie> movieList = new ArrayList<Movie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Favourite Movies");
        add = (Button) findViewById(R.id.b_add);
        edit = (Button) findViewById(R.id.b_edit);
        delete = (Button) findViewById(R.id.b_delete);
        year = (Button) findViewById(R.id.b_year);
        rating = (Button) findViewById(R.id.b_rating);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddMovieActivity.class);
                i.putExtra("Feature", "Add");
                startActivityForResult(i, REQ_CODE);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                movieNames = new String[movieList.size()];
                for (int i = 0; i < movieList.size(); i++) {
                    movieNames[i] = movieList.get(i).getSname();
                }

                builder.setTitle("Pick a Movie").setItems(movieNames, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent2 = new Intent(MainActivity.this, EditMovieActivity.class);
                        intent2.putExtra("Movieobj", movieList.get(i));
                        intent2.putExtra("Index", i);
                        startActivityForResult(intent2, CALL_CODE);
                    }

                });
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final String[] movieNames = new String[movieList.size()];
                int[] index = new int[movieList.size()];
                for (int i = 0; i < movieList.size(); i++) {
                    movieNames[i] = movieList.get(i).getSname();
                    builder.setTitle("Pick a Movie").setItems(movieNames, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            movieList.remove(i);
                            Toast.makeText(MainActivity.this, "Movie Deleted:"+movieNames[i],Toast.LENGTH_SHORT).show();

                        }

                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });

        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(MainActivity.this, MoviesbyYear.class);
                y.putExtra("MovieList", movieList);
                startActivity(y);


            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainActivity.this, MoviesbyRating.class);
                z.putExtra("MovieList", movieList);
                startActivity(z);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ_CODE) {
            if (resultCode == AddMovieActivity.RESULT_OK) {
                Movie result = (Movie) data.getSerializableExtra("Movieobj");
                movieList.add(result);
            }
            if (resultCode == 201) {
                result = (Movie) data.getSerializableExtra("Movieobj");
                int index = (Integer) data.getSerializableExtra("Index");
                movieList.remove(index);
                movieList.add(result);
            }
        }
    }
}

