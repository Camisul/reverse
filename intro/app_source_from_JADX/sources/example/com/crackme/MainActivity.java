package example.com.crackme;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button button;
    private EditText edit;
    private boolean reset = false;
    private TextView view;

    public void onClick(View v) {
        if (!this.reset) {
            String v0 = this.edit.getText().toString();
            Toast.makeText(getApplicationContext(), v0, 1).show();
            if (Checker.check(v0, this)) {
                this.view.setText(C0329R.string.good);
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#36967c"));
                this.button.setText(C0329R.string.TryAgain);
            } else {
                this.view.setText(C0329R.string.bad);
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#AA3939"));
                this.button.setText(C0329R.string.TryAgain);
            }
            this.reset = true;
            return;
        }
        this.view.setText(C0329R.string.hello_world);
        getWindow().getDecorView().setBackgroundColor(-1);
        this.button.setText(C0329R.string.button);
        this.reset = false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0329R.layout.activity_main);
        this.edit = (EditText) findViewById(C0329R.C0331id.input);
        this.view = (TextView) findViewById(C0329R.C0331id.textView1);
        this.button = (Button) findViewById(C0329R.C0331id.button);
        this.button.setOnClickListener(this);
    }
}
