package com.cjs.notebook;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class weihuzhe extends Activity implements View.OnClickListener {
    private Button save;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weihu);
        restoreData();
        save = findViewById(R.id.save_data);
        save.setOnClickListener(this);

    }

    private void restoreData() {
        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
        //获取姓名

    String name = prefs.getString("name", "");
    EditText nameText = (EditText) findViewById(R.id.name);
        nameText.setText(name);
}

    public void onClick(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();

    //获取姓名
    EditText name = findViewById(R.id.name);

    editor.putString("name", name.getText().toString());

    editor.commit();
    finish();

}
}

