package co.myapp.arrayinsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        prefManager = new SharedPrefManager(this);
        saveDemoArray();
        displayDemoArray();

    }

    private void saveDemoArray(){
        float[] sampleArray = {
                0f,0.4f,05f
        };

        prefManager.saveFloatArray(sampleArray);
    }

    private void displayDemoArray(){
        float [] sampleArray = prefManager.getFloatArray();
        if(sampleArray!=null){
            String str = "Values from shared pref ";
            for(float f: sampleArray){
                str = str+" , "+f;
            }
            textView.setText(str);
        }
    }

}
