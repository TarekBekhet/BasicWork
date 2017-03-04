package company.com.basicwork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class LoadingSpinner extends Activity {
    Button b1;

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_spinner);

        b1 = (Button) findViewById(R.id.button);
        spinner = (ProgressBar) findViewById(R.id.progBar);
        spinner.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
            }
        });
    }
}