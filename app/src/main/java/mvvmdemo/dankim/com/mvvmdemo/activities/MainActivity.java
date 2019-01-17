package mvvmdemo.dankim.com.mvvmdemo.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import mvvmdemo.dankim.com.mvvmdemo.R;
import mvvmdemo.dankim.com.mvvmdemo.adpaters.RecyclerViewAdapter;
import mvvmdemo.dankim.com.mvvmdemo.models.NicePlace;
import mvvmdemo.dankim.com.mvvmdemo.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.Callback {

    private FloatingActionButton floatingActionButton;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.prgress_bar);

        initFloatingActionButton();
        // ViewModel observes
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                adapter.update(nicePlaces);
            }
        });

        initRecyclerView();
    }

    private void initFloatingActionButton() {

        floatingActionButton = findViewById(R.id.float_button);
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(this, viewModel.getNicePlaces().getValue());
        adapter.setCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(String imageUrl, String imageName) {

        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra(DetailedActivity.EXTRA_IMAGE_URL, imageUrl);
        intent.putExtra(DetailedActivity.EXTRA_IMAGE_NAME, imageName);
        startActivity(intent);
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
