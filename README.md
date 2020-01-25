# ArrayInSharedPref
Sample app for Stackoverflow question : https://stackoverflow.com/questions/59908088/how-to-save-float-array-in-sharedpreferences/


# Method to save & retrieve Float array to & from shared pref.


```java
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


```
