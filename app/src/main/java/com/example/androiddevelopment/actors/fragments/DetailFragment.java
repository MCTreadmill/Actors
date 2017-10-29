package com.example.androiddevelopment.actors.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androiddevelopment.actors.R;
import com.example.androiddevelopment.actors.models.Film;
import com.example.androiddevelopment.actors.providers.ActorProvider;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class DetailFragment extends Fragment {

    private int position = 0;
    private static int NOTIFICATION_ID = 1;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage = getView().findViewById(R.id.iv_actor_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(ActorProvider.getActorById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvName = getView().findViewById(R.id.tv_name);
        tvName.setText(ActorProvider.getActorById(position).getName());

        TextView tvBiography = getView().findViewById(R.id.tv_biography);
        tvBiography.setText(ActorProvider.getActorById(position).getBiography());

        TextView tvDoB = getView().findViewById(R.id.tv_dob);
        tvDoB.setText((CharSequence) ActorProvider.getActorById(position).getDoB());

        TextView tvRating = getView().findViewById(R.id.tv_rating);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedValue = decimalFormat.format(ActorProvider.getActorById(position).getRating());
        tvRating.setText(formattedValue);

        final List<Film> films = ActorProvider.getActorById(position).getFilms();
        final List<String> filmNames = new ArrayList<>();
        for (Film film : films) {
            String output = film.getName();
            filmNames.add(output);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.film_list_item, filmNames );
        ListView lvFilms = getView().findViewById(R.id.lv_films);
        lvFilms.setAdapter(dataAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }
}
