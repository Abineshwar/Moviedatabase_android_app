package com.example.rabin.hw03;

import android.content.Intent;
import android.media.Image;
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


public class MoviesbyYear extends AppCompatActivity {

    TextView name2, tv_desc2, genre2, rating2, year2, imdb2;
    Button finish;
    int i = 0;

    ImageView first, last, previous, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviesby_year);
        setTitle("Movies by Year");
        final ArrayList<Movie> list = (ArrayList<Movie>) getIntent().getSerializableExtra("MovieList");
        Collections.sort(list, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie, Movie t1) {
                //return movie.getSyear().compareToIgnoreCase(t1.getSyear());
                return Integer.parseInt(movie.getSyear()) - Integer.parseInt(t1.getSyear());
            }
        });
        name2=(TextView) findViewById(R.id.tv_name2);
        tv_desc2=(TextView) findViewById(R.id.tv_desc2);
        genre2=(TextView) findViewById(R.id.tv_genre2);
        rating2=(TextView) findViewById(R.id.tv_rating2);
        year2=(TextView) findViewById(R.id.tv_year2);
        imdb2=(TextView) findViewById(R.id.tv_imdb2);
        finish=(Button) findViewById(R.id.b_finish);
        next=(ImageView) findViewById(R.id.iv_next);
        previous=(ImageView) findViewById(R.id.iv_previous);
        first=(ImageView) findViewById(R.id.iv_first);
        last=(ImageView) findViewById(R.id.iv_last);
        Movie obj = list.get(i);
        name2.setText("Title: "+"   "+obj.getSname());
        tv_desc2.setText("Description: "+"   "+obj.getSdesc());
        rating2.setText("Rating: "+"   "+obj.getSvalue());
        year2.setText("Year: "+"   "+obj.getSyear());
        imdb2.setText("IMDB: "+"   "+obj.getSimdb());
        genre2.setText("Genre: "+"   "+obj.getSgenre());


next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        name2=(TextView) findViewById(R.id.tv_name2);
        tv_desc2=(TextView) findViewById(R.id.tv_desc2);
        genre2=(TextView) findViewById(R.id.tv_genre2);
        rating2=(TextView) findViewById(R.id.tv_rating2);
        year2=(TextView) findViewById(R.id.tv_year2);
        imdb2=(TextView) findViewById(R.id.tv_imdb2);
        finish=(Button) findViewById(R.id.b_finish);
        next=(ImageView) findViewById(R.id.iv_next);
        previous=(ImageView) findViewById(R.id.iv_previous);
        first=(ImageView) findViewById(R.id.iv_first);
        last=(ImageView) findViewById(R.id.iv_last);

        if (i < list.size() - 1){
        i = i+ 1;
        Movie obj = list.get(i);
        name2.setText("Title: "+"   "+obj.getSname());
        tv_desc2.setText("Description: "+"   "+obj.getSdesc());
        rating2.setText("Rating: "+"   "+obj.getSvalue());
        year2.setText("Year: "+"   "+obj.getSyear());
        imdb2.setText("IMDB: "+"   "+obj.getSimdb());
        genre2.setText("Genre: "+"   "+obj.getSgenre()); }
        else{
            Toast.makeText(MoviesbyYear.this, "End", Toast.LENGTH_SHORT).show();
        }
    }
});

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        name2=(TextView) findViewById(R.id.tv_name2);
        tv_desc2=(TextView) findViewById(R.id.tv_desc2);
        genre2=(TextView) findViewById(R.id.tv_genre2);
        rating2=(TextView) findViewById(R.id.tv_rating2);
        year2=(TextView) findViewById(R.id.tv_year2);
        imdb2=(TextView) findViewById(R.id.tv_imdb2);
        finish=(Button) findViewById(R.id.b_finish);
        next=(ImageView) findViewById(R.id.iv_next);
        previous=(ImageView) findViewById(R.id.iv_previous);
        first=(ImageView) findViewById(R.id.iv_first);
        last=(ImageView) findViewById(R.id.iv_last);
                if (i>0){
                    i = i- 1;
                    Log.d("essential", "i"+i);
                    Movie obj = list.get(i);
                    name2.setText("Title: "+"   "+obj.getSname());
                    tv_desc2.setText("Description: "+"   "+obj.getSdesc());
                    rating2.setText("Rating: "+"   "+obj.getSvalue());
                    year2.setText("Year: "+"   "+obj.getSyear());
                    imdb2.setText("IMDB: "+"   "+obj.getSimdb());
                    genre2.setText("Genre: "+"   "+obj.getSgenre()); }
                else{
                    Toast.makeText(MoviesbyYear.this, "Start", Toast.LENGTH_SHORT).show();
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        name2=(TextView) findViewById(R.id.tv_name2);
        tv_desc2=(TextView) findViewById(R.id.tv_desc2);
        genre2=(TextView) findViewById(R.id.tv_genre2);
        rating2=(TextView) findViewById(R.id.tv_rating2);
        year2=(TextView) findViewById(R.id.tv_year2);
        imdb2=(TextView) findViewById(R.id.tv_imdb2);
        finish=(Button) findViewById(R.id.b_finish);
        next=(ImageView) findViewById(R.id.iv_next);
        previous=(ImageView) findViewById(R.id.iv_previous);
        first=(ImageView) findViewById(R.id.iv_first);
        last=(ImageView) findViewById(R.id.iv_last);
                Log.d("essential", "i"+i);
                    i = 0;
                    Movie obj = list.get(i);
                    name2.setText("Title: "+"   "+obj.getSname());
                    tv_desc2.setText("Description: "+"   "+obj.getSdesc());
                    rating2.setText("Rating: "+"   "+obj.getSvalue());
                    year2.setText("Year: "+"   "+obj.getSyear());
                    imdb2.setText("IMDB: "+"   "+obj.getSimdb());
                    genre2.setText("Genre: "+"   "+obj.getSgenre()); }


        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        name2=(TextView) findViewById(R.id.tv_name2);
        tv_desc2=(TextView) findViewById(R.id.tv_desc2);
        genre2=(TextView) findViewById(R.id.tv_genre2);
        rating2=(TextView) findViewById(R.id.tv_rating2);
        year2=(TextView) findViewById(R.id.tv_year2);
        imdb2=(TextView) findViewById(R.id.tv_imdb2);
        finish=(Button) findViewById(R.id.b_finish);
        next=(ImageView) findViewById(R.id.iv_next);
        previous=(ImageView) findViewById(R.id.iv_previous);
        first=(ImageView) findViewById(R.id.iv_first);
        last=(ImageView) findViewById(R.id.iv_last);
                Log.d("essential", "i"+i);
                i = list.size()-1;
                Movie obj = list.get(i);
                name2.setText("Title: "+"   "+obj.getSname());
                tv_desc2.setText("Description: "+"   "+obj.getSdesc());
                rating2.setText("Rating: "+"   "+obj.getSvalue());
                year2.setText("Year: "+"   "+obj.getSyear());
                imdb2.setText("IMDB: "+"   "+obj.getSimdb());
                genre2.setText("Genre: "+"   "+obj.getSgenre()); }


        });



finish.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent k = new Intent(MoviesbyYear.this, MainActivity.class);
        finish();
    }
});
    }
}
