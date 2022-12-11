package com.example.onepoint_ourtree.activities.details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.onepoint_ourtree.activities.BaseActivities;
import com.example.onepoint_ourtree.R;
import com.example.onepoint_ourtree.api.models.Tree;

public class DescriptionActivity extends BaseActivities {

    public static final String EXTRA_TREE = "TREE";
    private TextView nomLabel, especeLabel, hauteurLabel, circonferenceLabel, adresseLabel;
    private Tree tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        this.init(this);
        this.getExtractData();
        this.findViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setupData();
    }

    @Override
    public void onBackPressed() {
        this.onBackClicked(null);
    }

    private void getExtractData() {
        this.tree = (Tree) getIntent().getSerializableExtra(EXTRA_TREE);
        if (this.tree == null) finish();
    }

    private void findViews() {
        this.nomLabel = findViewById(R.id.name_tree);
        this.hauteurLabel = findViewById(R.id.hauteur);
        this.especeLabel = findViewById(R.id.espece);
        this.circonferenceLabel = findViewById(R.id.circonference);
        this.adresseLabel = findViewById(R.id.adresse);
    }

    @SuppressLint("SetTextI18n")
    private void setupData() {
        if (this.tree == null) return;
        this.nomLabel.setText(this.tree.getNom());
        this.especeLabel.setText(this.tree.getEspece());
        this.hauteurLabel.setText("" + this.tree.getHauteur());
        this.circonferenceLabel.setText("" + this.tree.getCirconference());
        this.adresseLabel.setText(this.tree.getAdresse());
    }

    public void onBackClicked(View view) {
        finish();
    }
}