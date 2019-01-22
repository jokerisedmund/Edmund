package my.edmund_yapcom.edmundyap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class InsertActivity  extends AppCompatActivity {

    private EditText editTextPassportNum, editTextFirstName, editTextLastName;
    public static final String INSERT_PASSPORT = "my.edu.tarc.demoroom.PHONE";
    public static final String INSERT_LAST = "my.edu.tarc.demoroom.LAST";
    public static final String INSERT_FIRST = "my.edu.tarc.demoroom.FIRST";
    private int itemvalue;

    public InsertActivity(int itemvalue) {
        this.itemvalue = itemvalue;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        editTextPassportNum = findViewById(R.id.editTextPassportNum);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editTextPassportNum.getText())){
                    editTextPassportNum.setError("Passport is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextFirstName.getText())){
                    editTextFirstName.setError("First name is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextLastName.getText())){
                    editTextLastName.setError("Last name is empty.");
                    return;
                }
                String passport, firstName, lastName;
                passport = editTextPassportNum.getText().toString();
                firstName = editTextFirstName.getText().toString();
                lastName = editTextLastName.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(INSERT_PASSPORT, passport);
                intent.putExtra(INSERT_FIRST, firstName);
                intent.putExtra(INSERT_LAST, lastName);
                setResult(RESULT_OK, intent);
                finish();

                int years = Integer.parseInt(passport);
                int fee = 0;
                if( itemvalue == 2 )
                {
                    fee = 0;
                }
                else if(itemvalue == 1)
                {
                    fee = 100;
                }
                else if(itemvalue == 0)
                {
                    if(years > 60 || years <12)
                    {
                        fee = 100;
                    }
                    else
                    {
                        fee = 200;
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
    }

}
