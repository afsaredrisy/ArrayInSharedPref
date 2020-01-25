package co.myapp.arrayinsharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String PREF_NAME = "AndroidHivePref";
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    public SharedPrefManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveFloatArray(float[] arr){
        String str = " ";
        for(int i=0;i<arr.length;i++){
            str = str + ", "+ String.valueOf(arr[i]);
        }
        editor.putString("FLOAT_ARR",str);
        editor.commit();
    }

    public float[] getFloatArray(){
        String str = pref.getString("FLOAT_ARR", null);
        if(str!=null){
            String str1[] = str.split(",");
            float arr[] = new float[str1.length-1];
            // at i=0 it is space so start from 1
            for(int i=1;i<str1.length;i++){
                arr[i-1]=Float.parseFloat(str1[i]);
            }
            return arr;
        }
        return null;
    }



}
