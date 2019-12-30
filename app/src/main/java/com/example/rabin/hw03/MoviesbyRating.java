package com.example.rabin.hw03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoviesbyRating extends AppCompatActivity {

    TextView name3, tv_desc3, genre3, rating3, year3, imdb3;
    Button finish;
    int i = 0;

    ImageView first, last, previous, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviesby_rating);
        setTitle("Movies By Rating");

        final ArrayList<Movie> list2 = (ArrayList<Movie>) getIntent().getSerializableExtra("MovieList");
        Collections.sort(list2, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie, Movie t1) {
                //return t1.getSvalue().compareToIgnoreCase(movie.getSvalue());
                return Integer.parseInt(t1.getSvalue()) - Integer.parseInt(movie.getSvalue());
            }
        });
        name3 = (TextView) findViewById(R.id.tv_name3);
        tv_desc3 = (TextView) findViewById(R.id.tv_desc3);
        genre3 = (TextView) findViewById(R.id.tv_genre3);
        rating3 = (TextView) findViewById(R.id.tv_rating3);
        year3 = (TextView) findViewById(R.id.tv_year3);
        imdb3 = (TextView) findViewById(R.id.tv_imdb3);
        finish = (Button) findViewById(R.id.b_finish);
        next = (ImageView) findViewById(R.id.iv_next);
        previous = (ImageView) findViewById(R.id.iv_previous);
        first = (ImageView) findViewById(R.id.iv_first);
        last = (ImageView) findViewById(R.id.iv_last);
        Movie obj = list2.get(i);
        name3.setText("Title: " + "   " + obj.getSname());
        tv_desc3.setText("Description: " + "   " + obj.getSdesc());
        rating3.setText("Rating: " + "   " + obj.getSvalue());
        year3.setText("Year: " + "   " + obj.getSyear());
        imdb3.setText("IMDB: " + "   " + obj.getSimdb());
        genre3.setText("Genre: " + "   " + obj.getSgenre());


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name3 = (TextView) findViewById(R.id.tv_name3);
                tv_desc3 = (TextView) findViewById(R.id.tv_desc3);
                genre3 = (TextView) findViewById(R.id.tv_genre3);
                rating3 = (TextView) findViewById(R.id.tv_rating3);
                year3 = (TextView) findViewById(R.id.tv_year3);
                imdb3 = (TextView) findViewById(R.id.tv_imdb3);
                finish = (Button) findViewById(R.id.b_finish);
                next = (ImageView) findViewById(R.id.iv_next);
                previous = (ImageView) findViewById(R.id.iv_previous);
                first = (ImageView) findViewById(R.id.iv_first);
                last = (ImageView) findViewById(R.id.iv_last);
                if (i < list2.size() - 1 ) {
                    i = i + 1;
                    Movie obj = list2.get(i);
                    name3.setText("Title: " + "   " + obj.getSname());
                    tv_desc3.setText("Description: " + "   " + obj.getSdesc());
                    rating3.setText("Rating: " + "   " + obj.getSvalue());
                    year3.setText("Year: " + "   " + obj.getSyear());
                    imdb3.setText("IMDB: " + "   " + obj.getSimdb());
                    genre3.setText("Genre: " + "   " + obj.getSgenre());
                } else {
                    Toast.makeText(MoviesbyRating.this, "End", Toast.LENGTH_SHORT).show();
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    name3 = (TextView) findViewById(R.id.tv_name3);
                    tv_desc3 = (TextView) findViewById(R.id.tv_desc3);
                    genre3 = (TextView) findViewById(R.id.tv_genre3);
                    rating3 = (TextView) findViewById(R.id.tv_rating3);
                    year3 = (TextView) findViewById(R.id.tv_year3);
                    imdb3 = (TextView) findViewById(R.id.tv_imdb3);
                    finish = (Button) findViewById(R.id.b_finish);
                    next = (ImageView) findViewById(R.id.iv_next);
                    previous = (ImageView) findViewById(R.id.iv_previous);
                    first = (ImageView) findViewById(R.id.iv_first);
                    last = (ImageView) findViewById(R.id.iv_last);
                    if (i > 0) {
                        i = i - 1;
                        Movie obj = list2.get(i);
                        name3.setText("Title: " + "   " + obj.getSname());
                        tv_desc3.setText("Description: " + "   " + obj.getSdesc());
                        rating3.setText("Rating: " + "   " + obj.getSvalue());
                        year3.setText("Year: " + "   " + obj.getSyear());
                        imdb3.setText("IMDB: " + "   " + obj.getSimdb());
                        genre3.setText("Genre: " + "   " + obj.getSgenre());
                    } else {
                        Toast.makeText(MoviesbyRating.this, "Start", Toast.LENGTH_SHORT).show();
                    }
                }

        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name3 = (TextView) findViewById(R.id.tv_name3);
                tv_desc3 = (TextView) findViewById(R.id.tv_desc3);
                genre3 = (TextView) findViewById(R.id.tv_genre3);
                rating3 = (TextView) findViewById(R.id.tv_rating3);
                year3 = (TextView) findViewById(R.id.tv_year3);
                imdb3 = (TextView) findViewById(R.id.tv_imdb3);
                finish = (Button) findViewById(R.id.b_finish);
                next = (ImageView) findViewById(R.id.iv_next);
                previous = (ImageView) findViewById(R.id.iv_previous);
                first = (ImageView) findViewById(R.id.iv_first);
                last = (ImageView) findViewById(R.id.iv_last);
                i = 0;
                Movie obj = list2.get(i);
                name3.setText("Title: " + "   " + obj.getSname());
                tv_desc3.setText("Description: " + "   " + obj.getSdesc());
                rating3.setText("Rating: " + "   " + obj.getSvalue());
                year3.setText("Year: " + "   " + obj.getSyear());
                imdb3.setText("IMDB: " + "   " + obj.getSimdb());
                genre3.setText("Genre: " + "   " + obj.getSgenre());
            }


        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name3 = (TextView) findViewById(R.id.tv_name3);
                tv_desc3 = (TextView) findViewById(R.id.tv_desc3);
                genre3 = (TextView) findViewById(R.id.tv_genre3);
                rating3 = (TextView) findViewById(R.id.tv_rating3);
                year3 = (TextView) findViewById(R.id.tv_year3);
                imdb3 = (TextView) findViewById(R.id.tv_imdb3);
                finish = (Button) findViewById(R.id.b_finish);
                next = (ImageView) findViewById(R.id.iv_next);
                previous = (ImageView) findViewById(R.id.iv_previous);
                first = (ImageView) findViewById(R.id.iv_first);
                last = (ImageView) findViewById(R.id.iv_last);
                i = list2.size() - 1;
                Movie obj = list2.get(i);
                name3.setText("Title: " + "   " + obj.getSname());
                tv_desc3.setText("Description: " + "   " + obj.getSdesc());
                rating3.setText("Rating: " + "   " + obj.getSvalue());
                year3.setText("Year: " + "   " + obj.getSyear());
                imdb3.setText("IMDB: " + "   " + obj.getSimdb());
                genre3.setText("Genre: " + "   " + obj.getSgenre());
            }


        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MoviesbyRating.this, MainActivity.class);
                finish();
            }
        });
    }
}
