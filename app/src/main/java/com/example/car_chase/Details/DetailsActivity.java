package com.example.car_chase.Details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.car_chase.R;

public class DetailsActivity extends AppCompatActivity {
    private static final int MAX_LINES_COLLAPSED = 2; // Number of lines to show when collapsed
    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        LinearLayout backBtn = findViewById(R.id.detailBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        final TextView textViewContent = findViewById(R.id.detailDescriptionTxt);

        textViewContent.post(() -> {
            if (textViewContent.getLineCount() > MAX_LINES_COLLAPSED) {
                addSeeMoreText(textViewContent);
            }
        });

        textViewContent.setOnClickListener(v -> {
            if (!isExpanded) {
                textViewContent.setMaxLines(Integer.MAX_VALUE); // Expand TextView to show full text
                textViewContent.setEllipsize(null); // Remove ellipsis
                isExpanded = true;
                addSeeLessText(textViewContent);
            } else {
                textViewContent.setMaxLines(MAX_LINES_COLLAPSED); // Collapse TextView to show fewer lines
                textViewContent.setEllipsize(TextUtils.TruncateAt.END); // Add ellipsis at the end of text
                isExpanded = false;
                addSeeMoreText(textViewContent);
            }
        });
    }
    private void addSeeMoreText(TextView textView) {
        String text = textView.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text + " See More");
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(DetailsActivity.this, "See More Clicked!", Toast.LENGTH_SHORT).show();
                // Handle See More Click
                // Expand the TextView here if needed
                // Example: textView.setMaxLines(Integer.MAX_VALUE);
            }
        }, text.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }

    private void addSeeLessText(TextView textView) {
        String text = textView.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text + " See Less");
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(DetailsActivity.this, "See Less Clicked!", Toast.LENGTH_SHORT).show();
                // Handle See Less Click
                // Collapse the TextView here if needed
                // Example: textView.setMaxLines(MAX_LINES_COLLAPSED);
            }
        }, text.length(), spannableStringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }
}